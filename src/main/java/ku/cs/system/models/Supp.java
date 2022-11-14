package ku.cs.system.models;

import java.io.Serializable;

public class Supp {
    private int S_ID;
    private String S_Name;
    private String S_Phone;
    private int P_ID;

    public Supp(String s_Name, String s_Phone, int p_ID) {
        this.S_Name = s_Name;
        this.S_Phone = s_Phone;
        this.P_ID = p_ID;
    }

    public Supp(){}

    public int getS_ID() {
        return S_ID;
    }

    public void setS_ID(int s_ID) {
        S_ID = s_ID;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public String getS_Phone() {
        return S_Phone;
    }

    public void setS_Phone(String s_Phone) {
        S_Phone = s_Phone;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }
}
