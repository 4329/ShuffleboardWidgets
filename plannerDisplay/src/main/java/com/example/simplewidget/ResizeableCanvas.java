package com.example.simplewidget;

import javafx.scene.canvas.Canvas;

public class ResizeableCanvas extends Canvas {
    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double maxHeight(double width) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double maxWidth(double height) {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public double minWidth(double height) {
        return 1D;
    }

    @Override
    public double minHeight(double width) {
        return 1D;
    }

    @Override
    public void resize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }
}