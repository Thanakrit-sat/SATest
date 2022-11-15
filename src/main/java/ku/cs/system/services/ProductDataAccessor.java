package ku.cs.system.services;

import ku.cs.system.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataAccessor {
    private Connection connection;

    public ProductDataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<Product> getProducts() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM prod");
        ){
            List<Product> products = new ArrayList<>();
            while(resultSet.next()){
                int ID = Integer.parseInt(resultSet.getString("P_ID"));
                String name = resultSet.getString("P_Name");
                float price = Float.parseFloat(resultSet.getString("P_Price"));
                int amount = Integer.parseInt(resultSet.getString("P_Amount"));
                Product product = new Product(ID, name, price, amount);
                products.add(product);
            }
            return products;
        }
    }
}
