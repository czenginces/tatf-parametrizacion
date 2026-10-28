package com.tatf.adminces.modules.adminces.pom;

import com.tatf.core.browser.IBrowser;

public class AccessPO {

    private final IBrowser browser;

    private final String hashInput = "pass";
    private final String enterButton = "#loginForm button[type='submit']";

    public AccessPO(IBrowser browser) {
        this.browser = browser;
    }

    public void enterHash(String hash) {
        this.browser.find()
                .id(hashInput)
                .write(hash);
    }

    public void clickEnter() {
        this.browser.find()
                .css(enterButton)
                .click();
    }

    public void waitMainPage() {
        this.browser.wait("Registrarse").link();
    }

    public void clickRegister() {
        this.browser.find()
                .link("Registrarse")
                .click();
    }

    public void clickResetPassword() {
        this.browser.find()
                .link("Reiniciar contraseña")
                .click();
    }

    public void clickLogin() {
        this.browser.find()
                .link("Iniciar sesión")
                .click();
    }
}