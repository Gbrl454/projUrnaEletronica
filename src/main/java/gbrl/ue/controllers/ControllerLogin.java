package gbrl.ue.controllers;

import gbrl.ue.App;
import gbrl.ue.DadosVariaveis;
import gbrl.ue.Telas;
import gbrl.ue.database.dao.PessoaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

public class ControllerLogin extends DadosVariaveis implements Telas {
    public TextField tfUser, tfSenha;
    public Button btnLogar, btnCadastrar, btnRecuperarSenha;

    @FXML
    protected void initialize () {
        App.addOnChageScreenListener((newScreen, userData) -> {
            if (Objects.equals(newScreen, telaLogin)) {
                //Acontecer quando trocar de tela
            }
        });
    }

    public void btnLogar () {
        PESSOA_DTO_LOG = PessoaDAO.autPessoa(tfUser.getText(), tfSenha.getText());
        if (PESSOA_DTO_LOG != null) {
            App.changeScreen("scUrnaEletronica");
        }
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
