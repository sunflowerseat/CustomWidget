package com.fancy.customwidget;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        String title = "Q302";
        String[] s = title.trim().split("");
        System.out.println(s.length);
        for (String s1 : s) {
            System.out.println("hah:"+s1);
        }
    }


    public int getRadomInt(int start, int end) {
        return (int) (start + Math.random() * (end - start));
    }


    public double getRadomDouble(double start, double end) {
        return start + Math.random() * (end - start);
    }
}