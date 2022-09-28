package com.wizeline.test;

import com.wizeline.config.DriverConfig;
import com.wizeline.driver.DriverActions;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DriverConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
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

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure(testName);
        }

        @Attachment("Screenshot for failure on test: {testName.name}")
        public byte[] makeScreenshotOnFailure(TestName testName) {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        }
    };

    @Before
    public void setup(){
        webDriver.manage().deleteAllCookies();
        logger.info("Starting test execution for " + testName.getMethodName());
    }

    @After
    public void tearUp(){
        logger.info("Completed test execution for " + testName.getMethodName());
        if(webDriver!= null){
            webDriver.close();
        }

    }
}
