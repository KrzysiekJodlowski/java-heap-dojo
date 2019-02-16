package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CustomHeapTest {
    private CustomHeap customHeap;

    @BeforeEach
    public void prepareCustomHeap() {
        this.customHeap = new CustomHeap();
    }

    @Test
    public void testAddingToCustomHeap() {

        assertTrue(this.customHeap.add(23));
        assertTrue(this.customHeap.add(32));
        assertTrue(this.customHeap.add(43));

    }

    @Test
    public void testClearingCustomHeap() {

        this.customHeap.add(32);
        this.customHeap.add(43);
        this.customHeap.clear();

        assertEquals(0, this.customHeap.size());
    }

    @Test
    public void testContainingInCustomHeap() {

        this.customHeap.add(23);
        this.customHeap.add(32);
        this.customHeap.add(43);

        assertTrue(this.customHeap.contains(32));
        assertFalse(this.customHeap.contains(10));
    }

    @Test
    public void testPeekingCustomHeap() throws EmptyHeapException {

        this.customHeap.add(23);
        this.customHeap.add(43);
        this.customHeap.add(32);

        assertEquals(43, this.customHeap.peek());
    }

    @Test
    public void testIfThrowsEmptyHeapExceptionWhilePeekingEmptyHeap () {

        assertThrows(EmptyHeapException.class, () -> this.customHeap.peek());
    }

    @Test
    public void testPollingCustomHeap() throws EmptyHeapException {

        this.customHeap.add(23);
        this.customHeap.add(32);
        this.customHeap.add(43);

        assertEquals(43, this.customHeap.poll());
        assertEquals(32, this.customHeap.poll());
        assertEquals(23, this.customHeap.poll());
    }

    @Test
    public void testIfThrowsEmptyHeapExceptionWhilePollingEmptyHeap () {

        assertThrows(EmptyHeapException.class, () -> this.customHeap.poll());
    }

    @Test
    public void testCheckingSizeOfACustomHeap() {

        this.customHeap.add(23);
        this.customHeap.add(32);
        this.customHeap.add(43);

        assertEquals(3, this.customHeap.size());
    }

    @Test
    public void testGettingArrayOfACustomHeap() {

        this.customHeap.add(23);
        this.customHeap.add(43);
        this.customHeap.add(32);

        assertEquals(" 43, 23, 32,", this.customHeap.toString());
    }

}