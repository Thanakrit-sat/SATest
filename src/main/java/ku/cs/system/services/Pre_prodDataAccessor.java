package ku.cs.system.services;

import ku.cs.system.models.Pre_prod;
import ku.cs.system.models.Supply;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pre_prodDataAccessor {
    private Connection connection;

    public Pre_prodDataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<Pre_prod> getPreProds() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM preprod");
        ){
            List<Pre_prod> preProds = new ArrayList<>();
            while(resultSet.next()){
                int Pre_ID = Integer.parseInt(resultSet.getString("Pre_ID"));
                int C_ID = Integer.parseInt(resultSet.getString("C_ID"));
                String name = resultSet.getString("Pre_Name");
                float price = Float.parseFloat(resultSet.getString("Pre_Price"));
                int amount = Integer.parseInt(resultSet.getString("Pre_Amount"));
                Pre_prod preProd = new Pre_prod(Pre_ID, C_ID, name, price, amount);
                preProds.add(preProd);
            }
            return preProds;
        }
    }

    public void insertProd(Pre_prod prod) throws SQLException {
        PreparedStatement preparedStatement=null;
        try {
            int pre_ID = prod.getPre_ID();
            int c_ID = prod.getC_ID();
            String name = prod.getPre_Name();
            Float price = prod.getPre_Price();
            int amount = prod.getPre_Amount();

            String query =
                    "INSERT INTO PREPROD (Pre_ID, C_ID, Pre_Name, Pre_Price, Pre_Amount) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1,pre_ID);
            preparedStatement.setInt(2,c_ID);
            preparedStatement.setString(3, name);
            preparedStatement.setFloat(4,price);
            preparedStatement.setInt(5,amount);

            preparedStatement.executeUpdate();

            System.out.println("add Product successfully!");
        }catch (Exception e){
            System.out.println("add Product failed!");
        }
    }
}
