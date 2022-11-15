package ku.cs.system.services;

import ku.cs.system.models.Pre_prod;

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
}
