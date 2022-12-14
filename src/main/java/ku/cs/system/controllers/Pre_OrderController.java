package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Pre_prod;
import ku.cs.system.services.Pre_prodDataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Pre_OrderController {
    @FXML
    private TextField amountField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private Label statusLabel;
    private Pre_prodDataAccessor preProdDataAccessor;
    private List<Pre_prod> prodList;
    private Pre_prod preProd;
    private int c_id;

    @FXML void initialize() throws SQLException, ClassNotFoundException {
        preProdDataAccessor = new Pre_prodDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        prodList = preProdDataAccessor.getPreProds();
        statusLabel.setText("");
        c_id = (int) FXRouter.getData();
    }

    @FXML
    public void clickAddPre(){
        String name = nameField.getText();
        if(name.isBlank() || priceField.getText().isBlank() || amountField.getText().isBlank()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        Float price = Float.parseFloat(priceField.getText());
        int amount = Integer.parseInt(amountField.getText());
        preProd = new Pre_prod(prodList.size()+1, c_id, name, price, amount);
        try{
            preProdDataAccessor.insertProd(preProd);
            statusLabel.setText("Add product successfully");
            statusLabel.setStyle("-fx-text-fill: #42ed6a;");
        } catch (SQLException e) {
            statusLabel.setText("Add supplier to DB failed");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
        }
    }

    @FXML
    public void clickBuySupply(ActionEvent actionEvent){
        try {
            FXRouter.goTo("supply");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า supply ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด supply");
        }
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("createSupplier");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createSupplier ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createSupplier");
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            FXRouter.goTo("checkCustomer", "buy");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        }
    }

    @FXML
    public void clickDelivery(ActionEvent actionEvent){
        try {
            FXRouter.goTo("delivery");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า delivery ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด delivery");
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        }
    }
}
