package gbrl.ue.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO implements InfoDB {

    public Connection conDB () {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(urlBD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}