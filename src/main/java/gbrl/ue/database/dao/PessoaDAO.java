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
    public static boolean addPessoa (PessoaDTO pessoa) {
        String sql = "INSERT INTO " + PESSOAStb + " values(default,?,?,?,?,?,?,?,?)";

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

        String sql = "SELECT * from " + PESSOAStb + " ORDER BY id ASC";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PessoaDTO pessoaDTO = new PessoaDTO(
                        resSet.getInt("id"),
                        resSet.getString("nome"),
                        resSet.getString("nomeMae"),
                        resSet.getString("nomePai"),
                        resSet.getString("estatoCivil"),
                        resSet.getString("naturalidade"),
                        resSet.getString("numRG"),
                        resSet.getString("numCPF"),
                        resSet.getString("numTituloEleitor"));

                list.add(pessoaDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Pesquisar
    public static AbstractCollection<PessoaDTO> shrPessoa (String sh) {
        pessoaShr = new HashSet<>();
        sh = sh.toLowerCase();
        if (sh.isEmpty()) {
            return listPessoas();
        } else {
            for (PessoaDTO pessoa : listPessoas()) {
                if (pessoa.getNome().toLowerCase().contains(sh)
                        || pessoa.getNomeMae().toLowerCase().contains(sh)
                        || pessoa.getNomePai().toLowerCase().contains(sh)
                        || pessoa.getEstatoCivil().toLowerCase().contains(sh)
                        || pessoa.getNaturalidade().toLowerCase().contains(sh)
                        || String.valueOf(pessoa.getNumRG()).contains(sh)
                        || String.valueOf(pessoa.getNumCPF()).contains(sh)
                        || String.valueOf(pessoa.getNumTituloEleitor()).contains(sh)) {
                    pessoaShr.add(pessoa);
                }
            }
        }
        return pessoaShr;
    }

    // Autentificar

}

