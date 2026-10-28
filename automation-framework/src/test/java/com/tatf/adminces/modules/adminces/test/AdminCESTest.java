package com.tatf.adminces.modules.adminces.test;


import com.tatf.adminces.modules.adminces.task.AdminCESTask;
import com.tatf.adminces.modules.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.tatf.core.util.ConfigReader;


public class AdminCESTest extends BaseTest {

    private AdminCESTask adminCES;

    @BeforeEach
    public void configurar() {
        this.adminCES = new AdminCESTask(browser);

        ConfigReader config = new ConfigReader("config.properties");

        this.adminCES.enterAdminCES(
                config.asString("adminces.url"),
                config.asString("adminces.hash")
        );
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/adminces.csv",
            useHeadersInDisplayName = true
    )
    public void crearCuentaAdministrador(
            String firstName,
            String lastName,
            String email,
            String password,
            String country,
            String expectedMessage
    ) {

        this.adminCES.createAdministrator(
                firstName,
                lastName,
                email,
                password,
                country,
                expectedMessage
        );
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/reiniciar_contrasena.csv",
            useHeadersInDisplayName = true
    )
    public void reiniciarContrasena(
            String email,
            String password,
            String expectedMessage
    ) {

        this.adminCES.resetPassword(
                email,
                password,
                expectedMessage
        );
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/crear_tester.csv",
            useHeadersInDisplayName = true
    )
    public void crearCuentaTester(
            String adminEmail,
            String password,
            String expectedLoginMessage,
            String testerFirstName,
            String testerLastName,
            String testerEmail,
            String country,
            String expectedCreateMessage
    ) {

        this.adminCES.loginAdministrator(
                adminEmail,
                password,
                expectedLoginMessage
        );

        this.adminCES.createTester(
                testerFirstName,
                testerLastName,
                testerEmail,
                password,
                country,
                expectedCreateMessage
        );
    }

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/eliminar_tester.csv",
            useHeadersInDisplayName = true
    )
    public void eliminarCuentaTester(
            String adminEmail,
            String password,
            String expectedLoginMessage,
            String testerFirstName,
            String testerLastName,
            String testerEmail,
            String country,
            String expectedCreateMessage,
            String expectedDeleteQuestion,
            String expectedDeleteMessage
    ) {

        this.adminCES.loginAdministrator(
                adminEmail,
                password,
                expectedLoginMessage
        );

        this.adminCES.deleteTester(
                testerFirstName,
                testerLastName,
                testerEmail,
                password,
                country,
                expectedCreateMessage,
                expectedDeleteQuestion,
                expectedDeleteMessage
        );
    }
}