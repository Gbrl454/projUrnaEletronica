package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.DadosVariaveis;
import gbrl.ue.Telas;
import gbrl.ue.database.dao.PessoaDAO;
import gbrl.ue.database.dto.PessoaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.util.Objects;

public class ControllerEditarPessoa extends DadosVariaveis implements Telas {

    public Button btnVoltar, btnSalvar;
    public TextField tfNome, tfNomeMae, tfNomePai, tfRG, tfCPF, tfTituloEleitor, tfSenha, tfSenhaConf;
    public ComboBox<String> cbEstatoCivil;
    public ComboBox<String> cbNaturalidade;
    public Label lbSave;
    private int idPessoaSelc = 0;
    private boolean isMudou = false;

    @FXML
    protected void initialize () {
        App.addOnChageScreenListener((newScreen, userData) -> {
            if (Objects.equals(newScreen, telaEditarPessoa)) {
                //Acontecer quando trocar de tela
                if (userData != null) {
                    idPessoaSelc = Integer.parseInt((String) userData);
                    setValor();
                }
                //System.out.println(idPessoaSelc);
            }
        });
        cbEstatoCivil.getItems().addAll(getListEstatoCivil());
        cbNaturalidade.getItems().addAll(getListNaturalidade());
    }

    private void alert (String title, String header, String text, AlertType alertType) {
        Alert aE = new Alert(alertType);
        aE.setTitle(title);
        aE.setHeaderText(header);
        aE.setContentText(text);
        aE.show();
    }

    private void setValor () {
        isMudou = false;
        btnSalvar.setDisable(true);
        PessoaDTO pessoa = PessoaDAO.getPessoa(idPessoaSelc);

        assert pessoa != null;
        tfNome.setText(pessoa.getNome());
        tfNomeMae.setText(pessoa.getNomeMae());
        tfNomePai.setText(pessoa.getNomePai());
        tfRG.setText(pessoa.getNumRG());
        tfCPF.setText(pessoa.getNumCPF());
        tfTituloEleitor.setText(pessoa.getNumTituloEleitor());
        if (!Objects.equals(pessoa.getEstatoCivil(), "")) {
            cbEstatoCivil.setValue(pessoa.getEstatoCivil());
        }
        if (!Objects.equals(pessoa.getNaturalidade(), "")) {
            cbNaturalidade.setValue(pessoa.getNaturalidade());
        }
        cbEstatoCivil.setPromptText(cbEmptyP);
        cbNaturalidade.setPromptText(cbEmptyP);
        tfSenha.clear();
        tfSenhaConf.clear();
        lbSave.setText("Ao continuar as informações editadas não serão salvas. Deseja de fato continuar?");
        lbSave.setVisible(false);
    }

    public void btnVoltar () {
        if (!isMudou) {
            App.changeScreen("scAdmin");
        } else {
            lbSave.setVisible(true);
            isMudou = false;
        }
    }

    public void btnSalvar () {
        PessoaDTO pessoa = new PessoaDTO(tfNome.getText(), tfNomeMae.getText(), tfNomePai.getText(), cbEstatoCivil.getValue(), cbNaturalidade.getValue(), tfTituloEleitor.getText(), tfRG.getText(), tfCPF.getText());
        pessoa.setId(idPessoaSelc);
        if (PessoaDAO.editarPessoa(pessoa)) {
            App.changeScreen("scAdmin");
        }
    }

    public void mudou () {
        lbSave.setVisible(false);
        isMudou = true;
        btnSalvar.setDisable(false);
    }
}
