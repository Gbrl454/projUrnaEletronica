package gbrl.ue.controllers;

import gbrl.ue.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerAdmin {
    public TextField tfPesquisarPessoas;
    public Button btnPesquisarPessoas, btnCadastrarPessoas;
    public ListView lvPessoas;

    @FXML
    protected void initialize () {
        Main.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
        });
    }

    // Cadastro
    public void btnCadastrarPessoas (ActionEvent actionEvent) {
        Main.changeScreen("scCadastrarPessoa");
    }

    public void btnPesquisarPessoas (ActionEvent actionEvent) {
    }
}
