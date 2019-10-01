package az.painer.db;

import az.painer.model.Filies;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.*;


public class FileDataManager {

    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    public static Connection getConnection() throws Exception{
        Context context=new InitialContext();
        DataSource dataSource= (DataSource) context.lookup("java:comp/env/jdbc/HOSPITAL");
        Connection connection=dataSource.getConnection();
        return  connection;
    }





}
