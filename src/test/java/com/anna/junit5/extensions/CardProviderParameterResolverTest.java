package com.anna.junit5.extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.anna.junit5.cards.CardProvider;

/**
 * - ParameterResolver can be used to inject objects into the test
 */
@ExtendWith(CardProviderParameterResolver.class)
class CardProviderParameterResolverTest {

    @Test
    void testGetAllCards(CardProvider cardProvider) {
        assertEquals(32, cardProvider.getAllCards().size());
    }

}
