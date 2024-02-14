package fr.btsciel.tp_fx_charts;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements initializable{
   public LineChart<Number , Number>courbe;
   public XYChart.Series series = new XYChart.Series() ;
   public class intitializable (URL location, ResourceBundle resource){
      courbe.setAnimated(true);
      courbe.setCreateSymbols(false);


   }

}