package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.DadosVariaveis;
import gbrl.ue.database.dao.PessoaDAO;
import gbrl.ue.database.dto.PessoaDTO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Objects;

public class ControllerCadastrarPessoa extends PessoaDAO implements DadosVariaveis {
    private final String cbEmptyP = "--- Selecione ---";
    private final String cbEmptyV = "";
    public TextField tfNome, tfNomeMae, tfNomePai, tfRG, tfCPF, tfTituloEleitor;
    public ComboBox<String> cbEstatoCivil, cbNaturalidade;
    public Button btnCadastrar, btnVoltar;
    boolean isNomeInput, isNomeMaeInput, isNomePaiInput, isRGInput, isCPFInput, isTituloEleitorInput;
    private String antePag = "";

    @FXML
    protected void initialize () {
        App.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
            limpar();
            antePag = (String) userData;
        });
        cbEstatoCivil.getItems().addAll(getListEstatoCivil());
        cbNaturalidade.getItems().addAll(getListNaturalidade());
    }

    private void limpar () {
        tfNome.clear();
        tfNomeMae.clear();
        tfNomePai.clear();
        tfRG.clear();
        tfCPF.clear();
        tfTituloEleitor.clear();
        cbEstatoCivil.setValue(cbEmptyP);
        cbNaturalidade.setValue(cbEmptyP);
        isNomeInput = false;
        isNomeMaeInput = false;
        isNomePaiInput = false;
        isRGInput = false;
        isCPFInput = false;
        isTituloEleitorInput = false;
    }

    private void alert (String title, String header, String text, AlertType alertType) {
        Alert aE = new Alert(alertType);
        aE.setTitle(title);
        aE.setHeaderText(header);
        aE.setContentText(text);
        aE.show();
    }

    public void btnCadastrar () {
        if (cadastrar()) {
            alert("Cadastrado", "", tfNome.getText() + " foi cadastrado(a) com sucesso", AlertType.INFORMATION);
            App.changeScreen(antePag);
        } else {
            alert("", "", "Preencha seus dados", AlertType.ERROR);
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

    private boolean cadastrar () {
        if (isCadastravel()) {
            String nome = tfNome.getText();
            String nomeMae = tfNomeMae.getText();
            String nomePai = tfNomePai.getText();
            String estatoCivil, naturalidade;

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

            if (!Objects.equals(cbEstatoCivil.getValue(), cbEmptyP)) {
                estatoCivil = cbEstatoCivil.getValue();
            } else {
                estatoCivil = cbEmptyV;
            }

            if (!Objects.equals(cbNaturalidade.getValue(), cbEmptyP)) {
                naturalidade = cbNaturalidade.getValue();
            } else {
                naturalidade = cbEmptyV;
            }

            PessoaDTO pessoa = new PessoaDTO(nome, nomeMae, nomePai, estatoCivil, naturalidade, numRG, numCPF, numTituloEleitor);
            return addPessoa(pessoa);
        } else {
            return false;
        }
    }

    public void btnVoltar () {
        limpar();
        App.changeScreen(antePag);
    }
}
