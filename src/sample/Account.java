package sample;

import java.util.ArrayList;
import java.util.List;

public class Account {
    String login,password;
    double stan,wplaty,wyplaty,mozliwoscKredytowa;
    ArrayList tranzakcje,kredyty;
    boolean access;

    public Account() {
        String login,password;
        int stan, wplaty, wyplaty, kredyt, mozliwoscKredytowa;
        List<Integer> tranzakcje = new ArrayList<Integer>();
        List<String> kredyty = new ArrayList<String>();
        boolean access = false;

    }
    public Account(String login, String password, int stan) {
        this.login = login;
        this.password = password;
        this.stan = stan;
        this.access = false;

    }

    public void Wplac(int kwota){
        stan += kwota;
        wplaty += kwota;
        tranzakcje.add(kwota);
        System.out.println("Wpłaciłeś: " + kwota);

    }
    public void Pobierz(int kwota){
        if(stan - kwota >= 0) {
            stan -= kwota;
            wyplaty += kwota;
            tranzakcje.add(-kwota);
            System.out.println("Wypłaciłeś: " + kwota);

        }else{
            System.out.println("Nie posiadasz: " + kwota);
        }
    }
    public String getLogin(){
        return login;
    }
    public String getPassword(){
        return password;
    }
    public double getStan(){
        return stan;
    }



}
