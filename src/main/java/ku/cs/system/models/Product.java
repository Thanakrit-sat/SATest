package ku.cs.system.models;

import java.io.Serializable;

public class Product{
    private int P_ID;
    private String P_Name;
    private float P_Price;
    private int P_Amount;

    public Product(){}

    public Product(int ID, String p_Name, float p_Price, int p_Amount) {
        this.P_ID = ID;
        this.P_Name = p_Name;
        this.P_Price = p_Price;
        this.P_Amount = p_Amount;
    }

    public int AddProduct(int amount){
        int totalAmount = amount + P_Amount;
        return totalAmount;
    }

    public float BuyProduct(int amount){
        float totalPrice = amount * P_Price;
        return totalPrice;
    }

    public int getP_ID() {
        return P_ID;
    }

    public void setP_ID(int p_ID) {
        P_ID = p_ID;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String p_Name) {
        P_Name = p_Name;
    }

    public float getP_Price() {
        return P_Price;
    }

    public void setP_Price(float p_Price) {
        P_Price = p_Price;
    }

    public int getP_Amount() {
        return P_Amount;
    }

    public void setP_Amount(int p_Amount) {
        P_Amount = p_Amount;
    }
}
