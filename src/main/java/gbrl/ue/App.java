package gbrl.ue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {
    private static final ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    private static Stage stage;
    private static Scene scLogin, scAdmin, scCadastrarPessoa, scUrnaEletronica;

    public static void changeScreen (String scene, Object userData) {
        switch (scene) {
            case "scLogin" -> {
                stage.setScene(scLogin);
                notfifyListeners("scLogin", userData);
            }
            case "scAdmin" -> {
                stage.setScene(scAdmin);
                notfifyListeners("scAdmin", userData);
            }
            case "scCadastrarPessoa" -> {
                stage.setScene(scCadastrarPessoa);
                notfifyListeners("scCadastrarPessoa", userData);
            }
            case "scUrnaEletronica" -> {
                stage.setScene(scUrnaEletronica);
                notfifyListeners("scUrnaEletronica", userData);
            }

        }
    }

    public static void changeScreen (String scene) {
        changeScreen(scene, null);
    }

    public static void main (String[] args) {
        launch();
    }

    public static void addOnChegeScreenListener (OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notfifyListeners (String newScreen, Object userData) {
        for (OnChangeScreen l : listeners) {
            l.onScreenChanged(newScreen, userData);
        }
    }

    @Override
    public void start (Stage stageS) throws IOException {
        stage = stageS;

        int H = 17 * 64;
        int W = 10 * 64;

        stageS.resizableProperty().setValue(Boolean.FALSE);

        FXMLLoader fxmlLogin = new FXMLLoader(App.class.getResource("vwLogin.fxml"));
        scLogin = new Scene(fxmlLogin.load(), H, W);

        FXMLLoader fxmlAdmin = new FXMLLoader(App.class.getResource("vwAdmin.fxml"));
        scAdmin = new Scene(fxmlAdmin.load(), H, W);

        FXMLLoader fxmlCadastrarPessoa = new FXMLLoader(App.class.getResource("vwCadastrarPessoa.fxml"));
        scCadastrarPessoa = new Scene(fxmlCadastrarPessoa.load(), H, W);

        FXMLLoader fxmlUrnaEletronica = new FXMLLoader(App.class.getResource("vwUrnaEletronica.fxml"));
        scUrnaEletronica = new Scene(fxmlUrnaEletronica.load(), H, W);

        stageS.setTitle("Justiça Eleitoral");
        stageS.setScene(scLogin);
        stageS.show();
    }

    public interface OnChangeScreen {
        void onScreenChanged (String newScreen, Object userData);
    }
}