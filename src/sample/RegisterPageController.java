package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegisterPageController {
    Admin admin = new Admin();
    Account account = new Account();
    Alert alert;
    @FXML
    private TextField loginTextfield;

    @FXML
    private PasswordField passwordTextfield;

    @FXML
    private Button RegisterButton, backButton;

    @FXML
    void RegisterButtonOnAction() throws IOException {
        if (loginTextfield.getText().length() > 3 && passwordTextfield.getText().length() > 3) {
            admin.addAccount(new Account(loginTextfield.getText(), passwordTextfield.getText(), 0));
            account.access = true;
            admin.showTab();


            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account created\n");
            alert.setHeaderText("Account successfully created.\n\n");
            alert.showAndWait();

        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Try again");
            alert.setHeaderText("Please try again.\n");
            alert.showAndWait();
        }
    }

    @FXML
    void backButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 600));
    }


}

