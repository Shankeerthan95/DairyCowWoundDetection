package com.shankeerthan;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.MalformedURLException;

public class ImagingThread implements Runnable {
    private static TemperatureScaler temperatureScaler;
    private File[] files;
    private int low, high;
    private double scaleMax, scaleMin;
    private double rangeMax, rangeMin;
    private Canvas canvas;
    private int pallete;

    public ImagingThread(File[] files, int low, int high, double scaleMax, double scaleMin, double rangeMax, double rangeMin, int colorPallete, Canvas canvas) {
        this.scaleMax = scaleMax;
        this.scaleMin = scaleMin;
        this.rangeMax = rangeMax;
        this.rangeMin = rangeMin;
        this.files = files;
        this.canvas = canvas;
        this.low = low;
        this.high = high;
        pallete = colorPallete;
        temperatureScaler = new TemperatureScaler(scaleMax, scaleMin, rangeMax, rangeMin, pallete);
    }


    @Override
    public void run() {
        //super.run();
        //System.out.println("running");
        //iterate over files

        for (int filesCount = low; filesCount < high; filesCount++) {

            try {


                synchronized (this) {
                    Image image = new Image(files[filesCount].toURI().toURL().toExternalForm());
                    System.out.println(image.getWidth());
                    System.out.println(image.getHeight());

                    ColorSeparator colorSeparator = new ColorSeparator();
                    //System.out.println(temperatureScaler.getMidColor().getRed()+" "+temperatureScaler.getMidColor().getGreen()+" "+temperatureScaler.getMidColor().getBlue());
                    //System.out.println(temperatureScaler.getRadius());

                    colorSeparator.regionOfInterestDetector(image, temperatureScaler.getMidColor(), temperatureScaler.getRadius());
                    canvas.setWidth(image.getWidth());
                    canvas.setHeight(image.getHeight());
                    canvas.getGraphicsContext2D().drawImage(image, 0, 0);
                    colorSeparator.edgeMarker(canvas.getGraphicsContext2D(), Color.RED);

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println(e);
            }

        }

    }
}
