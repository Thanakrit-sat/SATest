package ku.cs.system.services;


import ku.cs.system.models.SO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SODataAccessor {
    private Connection connection;

    public SODataAccessor(String dbURL, String user, String password) throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException{
        if (connection != null){
            connection.close();
        }
    }

    public List<SO> getSOList() throws SQLException{
        try(
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM supplyorder");
        ){
            List<SO> soList = new ArrayList<>();
            while(resultSet.next()){
                int SO_ID = Integer.parseInt(resultSet.getString("SO_ID"));
                int S_ID = Integer.parseInt(resultSet.getString("S_ID"));
                int P_ID = Integer.parseInt(resultSet.getString("P_ID"));
                float cost = Float.parseFloat(resultSet.getString("SO_Cost"));
                int amount = Integer.parseInt(resultSet.getString("SO_Amount"));
                SO so = new SO(SO_ID, S_ID, P_ID, cost, amount);
                soList.add(so);
            }
            return soList;
        }
    }
}
