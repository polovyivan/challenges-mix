package com.ivan.polovyi.challemges.threadperformance;


/*
Performance in multithreading
 -- Latency - The time to completion of a task, measured in time units
 -- Throughput - The amount of task completed in a given period, measured in task/time unit
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Picture processing, in given picture paint all white flowers into purple
public class ThreadPerformanceAndOptimizationLatency {

    public static final String SOURCE_FILE = "/W:/projetos/coding-challenges/challenge-020-multithreading/target/classes/many-flowers.jpg";

    public static final String DESTINATION_FILE = "W:\\projetos\\coding-challenges\\challenge-020-multithreading\\src\\main\\resources\\many-flowers1.jpg";

    public static void main(String[] args) throws IOException {

        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        long startTime = System.currentTimeMillis();
//        recolorSingleThread(originalImage, resultImage);
        int numberOfThreads = 1;
        recolorMultipleThreaded(originalImage, resultImage, numberOfThreads);


        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        // 1 thread - 3619
        // 1 thread in multithreaded method - 3566
        // 2 threads in multithreaded method - 3721
        // 4 threads in multithreaded method - 1969
        // 6 threads in multithreaded method - 1705
        // 8 threads in multithreaded method - 1703


        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println("duration = " + duration);
    }

    public static void recolorMultipleThreaded(BufferedImage originalImage, BufferedImage resultImage, int numberOfThreads) {

        List<Thread> threads = new ArrayList<>();
        int width = originalImage.getWidth();
        int height = originalImage.getHeight() / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            final int threadMultiplier = i;
            Thread thread = new Thread(() -> {
                int leftCorner = 0;
                int topCorner = height * threadMultiplier;
                recolorImage(originalImage, resultImage, leftCorner, topCorner, width, height);
            });

            threads.add(thread);
        }

        threads.forEach(t -> t.start());
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    public static void recolorSingleThread(BufferedImage originalImage, BufferedImage resultImage) {
        recolorImage(originalImage, resultImage, 0, 0,
                originalImage.getWidth(), originalImage.getHeight());
    }

    public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner,
                                    int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
                recolorPixel(originalImage, resultImage, x, y);
            }
        }
    }

    public static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;

        if (isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, green - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }
        int newRGB = createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(resultImage, x, y, newRGB);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    public static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static int createRGBFromColors(int red, int green, int blue) {
        int rgb = 0;

        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    public static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    public static int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    public static int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }
}
