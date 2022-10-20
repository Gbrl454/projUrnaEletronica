package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.database.dao.PartidoDAO;
import gbrl.ue.database.dao.PessoaDAO;
import gbrl.ue.database.dto.PartidoDTO;
import gbrl.ue.database.dto.PessoaDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerAdmin {
    public TextField tfPesquisarPessoas;
    public Button btnPesquisarPessoas, btnCadastrarPessoas;
    public ListView<PessoaDTO> lvPessoas;

    public TextField tfPesquisarPartidos;
    public Button btnPesquisarPartidos, btnCadastrarPartidos;
    public ListView<PartidoDTO> lvPartidos;

    @FXML
    protected void initialize () {
        App.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
            carregarListaPessoas();
        });
        carregarListaPessoas();
        carregarListaPartidos();
    }

    public void alertError (String title, String header, String txt) {
        Alert alertError = new Alert(AlertType.ERROR);
        alertError.setTitle(title);
        alertError.setHeaderText(header);
        alertError.setContentText(txt);
        alertError.show();
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
                alertError("Pesquisa", null, "Pessoa pesquisada não encontrada");
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

    public void slcOpcLvPessoas () {
        if (lvPessoas.getSelectionModel().getSelectedItem() != null) {
            int idSelc = lvPessoas.getSelectionModel().getSelectedItem().getId();
            System.out.println(idSelc);
        }
    }

    // CADASTRAR PARTIDOS
    public void btnCadastrarPartidos () {
        App.changeScreen("scCadastrarPartido");
    }

    // PESQUISAR PARTIDOS
    public void pesquisarPartidos () {
        carregarListaPartidos();
    }

    public void btnPesquisarPartidos () {
        pesquisarPartidos();
        if (!tfPesquisarPartidos.getText().isEmpty()) {
            if (PartidoDAO.partidoShr.isEmpty()) {
                alertError("Pesquisa", null, "Partido pesquisado não encontrado");
            }
        }
    }

    public void carregarListaPartidos () {
        ObservableList<PartidoDTO> obsPartido;
        if (PartidoDAO.shrPartido(tfPesquisarPartidos.getText()).isEmpty()) {
            obsPartido = FXCollections.observableArrayList(PartidoDAO.listPartidos());
        } else {
            obsPartido = FXCollections.observableArrayList(PartidoDAO.shrPartido(tfPesquisarPartidos.getText().toLowerCase()));
        }
        lvPartidos.setItems(obsPartido);
    }

    public void slcOpcLvPartidos () {
        if (lvPartidos.getSelectionModel().getSelectedItem() != null) {
            int idSelc = lvPartidos.getSelectionModel().getSelectedItem().getId();
            System.out.println(idSelc);
        }
    }

}
