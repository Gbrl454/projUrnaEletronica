package gbrl.ue.database.dao;

import gbrl.ue.database.ConexaoDAO;
import gbrl.ue.database.InfoDB;
import gbrl.ue.database.dto.CandidatoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;

public class CandidatoDAO implements InfoDB {

    public static HashSet<CandidatoDTO> candidatoShr;
    static ArrayList<CandidatoDTO> list;
    static Connection conn = null;
    static PreparedStatement pStm = null;
    static ResultSet resSet = null;

    // Cadastrar
    public static boolean candidatoCadastrado (int idPessoa, int idPartido, String nome, String cargoAtual, String cargoPleito, int numero) {
        ArrayList<CandidatoDTO> candidatos = new ArrayList<>();

        String sql = "SELECT * FROM " + CANDIDATOStb + " WHERE pe_id = " + idPessoa + " OR pa_id = " + idPartido + " OR ca_nome = '" + nome + "' OR ca_cargoAtual = '" + cargoPleito + "' OR ca_cargoPleito = '" + cargoPleito + "' OR ca_numero = " + numero;

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                CandidatoDTO candidatoDTO = new CandidatoDTO();
                candidatos.add(candidatoDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return candidatos.size() == 0;
    }

    public static boolean addCandidato (CandidatoDTO candidato) {
        String sql = "INSERT INTO " + CANDIDATOStb + " values(default,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);

            pStm.setInt(1, candidato.getIdPessoa());
            pStm.setInt(2, candidato.getIdPartido());
            pStm.setString(3, candidato.getNome());
            pStm.setString(4, candidato.getCargoAtual());
            pStm.setString(5, candidato.getCargoPleito());
            pStm.setInt(6, candidato.getNumero());

            pStm.execute();
            pStm.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Listar
    public static ArrayList<CandidatoDTO> listCandidatos () {
        list = new ArrayList<>();

        String sql = "SELECT * from " + CANDIDATOStb + " ORDER BY ca_numero ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                CandidatoDTO candidatoDTO = new CandidatoDTO(
                        resSet.getInt("ca_id"),
                        resSet.getInt("pe_id"),
                        resSet.getInt("pa_id"),
                        resSet.getString("ca_nome"),
                        resSet.getString("ca_cargoAtual"),
                        resSet.getString("ca_cargoPleito"),
                        resSet.getInt("ca_numero"));

                list.add(candidatoDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Pesquisar
    public static AbstractCollection<CandidatoDTO> shrCandidato (String sh) {
        list = new ArrayList<>();

        String sql = "SELECT * FROM " + CANDIDATOStb + " c WHERE upper(ca_nome) LIKE upper('%" + sh + "%') OR upper(ca_cargoAtual) LIKE upper('%" + sh + "%') OR upper(ca_cargoPleito) LIKE upper('%" + sh + "%') OR ca_numero LIKE '%" + sh + "%' ORDER BY ca_nome ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                CandidatoDTO candidatoDTO = new CandidatoDTO(
                        resSet.getInt("ca_id"),
                        resSet.getInt("pe_id"),
                        resSet.getInt("pa_id"),
                        resSet.getString("ca_nome"),
                        resSet.getString("ca_cargoAtual"),
                        resSet.getString("ca_cargoPleito"),
                        resSet.getInt("ca_numero"));

                list.add(candidatoDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public static CandidatoDTO getCandidato (int id) {
        String sql = "SELECT * FROM " + CANDIDATOStb + " WHERE ca_id = " + id + "";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();
            return new CandidatoDTO(
                    resSet.getInt("ca_id"),
                    resSet.getInt("pe_id"),
                    resSet.getInt("pa_id"),
                    resSet.getString("ca_nome"),
                    resSet.getString("ca_cargoAtual"),
                    resSet.getString("ca_cargoPleito"),
                    resSet.getInt("ca_numero"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

