package com.example.pricingprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PricingController implements Initializable {
    public ChoiceBox<String> unitPricingBox;
    public ChoiceBox<Integer> panelsChoice;
    public ChoiceBox<Integer> midRailBox;
    public ChoiceBox<String> glassBox;
    public TextField widthText;
    public TextField heightText;
    @FXML
    private Label finalPricingText;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitPricingBox.getItems().add("Unit Pricing");
        unitPricingBox.getItems().add("Standard AP Pricing");
        unitPricingBox.setValue("Standard AP Pricing");

        for (int i = 1; i < 10; i++)
            panelsChoice.getItems().add(i);
        panelsChoice.setValue(1);

        for (int i = 0; i < 10; i++)
            midRailBox.getItems().add(i);
        midRailBox.setValue(0);

        glassBox.getItems().add("IG 1\" Clear");
        glassBox.getItems().add("IG Tinted\"");
        glassBox.getItems().add("IG 1\"Low E");
        glassBox.getItems().add("1/4\"");
        glassBox.getItems().add("1/4\" Tinted");
        glassBox.getItems().add("3/16\"");
        glassBox.getItems().add("3/16\" Tinted");
        glassBox.getItems().add("Low E");
    }

    @FXML
    protected void computeButton() {

        MathFormulas mathFormulas = new MathFormulas();

        String pricingType = unitPricingBox.getValue();
        String widthString = widthText.getText();
        String heightString = heightText.getText();

        double widthDouble = mathFormulas.fractionToDecimal(widthString);
        double heightDouble = mathFormulas.fractionToDecimal(heightString);

        int panels = panelsChoice.getValue();
        int midRails = midRailBox.getValue();

        double glassPriceChange = 12;
        double metalPriceChange = 1.60;

        if (pricingType.equals("Standard AP Pricing")) {
            double glassSize = mathFormulas.glassSquareFootage(widthDouble, heightDouble, glassPriceChange);
            double metalLength = mathFormulas.metalLinearFoot(widthDouble, heightDouble, metalPriceChange, panels, midRails);
            double sum = Math.ceil(metalLength + glassSize);
            int totalCost = (int) sum;

            finalPricingText.setText("$" + totalCost);
        } else {
            double glassSize = mathFormulas.glassSquareFootage(widthDouble, heightDouble, glassPriceChange);
            double metalLength = mathFormulas.metalLinearFootUnited(widthDouble, heightDouble);
            double totalCost = glassSize + metalLength;

            finalPricingText.setText("$" + totalCost);
        }
    }

    public void toMatrixButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pricing-matrix.fxml"));
        loader.load();

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        Parent scene = loader.getRoot();
        stage.setScene(new Scene(scene));
        stage.show();
    }
}