package com.anna.junit5.extensions;

import com.anna.junit5.cards.CardProvider;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class CardProviderPostProcessor implements TestInstancePostProcessor {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        if (testInstance instanceof CardProviderPostProcessorTest) {
            ((CardProviderPostProcessorTest) testInstance).setCardProvider(new CardProvider());
        }
    }
}
