module org.example.uap {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.uap to javafx.fxml;
    exports org.example.uap;
}