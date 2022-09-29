package com.wizeline.test;

import com.wizeline.config.DriverConfig;
import com.wizeline.driver.DriverActions;
import com.wizeline.reporting.TestResultWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DriverConfig.class})
@ExtendWith({SpringExtension.class,TestResultWatcher.class})
public abstract class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${todoist.url}")
    protected String todoistUrl;

    @Value("${todoist.username}")
    protected String username;

    @Value(("${todoist.password}"))
    protected String password;

    @Autowired
    private WebDriver webDriver;
    @Autowired
    protected DriverActions driverActions;


    @BeforeEach
    public void setup(TestInfo testName){
        webDriver.manage().deleteAllCookies();
        logger.info("Starting test execution for " + testName.getDisplayName());
    }


    @AfterEach
    public void tearUp(TestInfo testName){
        logger.info("Completed test execution for " + testName.getDisplayName());
    }
}
