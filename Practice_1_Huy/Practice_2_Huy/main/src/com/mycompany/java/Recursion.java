package com.mycompany.java;

public class Recursion {
    long factorial( long number) {
        if (number <= 1) // base case
            return 1;
        else
            return number * factorial(number - 1);
    }
}
