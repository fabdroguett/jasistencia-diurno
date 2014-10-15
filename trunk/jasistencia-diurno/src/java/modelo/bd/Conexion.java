package modelo.bd;

import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Conexion {
    public Connection con;
    public Statement sen;
    public ResultSet rs;
    
    public Conexion(String bd, String pass) 
            throws SQLException{
        MysqlDataSource mysql = new MysqlDataSource();
        
        mysql.setServerName("localhost");
        mysql.setDatabaseName(bd);
        mysql.setUser("root");
        mysql.setPassword(pass);
        
        con = mysql.getConnection();
    }
    
    public void insert(String sql) throws SQLException{
        sen = con.createStatement();
        sen.execute(sql);
        sen.close();
    }
    
}
