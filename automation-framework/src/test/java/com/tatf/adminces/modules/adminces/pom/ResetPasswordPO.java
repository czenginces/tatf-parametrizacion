package com.tatf.adminces.modules.adminces.pom;

import com.tatf.core.browser.IBrowser;

public class ResetPasswordPO {

    private final IBrowser browser;

    private final String resetButton = "btnReset";
    private final String emailInput = "input[name='inputEmail']";
    private final String passwordInput = "input[name='inputPassword']";
    private final String repeatPasswordInput = "input[name='inputRepeatPassword']";
    private final String message = "swal2-html-container";

    public ResetPasswordPO(IBrowser browser) {
        this.browser = browser;
    }

    public void waitResetPage() {
        this.browser.wait(resetButton).id();
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

    public void enterRepeatPassword(String password) {
        this.browser.find()
                .css(repeatPasswordInput)
                .write(password);
    }

    public void clickReset() {
        this.browser.find()
                .id(resetButton)
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
}