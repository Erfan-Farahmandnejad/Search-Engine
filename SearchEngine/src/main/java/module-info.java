module com.example.searchengine {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.searchengine to javafx.fxml;
    exports com.example.searchengine;
    exports com.example.searchengine.MapImplementation;
    opens com.example.searchengine.MapImplementation to javafx.fxml;
}