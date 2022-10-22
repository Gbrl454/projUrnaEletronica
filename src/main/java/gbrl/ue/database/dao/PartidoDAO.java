package gbrl.ue.database.dao;

import gbrl.ue.database.ConexaoDAO;
import gbrl.ue.database.InfoDB;
import gbrl.ue.database.dto.PartidoDTO;
import gbrl.ue.database.dto.PessoaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;

public class PartidoDAO implements InfoDB {

    public static HashSet<PartidoDTO> partidoShr;
    static ArrayList<PartidoDTO> list;
    static Connection conn = null;
    static PreparedStatement pStm = null;
    static ResultSet resSet = null;

    // Cadastrar
    public static boolean partidoCadastrado (String nome, int numero, String sigla) {
        ArrayList<PartidoDTO> partidos = new ArrayList<>();

        String sql = "SELECT * FROM " + PARTIDOStb + " WHERE pa_nome = '" + nome + "' OR pa_numero = " + numero + " OR pa_sigla = '" + sigla + "'";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PartidoDTO p = new PartidoDTO();
                partidos.add(p);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return partidos.size() == 0;
    }

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

        String sql = "SELECT * from " + PARTIDOStb + " ORDER BY pa_numero ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PartidoDTO partidoDTO = new PartidoDTO(
                        resSet.getInt("pa_id"),
                        resSet.getString("pa_nome"),
                        resSet.getInt("pa_numero"),
                        resSet.getString("pa_sigla"));

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
                if (partido.getNome().toLowerCase().contains(sh) ||
                        String.valueOf(partido.getNumero()).contains(sh) ||
                        partido.getSigla().toLowerCase().contains(sh) //||
                    //partido.getCandidatos().contains(CandidatoDAO.shrCandidato(sh))
                ) {
                    partidoShr.add(partido);
                }
            }
        }
        return partidoShr;
    }

    public static PartidoDTO getPartido(int id){
        String sql = "SELECT * FROM "+PARTIDOStb+" WHERE pa_id = "+id+"";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();
                return new PartidoDTO(
                        resSet.getInt("pa_id"),
                        resSet.getString("pa_nome"),
                        resSet.getInt("pa_numero"),
                        resSet.getString("pa_sigla"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

