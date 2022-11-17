package ku.cs.system.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ku.cs.FXRouter;
import ku.cs.system.models.CO;
import ku.cs.system.models.Product;
import ku.cs.system.services.CODataAccessor;
import ku.cs.system.services.ProductDataAccessor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BuyProductController {
    @FXML
    private TableColumn<Product, String> amountColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, String> priceColumn;

    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TextField amountField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private Label statusLabel;
    private ProductDataAccessor productDataAccessor;
    private CODataAccessor coDataAccessor;
    private Product selectedProduct;
    private ObservableList<Product> productObservableList;
    private List<Product> products;
    private List<CO> coList;
    private CO co;
    private int c_id;

    @FXML void initialize() throws SQLException, ClassNotFoundException {
        nameLabel.setText("");
        priceLabel.setText("");
        amountLabel.setText("");
        statusLabel.setText("");
        c_id = (int) FXRouter.getData();
        productDataAccessor = new ProductDataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        coDataAccessor = new CODataAccessor("jdbc:mysql://localhost:3306/jewelsystem",
                "root", "");
        products = productDataAccessor.getProducts();
        coList = coDataAccessor.getCOList();
        showProductData();
        productTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showSelectedProduct(newValue);
            }
        });
    }

    public void showProductData(){
        productObservableList = FXCollections.observableArrayList(products);
        productTableView.setItems(productObservableList);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("P_Name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("P_Price"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("P_Amount"));
    }

    public void showSelectedProduct(Product product){
        selectedProduct = product;
        nameLabel.setText(selectedProduct.getP_Name());
        priceLabel.setText(""+selectedProduct.getP_Price());
        amountLabel.setText(""+selectedProduct.getP_Amount());
    }

    public void clickBuyProduct() throws SQLException {
        if(amountField.getText().isBlank()){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        int amount = Integer.parseInt(amountField.getText());
        int productAmount = selectedProduct.getP_Amount();
        int totalAmount = productAmount-amount;
        if(totalAmount <= 0){
            statusLabel.setText("Invalid Information");
            statusLabel.setStyle("-fx-text-fill: #ff546b;");
            return;
        }
        selectedProduct.setP_Amount(totalAmount);
        productDataAccessor.updateAmount(totalAmount, selectedProduct.getP_ID());
        co = new CO(coList.size()+1, selectedProduct.getP_ID(),
                c_id, selectedProduct.getP_Name(), amount, selectedProduct.totalPrice(amount));
        try{
            coDataAccessor.insertCO(co);
            statusLabel.setText("Add supplier successfully");
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
    public void clickPre_Order(ActionEvent actionEvent){
        try {
            FXRouter.goTo("checkCustomer", "pre");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า checkCustomer ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด checkCustomer");
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
