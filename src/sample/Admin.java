package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private int cash =1000000;
    private String login;
    private String password;
    public List<Account> accounts = new ArrayList<>();


    public void Zalogowany(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void showTab(){
        for(int i=0;i<accounts.size();i++){
            System.out.println(accounts.get(i).login);
            System.out.println(accounts.get(i).password);
        }
    }


    public boolean Logowanie(TextField login, PasswordField password){
        for(Account account: accounts){
                if (account.getLogin().equals(login) && account.getPassword().equals(password)){
                    System.out.println("GIT");
                    return true;
                }
        }

        return false;
    }


    public void Wplac(int kwota){
        for(Account account: accounts){
            if (login.equals(account.getLogin())){
                account.Wplac(kwota);
            }
        }
    }
    public void Pobierz(int kwota){
        for(Account account: accounts){
            if (login.equals(account.getLogin())){
                account.Pobierz(kwota);
            }
        }
    }

    public int getCash() {
        return cash;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
