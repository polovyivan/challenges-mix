package com.ivan.polovyi.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.UUID;

public class AWSBucketInteraction {

  private static String bucketName;
  private static String awsAccessKey;
  private static String awsAccessSecretKey;
  private static String serviceEndpoint;
  private static String signingRegion;
  private static AmazonS3 s3Client;

  public static void main(String[] args) {
    try {
      getProperties();
      getAmazonS3();
      createBucket();
      putObjectToS3Bucket();
      deleteObjectsFromBucket();
      deleteVersions();
      s3Client.deleteBucket(bucketName);
    } catch (AmazonServiceException e) {
      System.out.println("e.getStackTrace() = " + e);
    } catch (SdkClientException e) {
      System.out.println("e.getStackTrace() = " + e);
    }
  }

  private static void deleteVersions() {
    VersionListing versionListing = s3Client
        .listVersions(new ListVersionsRequest().withBucketName(bucketName));

    while (true) {
      Iterator<S3VersionSummary> s3VersionSummaryIterator = versionListing.getVersionSummaries()
          .iterator();
      while (s3VersionSummaryIterator.hasNext()) {
        S3VersionSummary vs = s3VersionSummaryIterator.next();
        s3Client.deleteVersion(bucketName, vs.getKey(), vs.getVersionId());
      }
      if (versionListing.isTruncated()) {
        versionListing = s3Client.listNextBatchOfVersions(versionListing);
      } else {
        break;
      }
    }
  }

  private static void deleteObjectsFromBucket() {
    ObjectListing objectListing = s3Client.listObjects(bucketName);

    while (true) {
      Iterator<S3ObjectSummary> objectSummaryIterator = objectListing.getObjectSummaries()
          .iterator();
      while (objectSummaryIterator.hasNext()) {
        s3Client.deleteObject(bucketName, objectSummaryIterator.next().getKey());
      }
      if (objectListing.isTruncated()) {
        objectListing = s3Client.listNextBatchOfObjects(objectListing);
      } else {
        break;
      }
    }
  }

  private static void putObjectToS3Bucket() {
    s3Client
        .putObject(bucketName, UUID.randomUUID().toString(), "Uploaded String Object");

    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
        UUID.randomUUID().toString(), new File(System.getProperty("user.dir")
        .concat("/aws/src/main/resources/upload-test-files/file-to-upload")));
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setContentType("plain/text");
    objectMetadata.addUserMetadata("x-amz-meta-title", "ivan-title");
    putObjectRequest.setMetadata(objectMetadata);
    s3Client.putObject(putObjectRequest);
  }

  private static void createBucket() {
    boolean bucketExistV2 = s3Client.doesBucketExistV2(bucketName);
    if (!bucketExistV2) {
      s3Client.createBucket(new CreateBucketRequest(bucketName));

      String bucketLocation = s3Client
          .getBucketLocation(new GetBucketLocationRequest(bucketName));
      System.out.println("bucketLocation = " + bucketLocation);
    }
  }

  private static void getAmazonS3() {
    BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKey, awsAccessSecretKey);
    s3Client = AmazonS3ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
        .withEndpointConfiguration(new EndpointConfiguration(serviceEndpoint, signingRegion))
        .withPathStyleAccessEnabled(true)
        .build();
  }

  private static void getProperties() {
    try (InputStream input = AWSBucketInteraction.class.getClassLoader()
        .getResourceAsStream("properties")) {
      Properties prop = new Properties();
      if (input == null) {
        System.out.println("Sorry, unable to find config.properties");
        return;
      }
      prop.load(input);
      awsAccessKey = prop.getProperty("aws.access-key");
      awsAccessSecretKey = prop.getProperty("aws.secret-key");
      bucketName = prop.getProperty("aws.bucket-name");
      serviceEndpoint = prop.getProperty("aws.service-endpoint");
      signingRegion = prop.getProperty("aws.region");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
