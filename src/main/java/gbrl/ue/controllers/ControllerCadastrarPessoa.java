package gbrl.ue.controllers;

import gbrl.ue.Main;
import gbrl.ue.database.dao.PessoaDAO;
import gbrl.ue.database.dto.PessoaDTO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerCadastrarPessoa extends PessoaDAO {
    public TextField tfNome, tfNomeMae, tfNomePai, tfRG, tfCPF, tfTituloEleitor;
    public ComboBox cbEstatoCivil, cbNaturalidade;
    public Button btnCadastrar;
    boolean isNomeInput, isNomeMaeInput, isNomePaiInput, isRGInput, isCPFInput, isTituloEleitorInput;

    @FXML
    protected void initialize () {
        Main.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
            limpar();
        });
    }

    private void limpar () {
        tfNome.clear();
        tfNomeMae.clear();
        tfNomePai.clear();
        tfRG.clear();
        tfCPF.clear();
        tfTituloEleitor.clear();
        cbEstatoCivil.setValue("--- Selecione ---");
        cbNaturalidade.setValue("--- Selecione ---");
        isNomeInput = false;
        isNomeMaeInput = false;
        isNomePaiInput = false;
        isRGInput = false;
        isCPFInput = false;
        isTituloEleitorInput = false;
    }

    public void btnCadastrar (ActionEvent actionEvent) {
        if (cadastrar()) {
            alertInformCadastrado(tfNome.getText());
            Main.changeScreen("scAdmin");
        }
    }

    public boolean isCadastravel () {
        isNomeInput = !tfNome.getText().isEmpty();
        isNomeMaeInput = !tfNomeMae.getText().isEmpty();
        isNomePaiInput = !tfNomePai.getText().isEmpty();
        isRGInput = !tfRG.getText().isEmpty();
        isCPFInput = !tfCPF.getText().isEmpty();
        isTituloEleitorInput = !tfTituloEleitor.getText().isEmpty();

        // System.out.println("Nome - " + isNomeInput + "\n" + "NomeMae - " + isNomeMaeInput + "\n" + "NomePai - " + isNomePaiInput + "\n" + "RG - " + isRGInput + "\n" + "CPF - " + isCPFInput + "\n" + "TituloEleitor - " + isTituloEleitorInput);

        return isNomeInput && isCPFInput;
    }

    public void alertInformCadastrado (String nome) {
        Alert alertInform = new Alert(Alert.AlertType.INFORMATION);
        alertInform.setTitle("Cadastrado");
        alertInform.setHeaderText("");
        alertInform.setContentText(nome + " foi cadastrado(a) com sucesso");
        alertInform.show();
    }

    private boolean cadastrar () {
        if (isCadastravel()) {
            String nome = tfNome.getText();
            String nomeMae = tfNomeMae.getText();
            String nomePai = tfNomePai.getText();
            String estatoCivil = cbEstatoCivil.getId();
            String naturalidade = cbNaturalidade.getId();
            long numRG = 0, numCPF = 0, numTituloEleitor = 0;

            if (isRGInput) {
                numRG = Long.parseLong(tfRG.getText());
            }
            if (isCPFInput) {
                numCPF = Long.parseLong(tfCPF.getText());
            }
            if (isTituloEleitorInput) {
                numTituloEleitor = Long.parseLong(tfTituloEleitor.getText());
            }

            PessoaDTO pessoa = new PessoaDTO(nome, nomeMae, nomePai, estatoCivil, naturalidade, numRG, numCPF, numTituloEleitor);
            return addPessoa(pessoa);
        } else {
            return false;
        }
    }
}
