package ku.cs.system.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.FXRouter;
import ku.cs.system.models.Product;
import ku.cs.system.models.SO;
import ku.cs.system.models.Supply;
import ku.cs.system.services.ProductDataAccessor;
import ku.cs.system.services.SODataAccessor;
import ku.cs.system.services.SupplyDataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SupplyController {
    @FXML
    private TextField IDField;

    @FXML
    private TextField amountField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label statusLabel;
    private SupplyDataAccessor supplyDataAccessor;
    private SODataAccessor soDataAccessor;
    private ProductDataAccessor productDataAccessor;
    private List<Supply> supplies;
    private  List<Product> products;
    private List<SO> soList;
    private Supply supply;
    private Product product;
    private SO so;
    private int s_id;
    private int p_id;

    @FXML void initialize() throws SQLException, ClassNotFoundException {
        nameLabel.setText("None");
        phoneLabel.setText("None");
        typeLabel.setText("None");
        statusLabel.setText("");
        supplyDataAccessor = new SupplyDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        soDataAccessor = new SODataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        productDataAccessor = new ProductDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        products = productDataAccessor.getProducts();
        supplies = supplyDataAccessor.getSupplyList();
        soList = soDataAccessor.getSOList();
    }

    @FXML
    public void clickFindSupp(){
        s_id = Integer.parseInt(IDField.getText());
        supply = supplies.get(s_id-1);
        p_id = supply.getP_ID();
        product = products.get(p_id-1);
        nameLabel.setText(supply.getS_Name());
        phoneLabel.setText(supply.getS_Phone());
        typeLabel.setText(product.getP_Name());
    }

    @FXML
    public void clickSubmitAddSO() throws SQLException {
        if(amountField.getText().isBlank()){
            statusLabel.setText("Please enter the amountField");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        int amount = Integer.parseInt(amountField.getText());
        int so_id = soList.size() + 1;
        float so_cost = product.totalPrice(amount);
        so = new SO(so_id, s_id, p_id, so_cost, amount);
        soDataAccessor.insertSO(so);
        statusLabel.setText("Add order successfully");
        statusLabel.setStyle("-fx-text-fill: #42ed6a;");
    }

    @FXML
    public void clickAddProduct(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            soDataAccessor.shutdown();
            supplyDataAccessor.shutdown();
            FXRouter.goTo("addProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า addProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด addProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickCreateProduct(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            soDataAccessor.shutdown();
            supplyDataAccessor.shutdown();
            FXRouter.goTo("createProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า createProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด createProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickBuyProduct(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            soDataAccessor.shutdown();
            supplyDataAccessor.shutdown();
            FXRouter.goTo("buyProduct");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า buyProduct ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด buyProduct");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            soDataAccessor.shutdown();
            supplyDataAccessor.shutdown();
            FXRouter.goTo("pre_order");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า pre_order ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด pre_order");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickDelivery(ActionEvent actionEvent){
        try {
            productDataAccessor.shutdown();
            soDataAccessor.shutdown();
            supplyDataAccessor.shutdown();
            FXRouter.goTo("delivery");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า delivery ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด delivery");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void clickConfirm(ActionEvent actionEvent) {
        try {
            productDataAccessor.shutdown();
            soDataAccessor.shutdown();
            supplyDataAccessor.shutdown();
            FXRouter.goTo("confirm");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า confirm ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด confirm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
