package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField emailAddressField;

    @FXML
    private TextField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction!!");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);

    }

}