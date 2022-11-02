package gbrl.ue.database.dao;

import gbrl.ue.database.ConexaoDAO;
import gbrl.ue.database.InfoDB;
import gbrl.ue.database.dto.PessoaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;

public class PessoaDAO implements InfoDB {

    public static HashSet<PessoaDTO> pessoaShr;
    static ArrayList<PessoaDTO> list;
    static Connection conn = null;
    static PreparedStatement pStm = null;
    static ResultSet resSet = null;

    // Cadastrar
    public static boolean cpfCadastrado (String cpf) {
        ArrayList<PessoaDTO> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM " + PESSOAStb + " WHERE pe_numCPF = '" + cpf + "'";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PessoaDTO pessoaDTO = new PessoaDTO();
                pessoas.add(pessoaDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return !(pessoas.size() == 0);
    }

    public static boolean addPessoa (PessoaDTO pessoa) {
        String sql = "INSERT INTO " + PESSOAStb + " values(default,?,?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);

            pStm.setString(1, pessoa.getNome());
            pStm.setString(2, pessoa.getNomeMae());
            pStm.setString(3, pessoa.getNomePai());
            pStm.setString(4, pessoa.getEstatoCivil());
            pStm.setString(5, pessoa.getNaturalidade());
            pStm.setString(6, pessoa.getNumRG());
            pStm.setString(7, pessoa.getNumCPF());
            pStm.setString(8, pessoa.getNumTituloEleitor());
            pStm.setString(9, pessoa.getSenha());

            pStm.execute();
            pStm.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Listar
    public static ArrayList<PessoaDTO> listPessoas () {
        list = new ArrayList<>();

        String sql = "SELECT * from " + PESSOAStb + " ORDER BY pe_nome ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PessoaDTO pessoaDTO = new PessoaDTO(
                        resSet.getInt("pe_id"),
                        resSet.getString("pe_nome"),
                        resSet.getString("pe_nomeMae"),
                        resSet.getString("pe_nomePai"),
                        resSet.getString("pe_estatoCivil"),
                        resSet.getString("pe_naturalidade"),
                        resSet.getString("pe_numTituloEleitor"),
                        resSet.getString("pe_numRG"),
                        resSet.getString("pe_numCPF"),
                        resSet.getString("pe_senha"));

                list.add(pessoaDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Pesquisar
    public static AbstractCollection<PessoaDTO> shrPessoa (String sh) {
        list = new ArrayList<>();

        String sql = "SELECT * FROM " + PESSOAStb + " p WHERE upper(p.pe_nome) LIKE upper('%" + sh + "%') OR upper(p.pe_nomeMae) LIKE upper('%" + sh + "%') OR upper(p.pe_nomePai) LIKE upper('%" + sh + "%') OR upper(p.pe_estatoCivil) LIKE upper('%" + sh + "%') OR upper(p.pe_naturalidade) LIKE upper('%" + sh + "%') OR p.pe_numRG LIKE '%" + sh + "%' OR p.pe_numCPF LIKE '%" + sh + "%' OR p.pe_numTituloEleitor LIKE '%" + sh + "%' ORDER BY pe_nome ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PessoaDTO pessoaDTO = new PessoaDTO(
                        resSet.getInt("pe_id"),
                        resSet.getString("pe_nome"),
                        resSet.getString("pe_nomeMae"),
                        resSet.getString("pe_nomePai"),
                        resSet.getString("pe_estatoCivil"),
                        resSet.getString("pe_naturalidade"),
                        resSet.getString("pe_numTituloEleitor"),
                        resSet.getString("pe_numRG"),
                        resSet.getString("pe_numCPF"),
                        resSet.getString("pe_senha"));

                list.add(pessoaDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static PessoaDTO getPessoa (int id) {
        String sql = "SELECT * FROM " + PESSOAStb + " WHERE pe_id = " + id + "";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();
            while (resSet.next()) {
                return new PessoaDTO(
                        resSet.getInt("pe_id"),
                        resSet.getString("pe_nome"),
                        resSet.getString("pe_nomeMae"),
                        resSet.getString("pe_nomePai"),
                        resSet.getString("pe_estatoCivil"),
                        resSet.getString("pe_naturalidade"),
                        resSet.getString("pe_numTituloEleitor"),
                        resSet.getString("pe_numRG"),
                        resSet.getString("pe_numCPF"),
                        resSet.getString("pe_senha"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Autentificar
    public static PessoaDTO autPessoa (String user, String senha) {
        String sql = "SELECT * FROM " + PESSOAStb + " WHERE pe_numCPF = '" + user + "' AND pe_senha = '" + senha + "'";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                return new PessoaDTO(
                        resSet.getInt("pe_id"),
                        resSet.getString("pe_nome"),
                        resSet.getString("pe_nomeMae"),
                        resSet.getString("pe_nomePai"),
                        resSet.getString("pe_estatoCivil"),
                        resSet.getString("pe_naturalidade"),
                        resSet.getString("pe_numTituloEleitor"),
                        resSet.getString("pe_numRG"),
                        resSet.getString("pe_numCPF"),
                        resSet.getString("pe_senha"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Excluir
    public static boolean delPessoa (int idPessoa) {
        String sql = "DELETE FROM " + PESSOAStb + " WHERE pe_id = " + idPessoa;

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            pStm.execute();
            pStm.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Editar
    public static boolean editarPessoa (PessoaDTO pessoa) {
        String sql = "UPDATE " + PESSOAStb + " SET pe_nome = '" + pessoa.getNome() +
                "', pe_nomeMae = '" + pessoa.getNomeMae() +
                "', pe_nomePai = '" + pessoa.getNomePai() +
                "', pe_estatoCivil = '" + pessoa.getEstatoCivil() +
                "', pe_naturalidade = '" + pessoa.getNaturalidade() +
                "', pe_numRG = " + pessoa.getNumRG() +
                ", pe_numCPF = " + pessoa.getNumCPF() +
                ", pe_numTituloEleitor = " + pessoa.getNumTituloEleitor() +
                " WHERE pe_id = " + pessoa.getId();

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            pStm.execute();
            pStm.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}

