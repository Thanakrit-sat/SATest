package ku.cs.system.models;

import java.io.Serializable;

public class Pre_prod implements Serializable {
    private int Pre_ID;
    private int C_ID;
    private int Pre_Price;
    private String Pre_Name;
    private int Pre_Amount;

    public Pre_prod(int c_ID, int pre_Price, String pre_Name, int pre_Amount) {
        this.C_ID = c_ID;
        this.Pre_Price = pre_Price;
        this.Pre_Name = pre_Name;
        this.Pre_Amount = pre_Amount;
    }

    public Pre_prod(){}

    public int getPre_ID() {
        return Pre_ID;
    }

    public void setPre_ID(int pre_ID) {
        Pre_ID = pre_ID;
    }

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int c_ID) {
        C_ID = c_ID;
    }

    public int getPre_Price() {
        return Pre_Price;
    }

    public void setPre_Price(int pre_Price) {
        Pre_Price = pre_Price;
    }

    public String getPre_Name() {
        return Pre_Name;
    }

    public void setPre_Name(String pre_Name) {
        Pre_Name = pre_Name;
    }

    public int getPre_Amount() {
        return Pre_Amount;
    }

    public void setPre_Amount(int pre_Amount) {
        Pre_Amount = pre_Amount;
    }
}
