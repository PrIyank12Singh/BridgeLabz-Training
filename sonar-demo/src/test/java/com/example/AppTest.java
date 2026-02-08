package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testAdd() {
        App app = new App();
        assertEquals(8, app.add(3, 5));
        assertEquals(0, app.add(-3, 3));
    }

    @Test
    void testIsPositive() {
        App app = new App();
        assertTrue(app.isPositive(10));
        assertFalse(app.isPositive(-5));
        assertFalse(app.isPositive(0));
    }
}
