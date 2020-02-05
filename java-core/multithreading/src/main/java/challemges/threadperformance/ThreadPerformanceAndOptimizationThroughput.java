package challemges.threadperformance;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
Performance in multithreading
 -- Latency - The time to completion of a task, measured in time units
 -- Throughput - The amount of task completed in a given period, measured in task/time unit
 */
// HTTP server

public class ThreadPerformanceAndOptimizationThroughput {
    public static final String BOOK_PATH = "W:\\projetos\\coding-challenges\\challenge-020-multithreading\\src\\main\\resources\\war_and_peace.txt";
    public static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(BOOK_PATH)));
        startServer(text);

    }

    private static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();

    }

    private static class WordCountHandler implements HttpHandler {

        private String text;

        public WordCountHandler(String text) {
            this.text = text;
        }


        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();
            String[] keyValue = query.split("=");
            String action = keyValue[0];
            String word = keyValue[1];
            if (!action.equals("word")) {
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }
            long count = countWord(word);

            byte[] response = Long.toString(count).getBytes();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }

        private long countWord(String word) {
            long count = 0;
            int index = 0;
            while (index >= 0) {
                index = text.indexOf(word, index);
                if (index >= 0) {
                    count++;
                    index++;
                }
            }
            return count;
        }
    }
}
