package com.barosanu;

import com.barosanu.controller.persistence.PersitenceAccess;
import com.barosanu.controller.persistence.ValidAccount;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private PersitenceAccess persitenceAccess = new PersitenceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage stage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountsList = persitenceAccess.loadFromPersistence();
        if (validAccountsList.size() > 0) {
            viewFactory.showMainWindow();
            for (ValidAccount validAccount: validAccountsList) {
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(), validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();
        }
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountsList = new ArrayList<ValidAccount>();
        for (EmailAccount emailAccount: emailManager.getEmailAccounts()) {
            validAccountsList.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persitenceAccess.saveToPersistence(validAccountsList);
    }
}
