package com.tatf.adminces.modules.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected IBrowser browser;

    @BeforeEach
    public void configuration() {
        browser = BrowserFactory.getBrowser();;
    }

    @AfterEach
    public void close() {
        BrowserFactory.quitBrowser();
    }
}