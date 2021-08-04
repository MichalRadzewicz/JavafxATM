package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    //Admin admin = new Admin();
    Alert alert;
    LocalDate localDate = LocalDate.now();
    Table_Deposit table_deposit = new Table_Deposit();
    Table_transfer table_transfer = new Table_transfer();
    TextInputDialog dialog;


    @FXML
    private TextField AccountBalanceTextfield, loanTextfield;
    int account_balance = 0;
    int credit = 0;

    @FXML
    private Label YouHaveALoanToPayBackLabel, todayDate;
    @FXML
    private Button depositButton, payOutButton, takealoanButton, payoffbutton, logoutButton,moneyTransferButton;
    @FXML
    private TableView<Table_Deposit> table;
    @FXML
    private TableColumn<Table_Deposit, Integer> id_table;
    @FXML
    private TableColumn<Table_Deposit, String> table_data;
    @FXML
    private TableColumn<Table_Deposit, Double> cash_table;
    @FXML
    private TableColumn<Table_Deposit, String> deposit_type;
    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFile, menuEdit, menuHelp;
    @FXML
    private MenuItem changeColorButton, menuHelpButton, aboutButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TableView<Table_transfer> TABELATRANSFER;

    @FXML
    private TableColumn<Table_transfer, Integer> idtransferTableColumn;

    @FXML
    private TableColumn<Table_transfer, String> nameTableColumn;

    @FXML
    private TableColumn<Table_transfer, Double> amountTableColumn;

    @FXML
    private TableColumn<Table_transfer, String> titleTableColumn;

    @FXML
    private TableColumn<Table_transfer, String> dateTableColumn;

    @FXML
    private TableColumn<Table_transfer, String> typeTableColumn;



    @FXML
    void depositOnAction() {

        dialog = new TextInputDialog();
        setTextInputDialog("Payment", "How much do you want to deposit?\n");
        Optional<String> result = dialog.showAndWait();

        int val = Integer.parseInt(result.get()); // wybrana opcja przez użytkownika
        if (result.isPresent()) {
            if (val > 0 && val <3000) {
                table_deposit.setDeposit_type("Deposit");
                table_deposit.setCash_table(val);
                account_balance = Integer.valueOf(AccountBalanceTextfield.getText()) + val; // stan konta powiększa się
                AccountBalanceTextfield.setText(String.valueOf(account_balance));
                SetTableDeposit(val);
                setAlert(Alert.AlertType.INFORMATION, "Correct payment\n\n", "You have deposited " + val + " " + "PLN. ");
            } else {
                setAlert(Alert.AlertType.ERROR, "Wrong number entered \n", "Wrong number entered.");

            }


        }


    }

    @FXML
    void payOutButtonAction() {
        dialog = new TextInputDialog();
        setTextInputDialog("Pay out", "How much do you want to pay out?\n");
        Optional<String> result = dialog.showAndWait();
        int val = Integer.parseInt(result.get());
        if (result.isPresent()) {
            if (val <= Integer.parseInt(AccountBalanceTextfield.getText())) {
                table_deposit.setDeposit_type("Pay out");
                account_balance = Integer.valueOf(AccountBalanceTextfield.getText()) - val;
                AccountBalanceTextfield.setText(String.valueOf(account_balance));
                SetTableDeposit(-val);
                setAlert(Alert.AlertType.INFORMATION, "Correct pay out \n", "You have withdrawn " + val + " " + "PLN. ");
            } else {
                setAlert(Alert.AlertType.ERROR, "Transfer ERROR", "No more money can be withdrawn");
            }
        }
    }

    @FXML
    void takealoanOnAction() {
        dialog = new TextInputDialog();
        setTextInputDialog("Credit", "How much loan do you want to take? \n");
        Optional<String> result = dialog.showAndWait();

        int val = Integer.parseInt(result.get());
        if (result.isPresent()) {
            if (credit == 0) {
                table_deposit.setDeposit_type("Credit");
                account_balance = Integer.valueOf(AccountBalanceTextfield.getText()) + val;
                AccountBalanceTextfield.setText(String.valueOf(account_balance));
                credit = val;
                SetTableDeposit(val);
                if (credit > 0) {
                    loanVisible(true,true);
                }
                loanTextfield.setText(String.valueOf(credit));
                setAlert(Alert.AlertType.INFORMATION, "Correct payment", "You borrowed from the bank:  " + val + " " + "PLN. ");

            } else {
                setAlert(Alert.AlertType.ERROR, "ERROR", "Only one loan can be taken\n");
            }
        }

    }

    public void payoffbuttonOnAction() {
        dialog = new TextInputDialog();
        setTextInputDialog("Pay off", "How much How much loan do you want to pay off?");
        Optional<String> result = dialog.showAndWait();
        int val = Integer.parseInt(result.get());

        if (result.isPresent()) {
            if (account_balance >= val && val <= credit) {
                table_deposit.setDeposit_type("Payment of the Credit");
                account_balance = Integer.valueOf(AccountBalanceTextfield.getText()) - val;
                credit = Integer.parseInt(String.valueOf(Integer.valueOf(loanTextfield.getText()) - val));
                loanTextfield.setText(String.valueOf(credit));
                AccountBalanceTextfield.setText(String.valueOf(account_balance)); // git
                SetTableDeposit(-val);
                setAlert(Alert.AlertType.INFORMATION, "Correct payment \n", "You pay off:  " + val + " " + "PLN. ");
                System.out.println("Suma pieniędzy" + " " + account_balance); //git
                System.out.println("Kredyt: " + " " + credit); //git
                if (credit <= 0) {
                    loanVisible(false,false);
                    setAlert(Alert.AlertType.INFORMATION, "The loan was paid off\n", "The loan has been successfully repaid");
                }

            } else {
                setAlert(Alert.AlertType.ERROR, "Transfer error", "Your val is too big!");
            }


        }

    }


    public void logoutButtonOnAction() throws IOException {
        setAlert(Alert.AlertType.CONFIRMATION, "Logout", "Do you want to logout?");
        if (alert.getResult() == ButtonType.OK) {
            changeWindow("LoginPage.fxml",800,600);
        }
    }
    public void moneyTransferButtonOnAction(ActionEvent event) throws IOException {
    changeWindow("MoneyTransfer.fxml",700,500);

    }

    public void closeButtonOnAction() {
        setAlert(Alert.AlertType.CONFIRMATION,"EXIT?","Do you want to leave?",ButtonType.OK);
    }


    public void changeColorOnAction() {
        Color color = colorPicker.getValue();
        anchorPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));


    }

    public void aboutOnAction() {
        setAlert(Alert.AlertType.INFORMATION,"About Aplication","The application was developed only by Michał Radzewicz.\n" +
                "All rights reserved .®");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        loanVisible(false,false);
        todayDate.setText(String.valueOf(localDate));
        setTableColumns();



    }

    public void changeWindow(String name,int width,int height) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(name));
        Stage window = (Stage) logoutButton.getScene().getWindow();
        window.setScene(new Scene(root, width, height));
    }

    public void setAlert(Alert.AlertType type, String title, String header_text) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header_text);
        alert.showAndWait();
    }
    public void setAlert(Alert.AlertType type,String title, String header_text,ButtonType buttonType ){
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header_text);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonType){
            System.exit(0);
        }
    }

    public void SetTableDeposit(int val) {
        ObservableList<Table_Deposit> getData = FXCollections.observableArrayList(
                new Table_Deposit(table_deposit.getId_table(), val, table_deposit.getDeposit_type(), localDate)
        );
        table.getItems().addAll(getData);
        table_deposit.setId_table(table_deposit.getId_table() + 1);
    }

    public void setTextInputDialog(String title, String headerText) {
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);

    }

    public void setTableColumns(){
        id_table.setCellValueFactory(new PropertyValueFactory<>("id_table"));
        cash_table.setCellValueFactory(new PropertyValueFactory<>("cash_table"));
        deposit_type.setCellValueFactory(new PropertyValueFactory<>("deposit_type"));
        table_data.setCellValueFactory(new PropertyValueFactory<>("data_table"));

        idtransferTableColumn.setCellValueFactory(new PropertyValueFactory<>("id_TableTransfer"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("nameTransfer"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<>("titleTransfer"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("dataTransfer"));
        typeTableColumn.setCellValueFactory(new PropertyValueFactory<>("typeTransfer"));
        amountTableColumn.setCellValueFactory(new PropertyValueFactory<>("amountTransfer"));
    }



    public void loanVisible(boolean loanLabelVisibly, boolean loanTextfieldVisibly){
        YouHaveALoanToPayBackLabel.setVisible(loanLabelVisibly);
        loanTextfield.setVisible(loanTextfieldVisibly);

    }

    public TableView<Table_transfer> getTABELATRANSFER() {
        return TABELATRANSFER;
    }


}
