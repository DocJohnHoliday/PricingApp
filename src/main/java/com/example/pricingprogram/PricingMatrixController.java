package com.example.pricingprogram;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PricingMatrixController implements Initializable {

    public TableColumn<MatrixSquare, String> tableLabel;
    public TableColumn<MatrixSquare, String> twelve;
    public TableColumn<MatrixSquare, String> twentyFour;
    public TableColumn<MatrixSquare, String> thirtySix;
    public TableColumn<MatrixSquare, String> fortyEight;
    public TableColumn<MatrixSquare, String> sixty;
    public TableColumn<MatrixSquare, String> seventyTwo;
    public TableColumn<MatrixSquare, String> eightyFour;
    public TableColumn<MatrixSquare, String> oneHundredEight;
    public TableColumn<MatrixSquare, String> oneHundredTwenty;
    public TableColumn<MatrixSquare, String> oneHundredThirtyTwo;
    public TableColumn<MatrixSquare, String> oneHundredFortyFour;
    public TableView<MatrixSquare> pricingMatrixTable;

    double glassPriceChange = 12;
    double metalPriceChange = 1.60;

//    ObservableList<MatrixSquare> initialData() {
//        MatrixSquare firstRow = new MatrixSquare("2",);
//    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        int num = 0;
        for(int i = 0; i < 144; i++) {
            num = i;
            String leftValue = String.valueOf(num);
        }
        tableLabel.setCellValueFactory(new PropertyValueFactory<>("leftValue"));

    }
}
