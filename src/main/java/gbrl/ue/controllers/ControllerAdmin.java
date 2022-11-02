package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.DadosVariaveis;
import gbrl.ue.Telas;
import gbrl.ue.database.dao.PessoaDAO;
import gbrl.ue.database.dto.PessoaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Objects;

public class ControllerAdmin extends DadosVariaveis implements Telas {
    public TextField tfPesquisarPessoas;
    public Button btnPesquisarPessoas, btnCadastrarPessoas, btnVisualizarPessoa, btnEditarPessoa, btnDeletarPessoa;
    public ListView<PessoaDTO> lvPessoas;
    private int idPessoaSelc = 0;

    @FXML
    protected void initialize () {
        App.addOnChageScreenListener((newScreen, userData) -> {
            if (Objects.equals(newScreen, telaAdmin)) {
                //Acontecer quando trocar de tela
                reload();
            }
        });
    }

    public void reload () {
        carregarListas();
        lvPessoas.getSelectionModel().clearSelection();
        btnVisualizarPessoa.setDisable(true);
        btnEditarPessoa.setDisable(true);
        btnDeletarPessoa.setDisable(true);
        idPessoaSelc = 0;
    }

    private void carregarListas () {
        carregarListaPessoas();
        //carregarListaPartidos();
        //carregarListaCandidatos();
    }

    private void alert (String title, String header, String text, AlertType alertType) {
        Alert aE = new Alert(alertType);
        aE.setTitle(title);
        aE.setHeaderText(header);
        aE.setContentText(text);
        aE.show();
    }

    // CADASTRAR PESSOAS
    public void btnCadastrarPessoas () {
        App.changeScreen("scCadastrarPessoa", "scAdmin");
    }

    // PESQUISAR PESSOAS
    public void pesquisarPessoas () {
        carregarListaPessoas();
    }

    public void btnPesquisarPessoas () {
        pesquisarPessoas();
        if (!tfPesquisarPessoas.getText().isEmpty()) {
            if (PessoaDAO.pessoaShr.isEmpty()) {
                alert("Pesquisa", null, "Pessoa pesquisada não encontrada", AlertType.ERROR);
            }
        }
    }

    public void carregarListaPessoas () {
        ObservableList<PessoaDTO> obsPessoa;
        if (PessoaDAO.shrPessoa(tfPesquisarPessoas.getText()).isEmpty()) {
            obsPessoa = FXCollections.observableArrayList(PessoaDAO.listPessoas());
        } else {
            obsPessoa = FXCollections.observableArrayList(PessoaDAO.shrPessoa(tfPesquisarPessoas.getText().toLowerCase()));
        }
        lvPessoas.setItems(obsPessoa);
    }

    // GERENCIAR PESSOAS
    public void slcOpcLvPessoas () {
        if (lvPessoas.getSelectionModel().getSelectedItem() != null) {
            idPessoaSelc = lvPessoas.getSelectionModel().getSelectedItem().getId();
            btnVisualizarPessoa.setDisable(false);
            btnEditarPessoa.setDisable(false);
            btnDeletarPessoa.setDisable(false);
        }
    }

    public void btnVisualizarPessoa () {
        App.changeScreen("scVerPessoa", String.valueOf(idPessoaSelc));
    }

    public void btnEditarPessoa () {
        App.changeScreen("scEditarPessoa", String.valueOf(idPessoaSelc));
    }

    public void btnDeletarPessoa () {
        if (idPessoaSelc != 0) {
            if (PessoaDAO.delPessoa(idPessoaSelc)) {
                carregarListas();
            }
        }
    }

}
