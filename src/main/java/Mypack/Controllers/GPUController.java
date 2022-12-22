package Mypack.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import Mypack.ComputerParts.ButtonCellFactory;
import Mypack.ComputerParts.Case;
import Mypack.ComputerParts.Cooler;
import Mypack.ComputerParts.GPU;
import Mypack.Database;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class GPUController {


    @FXML
    private TableView<GPU> table;

    @FXML
    private TableColumn<Database, String> column1;

    @FXML
    private TableColumn<Database, String> column2;

    @FXML
    private TableColumn<Database, String> column3;

    @FXML
    private TableColumn<Database, String> column4;

    @FXML
    private TableColumn<Database, String> column5;

    @FXML
    private TableColumn<Database, String> column6;



    @FXML
    public void initialize() throws SQLException {
        // Initialize the table columns
        column1.setCellValueFactory(new PropertyValueFactory<>("id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        column3.setCellValueFactory(new PropertyValueFactory<>("Model"));
        column4.setCellValueFactory(new PropertyValueFactory<>("Price"));
        column5.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        // Connect to the database and retrieve the data
        Database database = new Database();
        database.setTable("pcstore.gpu");
        ResultSet rs = database.ConnectDatabase(database.getStmt(), database.getConn(), database.getRs());

        // Use the ResultSet to populate the TableView
        while (rs.next()) {
            int id = rs.getInt("id");
            String BrandName = rs.getString("BrandName");
            String Model = rs.getString("Model");
            double Price = rs.getDouble("Price");
            int Amount = rs.getInt("Quantity");

            // Create a new Database object and add it to the TableView
            GPU gpu = new GPU (id, BrandName, Model, Price, Amount);
            table.getItems().add(gpu);
        }

        TableColumn<GPU, Void> colBtn = new TableColumn("Purchase");
        Callback<GPU, Void> callback = (GPU gpu) -> {

            // Get the id, model, and price of the CPU object
            int id = gpu.getId();
            String part = gpu.getPart();
            String model = gpu.getModel();
            double price = gpu.getPrice();

            // Add the data to the array in the Shop class
            Shop.addToArray(id, part, model, price);

            return null;
        };
        colBtn.setCellFactory(new ButtonCellFactory<>(callback));
        table.getColumns().add(colBtn);
    }
}