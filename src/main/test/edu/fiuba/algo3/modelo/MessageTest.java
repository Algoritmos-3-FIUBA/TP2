package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void testmessageGreeting01() {
        Message message = new Message("Hello world!");

        assertEquals("Hello world!", message.greet());
    }
}