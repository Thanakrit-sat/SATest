package ku.cs.system.models;

import java.io.Serializable;

public class CO {
    private int CO_ID;
    private int P_ID;
    private String CO_Prod;
    private int CO_Amount;
    private float CO_Price;

    public CO(int p_ID, String CO_Prod, int CO_Amount, float CO_Price) {
        this.P_ID = p_ID;
        this.CO_Prod = CO_Prod;
        this.CO_Amount = CO_Amount;
        this.CO_Price = CO_Price;
    }

    public CO(){}

    public int getCO_ID() {
        return CO_ID;
    }

    public void setCO_ID(int CO_ID) {
        this.CO_ID = CO_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public String getCO_Prod() {
        return CO_Prod;
    }

    public void setCO_Prod(String CO_Prod) {
        this.CO_Prod = CO_Prod;
    }

    public int getCO_Amount() {
        return CO_Amount;
    }

    public void setCO_Amount(int CO_Amount) {
        this.CO_Amount = CO_Amount;
    }

    public float getCO_Price() {
        return CO_Price;
    }

    public void setCO_Price(float CO_Price) {
        this.CO_Price = CO_Price;
    }
}
