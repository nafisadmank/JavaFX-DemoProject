package com.example.demo16;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class inputOutput {
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneNoField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel;
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<String, String> nameColumn;
    private ObservableList<String> names = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }
    @FXML
    public void addName(ActionEvent actionEvent) throws IOException {
        String name = nameField.getText();
        String phoneNo = phoneNoField.getText();
        String password = passwordField.getText();
        if (name.isEmpty() || phoneNo.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please Fill out all the boxes");
            return;
        }else if(names.contains(name)){
            errorLabel.setText("Already signed up. Sign In");
            return;
        }
        errorLabel.setText("Sign Up Successful");
        names.add(name);
        tableView.setItems(names);
        nameField.clear();
        phoneNoField.clear();
        passwordField.clear();
    }
}
