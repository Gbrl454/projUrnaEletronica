package gbrl.ue.database.dao;

import gbrl.ue.database.ConexaoDAO;
import gbrl.ue.database.InfoDB;
import gbrl.ue.database.dto.PartidoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;

public class PartidoDAO implements InfoDB  {

    public static HashSet<PartidoDTO> partidoShr;
    static ArrayList<PartidoDTO> list;
    static Connection conn = null;
    static PreparedStatement pStm = null;
    static ResultSet resSet = null;

    // Cadastrar
    public static boolean addPartido (PartidoDTO partido) {
        String sql = "INSERT INTO " + PARTIDOStb + " values(default,?,?,?)";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);

            pStm.setString(1, partido.getNome());
            pStm.setInt(2, partido.getNumero());
            pStm.setString(3, partido.getSigla());

            pStm.execute();
            pStm.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Listar
    public static ArrayList<PartidoDTO> listPartidos () {
        list = new ArrayList<>();

        String sql = "SELECT * from " + PARTIDOStb + " ORDER BY id ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PartidoDTO partidoDTO = new PartidoDTO(
                        resSet.getInt("id"),
                        resSet.getString("nome"),
                        resSet.getInt("numero"),
                        resSet.getString("sigla"));

                list.add(partidoDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Pesquisar
    public static AbstractCollection<PartidoDTO> shrPartido (String sh) {
        partidoShr = new HashSet<>();
        sh = sh.toLowerCase();
        if (sh.isEmpty()) {
            return listPartidos();
        } else {
            for (PartidoDTO partido : listPartidos()) {
                if (partido.getNome().toLowerCase().contains(sh)
                        || String.valueOf(partido.getNumero()).contains(sh)
                        || partido.getSigla().toLowerCase().contains(sh)) {
                    partidoShr.add(partido);
                }
            }
        }
        return partidoShr;
    }
}

