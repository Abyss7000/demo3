package Mypack.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {

@FXML
private TableView<Shop> table;

    @FXML
    private TableColumn<Shop, Integer> column1;

    @FXML
    private TableColumn<Shop, String> column2;

    @FXML
    private TableColumn<Shop, String> column3;

    @FXML
    private TableColumn<PartData, Integer> column4;



    @FXML
    void initialize() {
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));

        column2.setCellValueFactory(new PropertyValueFactory<>("partType"));

        column3.setCellValueFactory(new PropertyValueFactory<>("model"));

        column4.setCellValueFactory(new PropertyValueFactory<>("price"));

ObservableList<Shop> data = FXCollections.observableArrayList();

// Add the elements from the array to the ObservableList
        for (PartData element : Shop.getDataArray()) {
            data.add(Shop);
        }

// Set the ObservableList as the items of the TableView
        table.setItems(data);

    }

}
