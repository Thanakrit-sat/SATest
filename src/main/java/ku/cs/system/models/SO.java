package ku.cs.system.models;

import java.io.Serializable;

public class SO implements Serializable {
    private int SO_ID;
    private int P_ID;
    private int S_ID;
    private int SO_Amount;
    private float SO_Cost;

    public SO(int p_ID, int s_ID, int SO_Amount, float SO_Cost) {
        this.P_ID = p_ID;
        this.S_ID = s_ID;
        this.SO_Amount = SO_Amount;
        this.SO_Cost = SO_Cost;
    }

    public SO(){}

    public int getSO_ID() {
        return SO_ID;
    }

    public void setSO_ID(int SO_ID) {
        this.SO_ID = SO_ID;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public int getSO_Amount() {
        return SO_Amount;
    }

    public void setSO_Amount(int SO_Amount) {
        this.SO_Amount = SO_Amount;
    }

    public float getSO_Cost() {
        return SO_Cost;
    }

    public void setSO_Cost(float SO_Cost) {
        this.SO_Cost = SO_Cost;
    }
}
