module fr.btsciel.tp_liason_serie {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens fr.btsciel.tp_liason_serie to javafx.fxml;
    exports fr.btsciel.tp_liason_serie;
}