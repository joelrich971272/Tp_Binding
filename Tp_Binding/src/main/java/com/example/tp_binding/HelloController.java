package com.example.tp_binding;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Slider slider_Hauteur;
    public Slider slider_Largeur;
    public Rectangle rectangle;

    public TextField hauteur;
    public TextField largeur;
    public TextField surface;
    public TextField perimetre;
    public Circle circle;


    int seuille_hauteur = 1500;
    int seuille_largeur = 250;
    StringConverter sc = new DoubleStringConverter() {
        @Override
        public Double fromString(String value) {
            value = value.replace(",", ".");
            value = value.replace("m", "").trim();
            BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);

            return bd.doubleValue();
        }

        @Override
        public String toString(Double value) {
            DecimalFormat df = new DecimalFormat("#.00");
            return df.format(value);
        }
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RectangleProperty monRectangle = new RectangleProperty() ;
        CircleProperty monCercle = new CircleProperty() ;
        monRectangle.perimetreProperty();
        monRectangle.surfaceProperty();
        monRectangle.hauteurProperty();
        monRectangle.largeurProperty();

        perimetre.textProperty().bind(monRectangle.perimetreProperty().asString("% 2f m"));
        surface.textProperty().bind(monRectangle.surfaceProperty().asString("% 2f m²"));

        Bindings.bindBidirectional(hauteur.textProperty(), monRectangle.hauteurProperty(),sc);
        Bindings.bindBidirectional(largeur.textProperty(),monRectangle.largeurProperty(),sc);

        Bindings.bindBidirectional(hauteur.textProperty(),slider_Hauteur.valueProperty(),sc);
        slider_Hauteur.visibleProperty().bind(Bindings.when(monRectangle.hauteurProperty().greaterThan(100))
                        .then(false)
                .otherwise(true));
        slider_Largeur.visibleProperty().bind(Bindings.when(monRectangle.hauteurProperty().greaterThan(100))
                .then(false)
                .otherwise(true));
        Bindings.bindBidirectional(largeur.textProperty(), slider_Largeur.valueProperty(),sc);


        perimetre.backgroundProperty().bind(Bindings.when(monRectangle.perimetreProperty().greaterThan(100))
                .then(new Background(new BackgroundFill(Color.RED,null,null)))
                .otherwise(new Background(new BackgroundFill(Color.AQUA,null,null))));

        surface.backgroundProperty().bind(Bindings.when(monRectangle.surfaceProperty().greaterThan(100))
                .then(new Background(new BackgroundFill(Color.RED,null,null)))
                .otherwise(new Background(new BackgroundFill(Color.AQUA,null,null))));

        Bindings.bindBidirectional(largeur.textProperty(),rectangle.widthProperty(),sc);
        Bindings.bindBidirectional(hauteur.textProperty(), rectangle.heightProperty(),sc);



    }
}