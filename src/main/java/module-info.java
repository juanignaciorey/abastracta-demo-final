module com.example.abastractademofinal {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.abastractademofinal to javafx.fxml;
    exports com.example.abastractademofinal;
}