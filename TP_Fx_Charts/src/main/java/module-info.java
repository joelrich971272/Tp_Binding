module fr.btsciel.tp_fx_charts {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.btsciel.tp_fx_charts to javafx.fxml;
    exports fr.btsciel.tp_fx_charts;
}