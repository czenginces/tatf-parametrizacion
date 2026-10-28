package com.tatf.adminces.modules.adminces.pom;

import com.tatf.core.browser.IBrowser;

public class UsersPO {

    private final IBrowser browser;

    private final String usersTable = "dataTable";
    private final String message = "swal2-html-container";
    private final String confirmButton = "button.swal2-confirm";

    public UsersPO(IBrowser browser) {
        this.browser = browser;
    }

    public void waitUsersTable() {
        this.browser.wait(usersTable).id();
    }

    public void waitUserByEmail(String email) {
        this.browser.wait(
                "//tr[td[contains(text(),'" + email + "')]]"
        ).xpath();
    }

    public void clickDeleteUser(String email) {
        this.browser.find()
                .xpath(
                        "//tr[td[contains(text(),'" +
                                email +
                                "')]]//button"
                )
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

    public void waitUserDeletedMessage() {
        this.browser.wait(
                "//div[@id='swal2-html-container' " +
                        "and contains(text(),'Usuario eliminado.')]"
        ).xpath();
    }
}