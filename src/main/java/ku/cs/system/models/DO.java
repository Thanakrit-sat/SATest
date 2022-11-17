package ku.cs.system.models;

import java.io.Serializable;

public class DO {
    private int DO_ID;
    private int CO_ID;
    private float DO_Price;
    private String status;

    public DO(int DO_ID, int CO_ID, float DO_Price, String status) {
        this.DO_ID = DO_ID;
        this.CO_ID = CO_ID;
        this.DO_Price = DO_Price;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
