package com.anna.junit5.extensions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.anna.junit5.cards.CardProvider;

@ExtendWith({TimingExtension.class, CardProviderParameterResolver.class})
class TimingExtensionTest {

    @Test
    void testGetAllCards(CardProvider cardProvider) throws InterruptedException {
        assertEquals(32, cardProvider.getAllCards().size());
        Thread.sleep(100);
    }

}
