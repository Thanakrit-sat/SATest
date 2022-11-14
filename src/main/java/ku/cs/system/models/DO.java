package ku.cs.system.models;

import java.io.Serializable;

public class DO implements Serializable {
    private int DO_ID;
    private int CO_ID;
    private float DO_Price;
    private String DO_Prod;
    private int DO_Amount;

    public DO(int CO_ID, float DO_Price, String DO_Prod, int DO_Amount) {
        this.CO_ID = CO_ID;
        this.DO_Price = DO_Price;
        this.DO_Prod = DO_Prod;
        this.DO_Amount = DO_Amount;
    }

    public DO() {}

    public int getDO_ID() {
        return DO_ID;
    }

    public void setDO_ID(int DO_ID) {
        this.DO_ID = DO_ID;
    }

    public int getCO_ID() {
        return CO_ID;
    }

    public void setCO_ID(int CO_ID) {
        this.CO_ID = CO_ID;
    }

    public float getDO_Price() {
        return DO_Price;
    }

    public void setDO_Price(float DO_Price) {
        this.DO_Price = DO_Price;
    }

    public String getDO_Prod() {
        return DO_Prod;
    }

    public void setDO_Prod(String DO_Prod) {
        this.DO_Prod = DO_Prod;
    }

    public int getDO_Amount() {
        return DO_Amount;
    }

    public void setDO_Amount(int DO_Amount) {
        this.DO_Amount = DO_Amount;
    }
}
