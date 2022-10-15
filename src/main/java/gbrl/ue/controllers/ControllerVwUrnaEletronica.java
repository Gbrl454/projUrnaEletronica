package gbrl.ue.controllers;

import gbrl.ue.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ControllerVwUrnaEletronica {
    @FXML
    protected void initialize() {
        Main.addOnChegeScreenListener((newScreen, userData) -> {
            //Acontecer quando trocar de tela
        });
    }

    private final int nCargo = 5;
    public Button btnBranco, btnCorrige, btnConfirma, btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;
    public Text nVot1, nVot2, nVot3, nVot4, nVot5;
    public VBox vbNome, vbPartido;
    private String num = "";

    private void reload() {
        System.out.println("Reload");
        num = "";
        nVot1.setText("");
        nVot2.setText("");
        nVot3.setText("");
        nVot4.setText("");
        nVot5.setText("");
        numBtnsOnOff(1);
        btnConfirma.setDisable(true);
        btnCorrige.setDisable(true);
        btnBranco.setDisable(false);
        vbNome.setVisible(false);
        vbPartido.setVisible(false);
    }

    private void numBtnsOnOff(int OnOff) {
        boolean bool = false;
        switch (OnOff) {
            case 0 -> bool = true;
            case 1 -> bool = false;
        }
        btnNum0.setDisable(bool);
        btnNum1.setDisable(bool);
        btnNum2.setDisable(bool);
        btnNum3.setDisable(bool);
        btnNum4.setDisable(bool);
        btnNum5.setDisable(bool);
        btnNum6.setDisable(bool);
        btnNum7.setDisable(bool);
        btnNum8.setDisable(bool);
        btnNum9.setDisable(bool);
        btnConfirma.setDisable(!bool);
    }

    private void attNums(String[] nums) {
        if (nums.length > 0) {
            btnCorrige.setDisable(false);
        }

        switch (nums.length - 5) {
            case 0:
                nVot5.setText(nums[4]);
            case -1:
                nVot4.setText(nums[3]);
            case -2:
                nVot3.setText(nums[2]);
            case -3:
                nVot2.setText(nums[1]);
            case -4:
                nVot1.setText(nums[0]);
        }
    }

    public void btnBranco(ActionEvent actionEvent) {
        System.out.println("Votou em branco");
    }

    public void btnCorrige(ActionEvent actionEvent) {
        reload();
    }

    public void btnConfirma(ActionEvent actionEvent) {
        System.out.println("Confirmar número " + num);
    }

    public void btnNum(ActionEvent actionEvent) {
        String nSelec = ((actionEvent.getSource().toString()).split("m")[1]).split(",")[0];
        num += nSelec;
        String[] nums = num.split("");
        if (nums.length == nCargo) {
            attNums(nums);
            numBtnsOnOff(0);
            vbNome.setVisible(true);
            vbPartido.setVisible(true);
        } else {
            attNums(nums);
        }
    }
}
