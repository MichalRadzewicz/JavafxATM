package sample;

import java.time.LocalDate;

public class Table_Deposit {
    private int id_table = 1;
    private LocalDate data_table;
    private String deposit_type;
    private int cash_table;

    public Table_Deposit(Integer id_table,int cash_table,String deposit_type, LocalDate data_table ) {
        this.id_table = id_table;
        this.cash_table = cash_table;
        this.deposit_type = deposit_type;
        this.data_table = data_table;

    }
    public Table_Deposit(){

    }

    public String getDeposit_type() {
        return deposit_type;
    }

    public void setDeposit_type(String deposit_type) {
        this.deposit_type = deposit_type;
    }

    public int getId_table() {
        return id_table;
    }

    public LocalDate getData_table() {
        return data_table;
    }

    public void setCash_table(int cash_table) {
        this.cash_table = cash_table;
    }

    public int getCash_table() {
        return (+cash_table);
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }
}
