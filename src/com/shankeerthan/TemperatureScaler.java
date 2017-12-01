package com.shankeerthan;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/*
This class contains methods to
convert Temparature Scale to Color Scale
 */
public class TemperatureScaler {
    private double scaleMax, scaleMin;
    private double rangeMax, rangeMin;
    private int colorPallete;
    private Image palleteImage;
    private double factor;

    public TemperatureScaler(double scaleMax, double scaleMin, double rangeMax, double rangeMin, int colorPallete) {
        this.scaleMax = scaleMax;
        this.scaleMin=scaleMin;
        this.rangeMax=rangeMax;
        this.rangeMin = rangeMin;
        this.colorPallete=colorPallete;
        openImage();
    }

    /*
    It return Coordinate X value of Color Pallete Image in crross line and given distance rangeMaxORMin from  Origin
     */
    public static double getCoordinateX(double scaleMax, double scaleMin, double rangeMaxOrMin, Image image) {
        double height = image.getHeight();
        double width = image.getWidth();
        double factor = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2)) / (scaleMax - scaleMin);

        //double sinTheta=height/Math.sqrt(Math.pow(height,2)+Math.pow(width,2));
        double cosTheta = width / Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));

        return cosTheta * (scaleMax - rangeMaxOrMin) * factor;
    }

    /*
    It return Coordinate Y value of Color Pallete Image in crross line and given distance rangeMaxORMin from  Origin
     */
    public static double getCoordinateY(double scaleMax, double scaleMin, double rangeMaxOrMin, Image image) {
        double height = image.getHeight();
        double width = image.getWidth();
        double factor = Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2)) / (scaleMax - scaleMin);

        double sinTheta = height / Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));

        return sinTheta * (scaleMax - rangeMaxOrMin) * factor;
    }

    /*
    This method assigning correct Palllete Image to palleteImage Reference
    according to ColorPallete value
     */
    private void openImage() {
        /*
        This mehod open color pallete image according to given
        integer colorPalllete
         */
        switch (colorPallete) {
            case Values.FUSION:
                palleteImage = new Image("file:" + "ColorPalletes/fusion.png");
                break;
            case Values.IRONBOW_1:
                palleteImage = new Image("file:" + "ColorPalletes/ironbow_1.png");
                break;
            case Values.IRONBOW_2:
                palleteImage = new Image("file:" + "ColorPalletes/ironbow_2.png");
                break;
            case Values.RAINBOW:
                palleteImage = new Image("file:" + "ColorPalletes/rainbow.png");
                break;
            case Values.RAIN:
                palleteImage = new Image("file:" + "ColorPalletes/rain.png");
                break;
            case Values.SEPIA:
                palleteImage = new Image("file:" + "ColorPalletes/sepia.png");
                break;
            case Values.GLOWBOW:
                palleteImage = new Image("file:" + "ColorPalletes/glowbow.png");
                break;
            case Values.WHITE_HOT:
                palleteImage = new Image("file:" + "ColorPalletes/white_hot.png");
                break;
            case Values.BLACK_HOT:
                palleteImage = new Image("file:" + "ColorPalletes/black_hot.png");
                break;
            case Values.ICE_AND_FIRE:
                palleteImage = new Image("file:" + "ColorPalletes/iceandfire.png");
                break;
            case Values.COLOR_1:
                palleteImage = new Image("file:" + "ColorPalletes/color1.png");
                break;
            case Values.COLOR_2:
                palleteImage = new Image("file:" + "ColorPalletes/color2.png");

        }

    }

    /*
    This method return one color edge of Range to calculate radius
     */
    public Color getRangeColor() {
        double x = palleteImage.getWidth() * (scaleMax - rangeMax) / (scaleMax - scaleMin);//getCoordinateX(scaleMax,scaleMin,rangeMax,palleteImage);
        double y = palleteImage.getHeight() * (scaleMax - rangeMax) / (scaleMax - scaleMin);//getCoordinateY(scaleMax,scaleMin,rangeMax,palleteImage);
        //System.out.println(x+" "+y);
        return palleteImage.getPixelReader().getColor((int) x, (int) y);
    }

    public Color getMidColor() {
        double x1 = palleteImage.getWidth() * (scaleMax - rangeMax) / (scaleMax - scaleMin);//getCoordinateX(scaleMax,scaleMin,rangeMax,palleteImage);
        double y1 = palleteImage.getHeight() * (scaleMax - rangeMax) / (scaleMax - scaleMin);//getCoordinateY(scaleMax,scaleMin,rangeMax,palleteImage);

        double x2 = palleteImage.getWidth() * (scaleMax - rangeMin) / (scaleMax - scaleMin);//getCoordinateX(scaleMax,scaleMin,rangeMin,palleteImage);
        double y2 = palleteImage.getHeight() * (scaleMax - rangeMin) / (scaleMax - scaleMin);//getCoordinateY(scaleMax,scaleMin,rangeMin,palleteImage);
        // System.out.println(x1+"  "+y1);
        //System.out.println(x2+" "+y2);
        return palleteImage.getPixelReader().getColor((int) (x1 + x2) / 2, (int) (y1 + y2) / 2);
    }

    public double getRadius() {
        Color color1 = getMidColor();
        Color color2 = getRangeColor();

        double radius = ColorSeparator.getDistance(color1.getRed(), color1.getGreen(), color1.getBlue(), color2.getRed(), color2.getGreen(), color2.getBlue());
        return radius;
    }


}