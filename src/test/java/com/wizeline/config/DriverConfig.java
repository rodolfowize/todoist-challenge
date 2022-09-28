package com.wizeline.config;


import com.wizeline.driver.DriverFactory;
import com.wizeline.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.time.Duration;

@Configuration
@ComponentScan(basePackages = "com.wizeline")
@PropertySource("classpath:/test.properties")
public class DriverConfig {

    @Value("${browser}")
    private Browser browser;

    @Value("${web.element.timeout}")
    private int timeout;

    @Autowired
    DriverFactory driverFactory;
    @Autowired
    Environment environment;

    @Bean
    public WebDriver webDriver(){
        return driverFactory.get(browser, environment);
    }

    @Bean
    public WebDriverWait webDriverWait(){
        return new WebDriverWait(webDriver(), Duration.ofSeconds(timeout));
    }
}
