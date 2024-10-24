package com.example.math;

public class SubtractionPlugin implements MathOperationPlugin {

    @Override
    public String getName() {
        return "Subtraction";
    }

    @Override
    public double apply(double a, double b) {
        return a - b;
    }
}
