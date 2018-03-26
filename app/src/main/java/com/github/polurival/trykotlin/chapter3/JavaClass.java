package com.github.polurival.trykotlin.chapter3;

import java.util.Arrays;
import java.util.List;

/**
 * @author Polurival on 26.03.2018.
 */

public class JavaClass {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 7, 53);

        System.out.println(StringFunctions.joinToStringWithDefaults(list));

        System.out.println(StringFunctions.getOpCount());

        System.out.println(StringFunctions.UNIX_LINE_SEPARATOR);

        System.out.println(StringFunctions.lastChar("Kotlin"));
    }
}
