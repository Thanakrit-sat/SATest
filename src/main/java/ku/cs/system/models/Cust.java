package ku.cs.system.models;

import java.io.Serializable;

public class Cust {
    private int C_ID;
    private String C_Name;
    private String C_Phone;
    private String C_Addrs;

    public Cust(String c_Name, String c_Phone, String c_Addrs) {
        this.C_Name = c_Name;
        this.C_Phone = c_Phone;
        this.C_Addrs = c_Addrs;
    }

    public Cust(){}

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int c_ID) {
        C_ID = c_ID;
    }

    public String getC_Name() {
        return C_Name;
    }

    public void setC_Name(String c_Name) {
        C_Name = c_Name;
    }

    public String getC_Phone() {
        return C_Phone;
    }

    public void setC_Phone(String c_Phone) {
        C_Phone = c_Phone;
    }

    public String getC_Addrs() {
        return C_Addrs;
    }

    public void setC_Addrs(String c_Addrs) {
        C_Addrs = c_Addrs;
    }
}
