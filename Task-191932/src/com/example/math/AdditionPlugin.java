package com.example.math;

public class AdditionPlugin implements MathOperationPlugin {

    @Override
    public String getName() {
        return "Addition";
    }

    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
