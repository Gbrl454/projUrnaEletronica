package gbrl.ue.controllers;

import gbrl.ue.Main;
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

public class ControllerAdmin extends PessoaDAO {
    public TextField tfPesquisarPessoas;
    public Button btnPesquisarPessoas, btnCadastrarPessoas;
    public ListView<PessoaDTO> lvPessoas;

    @FXML
    protected void initialize () {
        Main.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
            carregarListaPessoas();
        });
        carregarListaPessoas();
    }

    // CADASTRAR PESSOAS
    public void btnCadastrarPessoas () {
        Main.changeScreen("scCadastrarPessoa");
    }

    // PESQUISAR PESSOAS
    public void alertError (String title, String header, String txt) {
        Alert alertError = new Alert(AlertType.ERROR);
        alertError.setTitle(title);
        alertError.setHeaderText(header);
        alertError.setContentText(txt);
        alertError.show();
    }

    public void pesquisarPessoas () {
        carregarListaPessoas();
    }

    public void btnPesquisarPessoas () {
        pesquisarPessoas();
        if (!tfPesquisarPessoas.getText().isEmpty()) {
            if (pessoaShr.isEmpty()) {
                alertError("Pesquisa", null, "Pessoa pesquisada não encontrada");
            }
        }
    }

    public void carregarListaPessoas () {
        ObservableList<PessoaDTO> obsPessoa;
        if (shrPessoa(tfPesquisarPessoas.getText()).isEmpty()) {
            obsPessoa = FXCollections.observableArrayList(listPessoas());
        } else {
            obsPessoa = FXCollections.observableArrayList(shrPessoa(tfPesquisarPessoas.getText().toLowerCase()));
        }
        lvPessoas.setItems(obsPessoa);
    }

    public void slcOpcLvPessoas () {
        if (lvPessoas.getSelectionModel().getSelectedItem() != null) {
            int idSelc = lvPessoas.getSelectionModel().getSelectedItem().getId();
            System.out.println(idSelc);
        }
    }
}
