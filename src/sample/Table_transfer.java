package sample;

public class Table_transfer {
    private int id_TableTransfer = 1;
    private String nameTransfer;
    private String amountTransfer;
    private String titleTransfer;
    private String dataTransfer;
    private String typeTransfer;

    public Table_transfer(int id_TableTransfer, String nameTransfer, String amountTransfer, String titleTransfer, String dataTransfer, String typeTransfer) {
        this.id_TableTransfer = id_TableTransfer;
        this.nameTransfer = nameTransfer;
        this.amountTransfer = amountTransfer;
        this.titleTransfer = titleTransfer;
        this.dataTransfer = dataTransfer;
        this.typeTransfer = typeTransfer;
    }
    public Table_transfer(){

    }

    public int getId_TableTransfer() {
        return id_TableTransfer;
    }

    public void setId_TableTransfer(int id_TableTransfer) {
        this.id_TableTransfer = id_TableTransfer;
    }

    public String getNameTransfer() {
        return nameTransfer;
    }

    public void setNameTransfer(String nameTransfer) {
        this.nameTransfer = nameTransfer;
    }


    public String getAmountTransfer() {
        return amountTransfer;
    }

    public void setAmountTransfer(String amountTransfer) {
        this.amountTransfer = amountTransfer;
    }

    public String getTitleTransfer() {
        return titleTransfer;
    }

    public void setTitleTransfer(String titleTransfer) {
        this.titleTransfer = titleTransfer;
    }

    public String getDataTransfer() {
        return dataTransfer;
    }

    public void setDataTransfer(String dataTransfer) {
        this.dataTransfer = dataTransfer;
    }

    public String getTypeTransfer() {
        return typeTransfer;
    }

    public void setTypeTransfer(String typeTransfer) {
        this.typeTransfer = typeTransfer;
    }
}
