package com.anna.junit5.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class LogExceptionHandler implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        //"log" the exception - imagine fancy logging framework here
        if (context.getTestMethod().isPresent()) {
            System.out.println(
                    throwable.getClass().getSimpleName()
                    + " thrown by method '" + context.getTestMethod().get().getName()
                    + "' with message: '" + throwable.getMessage() + "'");
        }

        throw throwable;
    }
}
