package ku.cs.system.models;

public class Supply {
    private int S_ID;
    private int P_ID;
    private String S_Name;
    private String S_Phone;
    private String S_Address;

    public Supply(int s_ID, int p_ID, String s_Name, String s_Phone, String s_Address) {
        S_ID = s_ID;
        P_ID = p_ID;
        S_Name = s_Name;
        S_Phone = s_Phone;
        S_Address = s_Address;
    }

    public Supply(){}

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

    public String getS_Address() {
        return S_Address;
    }

    public void setS_Address(String s_Address) {
        S_Address = s_Address;
    }
}
