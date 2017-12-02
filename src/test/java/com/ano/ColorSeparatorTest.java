package com.ano;

import com.shankeerthan.ColorSeparator;
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

}