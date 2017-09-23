package com.anna.junit5.template;

import com.anna.junit5.BiddingSetup;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.extension.*;

import java.util.List;

@AllArgsConstructor
public class BiddingSetupContext implements TestTemplateInvocationContext {

    private final BiddingSetup setup;

    @Override
    public String getDisplayName(int invocationIndex) {
        return "[" + invocationIndex + "] " + setup;
    }

    @Override
    public List<Extension> getAdditionalExtensions() {
        return Lists.newArrayList(new BiddingSetupParameterResolver());
    }

    private final class BiddingSetupParameterResolver implements ParameterResolver {

        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return parameterContext.getParameter().getType().equals(BiddingSetup.class);
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
            return setup;
        }
    }
}
