package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.DadosVariaveis;
import gbrl.ue.database.dao.PessoaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerLogin implements DadosVariaveis {
    public TextField tfUser, tfSenha;
    public Button btnLogar, btnCadastrar, btnRecuperarSenha;

    @FXML
    protected void initialize () {
        App.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
        });
    }

    public void btnLogar () {
        App.changeScreen("scUrnaEletronica");
    }

    public void btnCadastrar () {
        App.changeScreen("scCadastrarPessoa", "scLogin");
    }

    public void btnRecuperarSenha () {
    }

    public void isAdminLogin () {
        if (tfUser.getText().equalsIgnoreCase(USER_ADMIN) && tfSenha.getText().equalsIgnoreCase(SENHA_ADMIN)) {
            App.changeScreen("scAdmin");
        }
    }
}
