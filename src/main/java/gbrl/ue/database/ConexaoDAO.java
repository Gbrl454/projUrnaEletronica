package gbrl.ue.database;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO implements InfoDB {

    private static void alert (String header, String text) {
        Alert aE = new Alert(AlertType.ERROR);
        aE.setTitle("Erro");
        aE.setHeaderText(header);
        aE.setContentText(text);
        aE.show();
    }

    public Connection conDB () {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(urlBD);
        } catch (SQLException e) {
            alert("conDB", e.getMessage());
            System.out.println(e.getMessage());
        }
        return conn;
    }
}