package ku.cs.system.services;

import ku.cs.system.models.CO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CODataAccessor {
    private Connection connection;

    public CODataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<CO> getCOList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM co");
        ){
            List<CO> coList = new ArrayList<>();
            while(resultSet.next()){
                int co_id = Integer.parseInt(resultSet.getString("CO_ID"));
                int p_id = Integer.parseInt(resultSet.getString("P_ID"));
                int c_id = Integer.parseInt(resultSet.getString("C_ID"));
                String name = resultSet.getString("CO_Prod");
                float price = Float.parseFloat(resultSet.getString("CO_Price"));
                int amount = Integer.parseInt(resultSet.getString("CO_Amount"));
                CO co = new CO(co_id, p_id, c_id, name, amount, price);
                coList.add(co);
            }
            return coList;
        }
    }
}
