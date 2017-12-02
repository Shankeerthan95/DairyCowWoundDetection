package com.ano;

import com.shankeerthan.ColorSeparator;
import javafx.scene.paint.Color;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;
import mockit.Deencapsulation;
import java.lang.reflect.Method;

public class ColorSeparatorTest {

    @Test
    public void getDistanceTest() throws Exception{
        Class c = Class.forName("com.shankeerthan.ColorSeparator");
        ColorSeparator colorSeparator = (ColorSeparator) c.newInstance();
        Method m = c.getDeclaredMethod("getDistance", double.class, double.class, double.class, double.class, double.class, double.class);
        m.setAccessible(true);
        double distance=(double)m.invoke(colorSeparator,0,0,0,1,2,3);
        assertEquals(3.7416573867739413,distance,0);
    }

    @Test
    public void getDistanceTestReal() throws Exception{
        Class c = Class.forName("com.shankeerthan.ColorSeparator");
        ColorSeparator colorSeparator = (ColorSeparator) c.newInstance();
        Method m = c.getDeclaredMethod("getDistance", double.class, double.class, double.class, double.class, double.class, double.class);
        m.setAccessible(true);
        double distance=(double)m.invoke(colorSeparator,1,0,0,0,0,1);
        assertEquals(1.414213562,distance,0.000000001);
    }

    @Test
    public void compareColorsTest(){
        boolean val = ColorSeparator.compareColors(Color.RED,Color.BLUE,2);
        System.out.println(Color.BLUE.getRed());
        assertTrue(val==true);
    }

}