package com.anna.junit5.extensions;

import com.anna.junit5.cards.CardProvider;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * - PostProcessor can modify the test class before the test runs
 */
@ExtendWith(CardProviderPostProcessor.class)
class CardProviderPostProcessorTest {

    @Setter
    private CardProvider cardProvider;

    @Test
    void testGetAllCards() {
        assertEquals(32, cardProvider.getAllCards().size());
    }
}
