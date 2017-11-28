package com.shankeerthan;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;

/*
This class has the functionalities of coverting temperature scale to
Color Scale and give what is the interest of Range Color value and radius
 */
public class TemperatureScaler {
    private double scaleMax;
    private double scaleMin;
    private double rangeMax;
    private double rangeMin;
    private int colorPallete;
    private Image colorPalleteImage;
    private Color [] rangeColors;

    public TemperatureScaler(double scaleMax,double scaleMin,double rangeMax,double rangeMin,int colorPallete){
        this.scaleMax=scaleMax;
        this.scaleMin=scaleMin;
        this.rangeMax=rangeMax;
        this.rangeMin=rangeMin;
        this.colorPallete=colorPallete;
        colorPalleteImage=getColorPallete();
        rangeColors =new Color[Values.SIZE_RANGE_COLORS];
    }

    private Image getColorPallete(){
        Image colorPalleteImage =null;
        switch(colorPallete){
            case 0: colorPalleteImage=new Image("file:"+"Color Palletes/fusion.png");
            case 1: colorPalleteImage=new Image("file:"+"Color Palletes/ironbow_1.png");
            case 2: colorPalleteImage=new Image("file:"+"Color Palletes/ironbow_2.png");
            case 3: colorPalleteImage=new Image("file:"+"Color Palletes/rainbow.png");
            case 4: colorPalleteImage=new Image("file:"+"Color Palletes/rain.png");
            case 5: colorPalleteImage=new Image("file:"+"Color Palletes/sepia.png");
            case 6: colorPalleteImage=new Image("file:"+"Color Palletes/glowbow.png");
            case 7: colorPalleteImage=new Image("file:"+"Color Palletes/white_hot.png");
            case 8: colorPalleteImage=new Image("file:"+"Color Palletes/black_hot.png");
            case 9: colorPalleteImage=new Image("file:"+"Color Palletes/iceandfire.png");
            case 10: colorPalleteImage=new Image("file:"+"Color Palletes/color1.png");
            case 11: colorPalleteImage=new Image("file:"+"Color Palletes/color2.png");
        }
        return colorPalleteImage;
    }

    private double getGradient(){
        double width=colorPalleteImage.getWidth();
        double height=colorPalleteImage.getHeight();

        return height/width;
    }

    private void addColors(){

    }
    /*
    This method return an array of x, y of point
     */
    public static void getCircularPathCoordinates(int orginX,int orginY,double radius){

    }

}
