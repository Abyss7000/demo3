package Mypack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

        @FXML
        private Button button1;

        @FXML
        private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;


        @FXML
    private void handleButton1Action(ActionEvent event) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HelloController.class.getResource("NewWindow.fxml"));
            try{
                loader.load();
            } catch (IOException e){
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();


    }

    // Event handler for button2
    @FXML
    private void handleButton2Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("Mobo.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();



    }

    @FXML
    private void handleButton3Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("Memory.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

    @FXML
    private void handleButton4Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("PSU.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

    @FXML
    private void handleButton5Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("Cooler.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

    @FXML
    private void handleButton6Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("Case.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

    @FXML
    private void handleButton7Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("Storage.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

    @FXML
    private void handleButton8Action(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("GPU.fxml"));
        try{
            loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();


    }

}
