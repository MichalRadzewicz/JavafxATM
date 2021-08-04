package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Logger;

public class LogInPageController {
    Admin admin = new Admin();
    Account account = new Account();
    Alert alert;


    @FXML
    private TextField loginTextfield, fakepassword;

    @FXML
    private PasswordField passwordTextfield;

    @FXML
    private CheckBox ShowPasswordCheckbox;

    @FXML
    private Button clearButton, logInButton, CreateNewAccount;

    @FXML
    private Hyperlink forgotHyperLink;

    File f = new File("Password.txt");



    @FXML
    void CreateNewAccountOnAction() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
        Stage window = (Stage) logInButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    void ShowPasswordCheckboOnAction() {

        if (ShowPasswordCheckbox.isSelected()) {
            fakepassword.setText(passwordTextfield.getText());
            fakepassword.setVisible(true);
            passwordTextfield.setVisible(false);
            return;
        } else {
            passwordTextfield.setText(fakepassword.getText());
            passwordTextfield.setVisible(true);
            fakepassword.setVisible(false);
        }


    }

    @FXML
    void clearButtonOnAction() {
        loginTextfield.setText("");
        passwordTextfield.setText("");
        fakepassword.setText("");


    }

    @FXML
    void forgotHyperLinkOnAction(ActionEvent event) {

    }

    @FXML
    void logInButtonOnAction() throws IOException {


        if(loginTextfield.getText().equals("mike") &&passwordTextfield.getText().equals("wazowski")  ){
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Stage window = (Stage) logInButton.getScene().getWindow();
            window.setScene(new Scene(root, 900, 700));
        }

//        if(){
//            System.out.println("GIT!");
//
//        }
//        else{
////            alert = new Alert(Alert.AlertType.CONFIRMATION);
////            alert.setTitle("Login ERROR");
////            alert.setHeaderText("Please enter a valid login or password.\n");
////            alert.showAndWait();
//            System.out.println("NIE ZALOGOWANO");
//        }
//        if(admin.Logowanie(loginTextfield,passwordTextfield) == true){
//            admin.Zalogowany(loginTextfield,passwordTextfield);
//            System.out.println("Git");
//        }
//
//        else{
//            alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("login error\n");
//            alert.setHeaderText("Please login again.\n\n");
//            alert.showAndWait();
//            clearButtonOnAction();
//        }


    }


}

