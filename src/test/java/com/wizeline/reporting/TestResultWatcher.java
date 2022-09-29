package com.wizeline.reporting;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class TestResultWatcher implements TestWatcher
{
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        if(context.getExecutionException().isPresent()){
           Screenshot screenshot = SpringExtension.getApplicationContext(context).getBean(Screenshot.class);
            screenshot.makeScreenshotOnFailure(context.getDisplayName());
        }

    }
}
