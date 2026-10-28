package com.tatf.adminces.modules.adminces.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {

    private final IBrowser browser;

    private final String loginForm = "formLogin";
    private final String emailInput = "input[name='inputEmail']";
    private final String passwordInput = "input[name='inputPassword']";
    private final String loginButton = "#formLogin button[type='button']";
    private final String message = "swal2-html-container";
    private final String confirmButton = "button.swal2-confirm";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void waitLoginPage() {
        this.browser.wait(loginForm).id();
    }

    public void enterEmail(String email) {
        this.browser.find()
                .css(emailInput)
                .write(email);
    }

    public void enterPassword(String password) {
        this.browser.find()
                .css(passwordInput)
                .write(password);
    }

    public void clickLogin() {
        this.browser.find()
                .css(loginButton)
                .click();
    }

    public void waitMessage() {
        this.browser.wait(message).id();
    }

    public String getMessage() {
        return this.browser.find()
                .id(message)
                .getText();
    }

    public void clickConfirm() {
        this.browser.find()
                .css(confirmButton)
                .click();
    }

    public void waitLoggedPage() {
        this.browser.wait("Crear usuario").link();
    }

    public void clickCreateUser() {
        this.browser.find()
                .link("Crear usuario")
                .click();
    }

    public void clickViewUsers() {
        this.browser.find()
                .link("Ver usuarios")
                .click();
    }
}