package com.example.tp_binding;

import javafx.beans.property.DoubleProperty;

public class CircleProperty {
    private DoubleProperty rayon ;
    private DoubleProperty perimetre ;



    public DoubleProperty rayonProperty() {

        return rayon;
    }
    public DoubleProperty perimetreProperty() {
        perimetre.add(rayon.multiply(Math.PI*2));
        return perimetre;
    }
    }

