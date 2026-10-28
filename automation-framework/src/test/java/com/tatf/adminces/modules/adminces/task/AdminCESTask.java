package com.tatf.adminces.modules.adminces.task;

import com.tatf.adminces.modules.adminces.pom.*;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;

public class AdminCESTask {

    private final IBrowser browser;
    private final AccessPO access;
    private final RegisterPO register;
    private final LoginPO login;
    private final ResetPasswordPO resetPassword;
    private final UsersPO users;

    public AdminCESTask(IBrowser browser) {
        this.browser = browser;
        this.access = new AccessPO(browser);
        this.register = new RegisterPO(browser);
        this.login = new LoginPO(browser);
        this.resetPassword = new ResetPasswordPO(browser);
        this.users = new UsersPO(browser);
    }

    public void enterAdminCES(String url, String hash) {

        this.browser.interaction()
                .navigateTo(url);

        this.access.enterHash(hash);
        this.access.clickEnter();
        this.access.waitMainPage();
    }

    public void createAdministrator(
            String firstName,
            String lastName,
            String email,
            String password,
            String country,
            String expectedMessage) {

        this.access.clickRegister();

        this.register.waitRegisterPage();
        this.register.enterFirstName(firstName);
        this.register.enterLastName(lastName);
        this.register.enterEmail(email);
        this.register.enterPassword(password);
        this.register.enterRepeatPassword(password);
        this.register.enterCountry(country);
        this.register.clickRegister();
        this.register.waitMessage();

        IVerify.create().verify(
                expectedMessage,
                this.register.getMessage(),
                "No se mostró el mensaje de usuario creado."
        );
    }

    public void resetPassword(
            String email,
            String password,
            String expectedMessage) {

        this.access.clickResetPassword();

        this.resetPassword.waitResetPage();
        this.resetPassword.enterEmail(email);
        this.resetPassword.enterPassword(password);
        this.resetPassword.enterRepeatPassword(password);
        this.resetPassword.clickReset();
        this.resetPassword.waitMessage();

        IVerify.create().verify(
                expectedMessage,
                this.resetPassword.getMessage(),
                "No se mostró el mensaje de contraseña reiniciada."
        );
    }

    public void loginAdministrator(
            String email,
            String password,
            String expectedMessage) {

        this.access.clickLogin();

        this.login.waitLoginPage();
        this.login.enterEmail(email);
        this.login.enterPassword(password);
        this.login.clickLogin();
        this.login.waitMessage();

        IVerify.create().verify(
                expectedMessage,
                this.login.getMessage(),
                "No se inició la sesión correctamente."
        );

        this.login.clickConfirm();
        this.login.waitLoggedPage();
    }

    public void createTester(
            String firstName,
            String lastName,
            String email,
            String password,
            String country,
            String expectedMessage) {

        this.login.clickCreateUser();

        this.register.waitRegisterPage();
        this.register.enterFirstName(firstName);
        this.register.enterLastName(lastName);
        this.register.enterEmail(email);
        this.register.selectCountry(country);
        this.register.enterPassword(password);
        this.register.selectTesterJunior();
        this.register.clickRegister();
        this.register.waitMessage();

        IVerify.create().verify(
                expectedMessage,
                this.register.getMessage(),
                "No se mostró el mensaje de usuario creado."
        );
    }

    public void deleteTester(
            String firstName,
            String lastName,
            String email,
            String password,
            String country,
            String expectedCreateMessage,
            String expectedDeleteQuestion,
            String expectedDeleteMessage) {

        this.login.clickCreateUser();

        this.register.waitRegisterPage();
        this.register.enterFirstName(firstName);
        this.register.enterLastName(lastName);
        this.register.enterEmail(email);
        this.register.selectCountry(country);
        this.register.enterPassword(password);
        this.register.selectTesterJunior();
        this.register.clickRegister();
        this.register.waitMessage();

        IVerify.create().verify(
                expectedCreateMessage,
                this.register.getMessage(),
                "No se pudo crear el Tester que se utilizará para eliminar."
        );

        this.register.clickConfirm();
        this.login.waitLoggedPage();

        this.login.clickViewUsers();

        this.users.waitUsersTable();
        this.users.waitUserByEmail(email);
        this.users.clickDeleteUser(email);
        this.users.waitMessage();

        IVerify.create().verify(
                expectedDeleteQuestion,
                this.users.getMessage(),
                "No se mostró la confirmación para eliminar el usuario esperado."
        );

        this.users.clickConfirm();
        this.users.waitUserDeletedMessage();

        IVerify.create().verify(
                expectedDeleteMessage,
                this.users.getMessage(),
                "No se mostró el mensaje de usuario eliminado."
        );
    }
}