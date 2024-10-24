package com.example.math;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class MathOperationPluginManager {

    private List<MathOperationPlugin> plugins = new ArrayList<>();

    public MathOperationPluginManager() {
        loadPlugins();
    }

    private void loadPlugins() {
        ServiceLoader<MathOperationPlugin> loader = ServiceLoader.load(MathOperationPlugin.class);
        for (MathOperationPlugin plugin : loader) {
            plugins.add(plugin);
        }
    }

    public List<MathOperationPlugin> getAvailableOperations() {
        return plugins;
    }

    public double applyOperation(String operationName, double a, double b) {
        for (MathOperationPlugin plugin : plugins) {
            if (plugin.getName().equals(operationName)) {
                return plugin.apply(a, b);
            }
        }
        throw new IllegalArgumentException("Invalid operation name: " + operationName);
    }

    public static void main(String[] args) {
        MathOperationPluginManager manager = new MathOperationPluginManager();

        for (MathOperationPlugin plugin : manager.getAvailableOperations()) {
            System.out.println("Operation: " + plugin.getName());
        }

        double result = manager.applyOperation("Addition", 10.0, 20.0);
        System.out.println("Result: " + result); // Output: Result: 30.0

        result = manager.applyOperation("Subtraction", 30.0, 15.0);
        System.out.println("Result: " + result); // Output: Result: 15.0
    }
}
