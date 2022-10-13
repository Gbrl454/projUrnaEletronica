package gbrl.ue.database.dao;

import gbrl.ue.database.ConexaoDAO;
import gbrl.ue.database.InfoDB;
import gbrl.ue.database.dto.PessoaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class PessoaDAO implements InfoDB {

    public HashSet<PessoaDTO> funcPes;
    ArrayList<PessoaDTO> list;
    Connection conn = null;
    PreparedStatement pStm = null;
    ResultSet resSet = null;

    public boolean addPessoa (PessoaDTO pessoa) {
        String sql = "INSERT INTO " + PESSOAStb + " values(default,?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);

            pStm.setString(1, pessoa.getNome());
            pStm.setString(2, pessoa.getNomeMae());
            pStm.setString(3, pessoa.getNomePai());
            pStm.setString(4, pessoa.getEstatoCivil());
            pStm.setString(5, pessoa.getNaturalidade());
            pStm.setLong(6, pessoa.getNumRG());
            pStm.setLong(7, pessoa.getNumCPF());
            pStm.setLong(8, pessoa.getNumTituloEleitor());

            pStm.execute();
            pStm.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}

