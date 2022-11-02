package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.database.dao.PessoaDAO;
import gbrl.ue.database.dto.PessoaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ControllerVerPessoa {
    public Button btnVoltar, btnEditar;
    public TextField tfNome, tfNomeMae, tfNomePai, tfRG, tfCPF, tfTituloEleitor;
    public ComboBox<String> cbEstatoCivil;
    public ComboBox<String> cbNaturalidade;
    private int idPessoaSelc = 0;

    @FXML
    protected void initialize () {
        App.addOnChageScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
            if (userData != null) {
                idPessoaSelc = Integer.parseInt((String) userData);
                setValor();
            }
            //System.out.println(idPessoaSelc);
        });

    }

    private void setValor () {
        PessoaDTO pessoa = PessoaDAO.getPessoa(idPessoaSelc);

        assert pessoa != null;
        tfNome.setText(pessoa.getNome());
        tfNomeMae.setText(pessoa.getNomeMae());
        tfNomePai.setText(pessoa.getNomePai());
        tfRG.setText(pessoa.getNumRG());
        tfCPF.setText(pessoa.getNumCPF());
        tfTituloEleitor.setText(pessoa.getNumTituloEleitor());
        cbEstatoCivil.setValue(pessoa.getEstatoCivil());
        cbNaturalidade.setValue(pessoa.getNaturalidade());
    }

    public void btnVoltar () {
        App.changeScreen("scAdmin");
    }

    public void btnEditar () {
        App.changeScreen("scEditarPessoa", String.valueOf(idPessoaSelc));
    }
}
