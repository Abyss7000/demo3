package Mypack.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import Mypack.ComputerParts.CPU;
import Mypack.Database;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CPUController {


    @FXML
    private TableView<Database> table;

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
            CPU cpu = new CPU (idCPU, CPU_Brand, CPU_Model, CPU_Price, CPU_Amount);
            table.getItems().add(cpu);
        }

        // Close the database connection
        database.CloseDatabase();
    }
}