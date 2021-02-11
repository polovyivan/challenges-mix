package com.ivan.polovyi.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AWSDynamoDBInteraction {

  private static final String TABLE_NAME = "Movies";
  private static final int YEAR = 2015;
  private static final String TITLE = "The Big New Movie";

  private static String awsAccessKey;
  private static String awsAccessSecretKey;
  private static String signingRegion;
  private static String dynamoDBEndpoint;
  private static AmazonDynamoDB amazonDynamoDBClient;
  private static DynamoDB dynamoDB;

  public static void main(String[] args) {
    try {
      getProperties();
      createDynamoDBClient();
      createTable();
      putItem();
      getItem();
      scanForAllItems();
      deleteItem();
      scanForAllItems();
      deleteTable();
    } catch (AmazonServiceException e) {
      System.out.println("e.getStackTrace() = " + e);
    } catch (SdkClientException e) {
      System.out.println("e.getStackTrace() = " + e);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void deleteTable() throws InterruptedException {
    System.out.println("Attempting to delete table; please wait...");
    Table table = dynamoDB.getTable(TABLE_NAME);
    table.delete();
    table.waitForDelete();
    System.out.print("Success.");
  }

  private static void deleteItem() {
    Table table = dynamoDB.getTable(TABLE_NAME);
    DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
        .withPrimaryKey(new PrimaryKey("year", YEAR, "title", "The Big New Movie"));
    DeleteItemOutcome deleteItemOutcome = table.deleteItem(deleteItemSpec);
    System.out.println("deleteItemOutcome = " + deleteItemOutcome);
  }

  private static void scanForAllItems() {
    ScanRequest scanRequest = new ScanRequest()
        .withTableName(TABLE_NAME);
    ScanResult result = amazonDynamoDBClient.scan(scanRequest);
    result.getItems().forEach(System.out::println);
  }

  private static void getItem() {
    Table table = dynamoDB.getTable(TABLE_NAME);
    GetItemSpec spec = new GetItemSpec().withPrimaryKey("year", YEAR, "title", TITLE);
    System.out.println("Attempting to read the item...");
    Item outcome = table.getItem(spec);
    System.out.println("GetItem succeeded: " + outcome);
  }

  private static void putItem() {
    Table table = dynamoDB.getTable(TABLE_NAME);
    final Map<String, Object> infoMap = new HashMap<>();
    infoMap.put("plot", "Nothing happens at all.");
    infoMap.put("rating", 0);

    System.out.println("Adding a new item...");
    int year = YEAR;
    for (int i = 5; i > 0; i--) {
      table
          .putItem(
              new Item().withPrimaryKey("year", year++, "title", TITLE).withMap("info", infoMap));
    }
    System.out.println("PutItem succeeded");
  }

  private static void createTable() throws InterruptedException {
    System.out.println("Attempting to create table; please wait...");
    Table table = dynamoDB.createTable(TABLE_NAME,
        Arrays.asList(new KeySchemaElement("year", KeyType.HASH), // Partition
            // key
            new KeySchemaElement("title", KeyType.RANGE)), // Sort key
        Arrays.asList(new AttributeDefinition("year", ScalarAttributeType.N),
            new AttributeDefinition("title", ScalarAttributeType.S)),
        new ProvisionedThroughput(10L, 10L));
    table.waitForActive();
    System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
  }


  private static void createDynamoDBClient() {
    BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKey, awsAccessSecretKey);
    amazonDynamoDBClient = AmazonDynamoDBClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
        .withEndpointConfiguration(
            new AwsClientBuilder
                .EndpointConfiguration(dynamoDBEndpoint, signingRegion))
        .build();
    dynamoDB = new DynamoDB(amazonDynamoDBClient);
  }

  private static void getProperties() {
    try (InputStream input = AWSDynamoDBInteraction.class.getClassLoader()
        .getResourceAsStream("properties")) {
      Properties prop = new Properties();
      if (input == null) {
        System.out.println("Sorry, unable to find config.properties");
        return;
      }
      prop.load(input);
      awsAccessKey = prop.getProperty("aws.access-key");
      awsAccessSecretKey = prop.getProperty("aws.secret-key");
      signingRegion = prop.getProperty("aws.region");
      dynamoDBEndpoint = prop.getProperty("aws.dynamodb.endpoint");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
