package Mypack.Controllers;

import Mypack.ComputerParts.ButtonCellFactory;
import Mypack.ComputerParts.CPU;
import Mypack.Database;
import Mypack.Controllers.Shop;
import Mypack.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class CPUController {


    @FXML
    private TableView<CPU> table;

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
        column1.setCellValueFactory(new PropertyValueFactory<>("idCPU"));
        column2.setCellValueFactory(new PropertyValueFactory<>("CPU_Brand"));
        column3.setCellValueFactory(new PropertyValueFactory<>("CPU_Model"));
        column4.setCellValueFactory(new PropertyValueFactory<>("CPU_Price"));
        column5.setCellValueFactory(new PropertyValueFactory<>("CPU_Amount"));

        // Connect to the database and retrieve the data
        Database database = new Database();

        database.setTable("store_cpu");
        ResultSet rs = database.ConnectDatabase(database.getStmt(), database.getConn(), database.getRs());

        // Use the ResultSet to populate the TableView
        while (rs.next()) {
            int idCPU = rs.getInt("idCPU");
            String CPU_Brand = rs.getString("CPU_Brand");
            String CPU_Model = rs.getString("CPU_Model");
            double CPU_Price = rs.getDouble("CPU_Price");
            int CPU_Amount = rs.getInt("CPU_Amount");

            // Create a new Database object and add it to the TableView
            CPU cpu = new CPU(idCPU, CPU_Brand, CPU_Model, CPU_Price, CPU_Amount);
            table.getItems().add(cpu);
        }


// Define the callback function
        TableColumn<CPU, Void> colBtn = new TableColumn("Purchase");
        Callback<CPU, Void> callback = (CPU cpu) -> {

            // Get the id, model, and price of the CPU object
            int id = cpu.getIdCPU();
            String part = cpu.getPart();
            String model = cpu.getCPU_Model();
            double price = cpu.getCPU_Price();
            // Add the data to the array in the Shop class
            Shop.addToArray(id, part, model, price);
            //Shop.printArray();
return null;
        };

        colBtn.setCellFactory(new ButtonCellFactory<>(callback));
        table.getColumns().add(colBtn);
// Close the database connection
        //database.CloseDatabase();

    }

}