package com.tatf.adminces.modules.adminces.pom;

import com.tatf.core.browser.IBrowser;

public class RegisterPO {

    private final IBrowser browser;

    private final String firstNameInput = "input[name='inputFirstName']";
    private final String lastNameInput = "input[name='inputLastName']";
    private final String emailInput = "input[name='inputEmail']";
    private final String passwordInput = "input[name='inputPassword']";
    private final String repeatPasswordInput = "input[name='inputRepeatPassword']";
    private final String countryInput = "input[name='inputCountry']";
    private final String countrySelect = "select[name='inputCountry']";
    private final String testerJunior = "testerJunior";
    private final String registerButton = "btnRegister";
    private final String message = "swal2-html-container";
    private final String confirmButton = "button.swal2-confirm";

    public RegisterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void waitRegisterPage() {
        this.browser.wait(registerButton).id();
    }

    public void enterFirstName(String firstName) {
        this.browser.find()
                .css(firstNameInput)
                .write(firstName);
    }

    public void enterLastName(String lastName) {
        this.browser.find()
                .css(lastNameInput)
                .write(lastName);
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

    public void enterCountry(String country) {
        this.browser.find()
                .css(countryInput)
                .write(country);
    }

    public void selectCountry(String country) {
        this.browser.find()
                .css(countrySelect)
                .selectValue(country);
    }

    public void selectTesterJunior() {
        this.browser.find()
                .id(testerJunior)
                .click();
    }

    public void clickRegister() {
        this.browser.find()
                .id(registerButton)
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
}