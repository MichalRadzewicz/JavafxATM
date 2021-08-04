package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MoneyTransferController implements Initializable {

   // MainMenuController mainMenuController = new MainMenuController();
    Table_transfer table_transfer = new Table_transfer();



    @FXML
    private ImageView imageBack;
    @FXML
    private Button backButton, confirmButton;
    @FXML
    private TextField recipientsNameTextfield, accountNumberTextfield, transferAmoundTextfield, transferTitleTextfield;
    @FXML
    private DatePicker dataTransferDataPicker;
    @FXML
    private ChoiceBox choiceBox;
    LocalDate localDate = LocalDate.now();
    Alert alert;


    @FXML
    void backButtonOnAction() throws IOException {
        changeWindow("MainMenu.fxml", 900, 700);


    }


    public void confirmButtonOnAction(ActionEvent event) throws IOException {
        if (recipientsNameTextfield.getText().length() > 0 && recipientsNameTextfield.getText().length() < 20) {
            if (accountNumberTextfield.getText().length() > 0) {
                if (transferAmoundTextfield.getText().length() > 0 && transferAmoundTextfield.getText().length() < 5000) {

                    table_transfer.setId_TableTransfer(1);
                    table_transfer.setNameTransfer(recipientsNameTextfield.getText());
                    table_transfer.setAmountTransfer(transferAmoundTextfield.getText());
                    table_transfer.setTitleTransfer(transferTitleTextfield.getText());
                    table_transfer.setDataTransfer(String.valueOf(dataTransferDataPicker.getValue()));
                    table_transfer.setTypeTransfer(String.valueOf(choiceBox.getValue()));

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                    Parent root = loader.load();
                    MainMenuController mainMenuController = loader.getController();
                    ObservableList<Table_transfer> getDataTransfer = FXCollections.observableArrayList(
                            new Table_transfer(table_transfer.getId_TableTransfer(), table_transfer.getNameTransfer(), table_transfer.getAmountTransfer(), table_transfer.getTitleTransfer(),
                                    table_transfer.getDataTransfer(), table_transfer.getTypeTransfer())
                    );
                    table_transfer.setId_TableTransfer(table_transfer.getId_TableTransfer() + 1);
                    mainMenuController.getTABELATRANSFER().getItems().addAll(getDataTransfer);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();






                    //changeWindow("MainMenu.fxml", 900, 700);

                } else {
                    setAlert(Alert.AlertType.ERROR, "Wrong amount\n", "Wrong amount entered\n");
                }

            } else {
                setAlert(Alert.AlertType.ERROR, "Wrong number\n", "Wrong number entered\n");
            }
        } else {
            setAlert(Alert.AlertType.ERROR, "Wrong data\n", "Wrong data entered\n");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll("ORDINARY", "INSTANT");
        dataTransferDataPicker.setValue(localDate);
        choiceBox.setValue("ORDINARY");

    }


    public void changeWindow(String name, int width, int height) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(name));
        Stage window = (Stage) confirmButton.getScene().getWindow();
        window.setScene(new Scene(root, width, height));
    }

    public void setAlert(Alert.AlertType type, String title, String header_text) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header_text);
        alert.showAndWait();
    }

//    public void SetTableTransfer() {
//        ObservableList<Table_transfer> getDataTransfer = FXCollections.observableArrayList(
//                new Table_transfer(table_transfer.getId_TableTransfer(), table_transfer.getNameTransfer(), table_transfer.getAmountTransfer(), mainMenuController.table_transfer.getTitleTransfer(),
//                        mainMenuController.table_transfer.getDataTransfer(), table_transfer.getTypeTransfer())
//        );
//        mainMenuController.getTABELATRANSFER().getItems().addAll(getDataTransfer);
//        table_transfer.setId_TableTransfer(table_transfer.getId_TableTransfer() + 1);
//
//
//    }
}
