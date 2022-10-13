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

    public HashSet<PessoaDTO> pessoaShr;
    ArrayList<PessoaDTO> list;
    Connection conn = null;
    PreparedStatement pStm = null;
    ResultSet resSet = null;

    // Cadastrar
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

    // Listar
    public ArrayList<PessoaDTO> listPessoas () {
        list = new ArrayList<>();

        String sql = "SELECT * from " + PESSOAStb;

        conn = new ConexaoDAO().conDB();

        try {
            pStm = conn.prepareStatement(sql);
            resSet = pStm.executeQuery();

            while (resSet.next()) {
                PessoaDTO pessoaDTO = new PessoaDTO(resSet.getInt("id"), resSet.getString("nome"), resSet.getString("nomeMae"), resSet.getString("nomePai"), resSet.getString("estatoCivil"), resSet.getString("naturalidade"), resSet.getLong("numRG"), resSet.getLong("numCPF"), resSet.getLong("numTituloEleitor"));
                list.add(pessoaDTO);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    // Pesquisar
    public AbstractCollection<PessoaDTO> shrPessoa (String sh) {
        pessoaShr = new HashSet<>();
if (sh.isEmpty()){
    return listPessoas();
}else {
    for (PessoaDTO pessoa : listPessoas()) {
            if (pessoa.getNome().contains(sh)
                    || pessoa.getNomeMae().contains(sh)
                    || pessoa.getNomePai().contains(sh)
                    || pessoa.getEstatoCivil().contains(sh)
                    || pessoa.getNaturalidade().contains(sh)
                    || String.valueOf(pessoa.getId()).contains(sh)
                    || String.valueOf(pessoa.getNumRG()).contains(sh)
                    || String.valueOf(pessoa.getNumCPF()).contains(sh)
                    || String.valueOf(pessoa.getNumTituloEleitor()).contains(sh)) {
                pessoaShr.add(pessoa);
            }
    }
}
        return pessoaShr;
    }
}
