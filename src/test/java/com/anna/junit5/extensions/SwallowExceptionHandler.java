package com.anna.junit5.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class SwallowExceptionHandler implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        //just swallow the exception
    }
}
