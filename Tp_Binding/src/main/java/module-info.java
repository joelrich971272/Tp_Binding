module com.example.tp_binding {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tp_binding to javafx.fxml;
    exports com.example.tp_binding;
}