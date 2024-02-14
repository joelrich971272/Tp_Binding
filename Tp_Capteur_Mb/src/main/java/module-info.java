module fr.btsciel.tp_capteur_mb {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.btsciel.tp_capteur_mb to javafx.fxml;
    exports fr.btsciel.tp_capteur_mb;
}