module com.example.pricingprogram {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pricingprogram to javafx.fxml;
    exports com.example.pricingprogram;
}