package com.example.pricingprogram;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PricingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PricingApplication.class.getResource("pricing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 795, 637);
        stage.setTitle("Get that job!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}