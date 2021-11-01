package com.kenzie.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryPassTest {

    @Test
    public void testEntryPassEqualityReflexivity(){
        EntryPass e1 = new EntryPass("Homer", "12345", "VIP");
        assertTrue(e1.equals(e1));
    }

    @Test
    public void testEntryPassEqualitySymmetry(){
        EntryPass e1 = new EntryPass("Homer", "12345", "VIP");
        EntryPass e2 = new EntryPass("Homer", "12345", "VIP");
        assertTrue(e1.equals(e2));
        assertTrue(e2.equals(e1));
    }

    @Test
    public void testEntryPassEqualityTransitivity(){
        EntryPass e1 = new EntryPass("Homer", "12345", "VIP");
        EntryPass e2 = new EntryPass("Homer", "12345", "VIP");
        EntryPass e3 = new EntryPass("Homer", "12345", "VIP");
        assertTrue(e1.equals(e2));
        assertTrue(e2.equals(e3));
        assertTrue(e1.equals(e3));
    }

    @Test
    public void testEntryPassEqualityConsistency(){
        EntryPass e1 = new EntryPass("Homer", "12345", "VIP");
        EntryPass e2 = new EntryPass("Homer", "12345", "VIP");
        assertTrue(e1.equals(e2));
        assertTrue(e1.equals(e2));

        e1 = new EntryPass("Homer", "34567", "standard");
        e2 = new EntryPass("Homer", "34567", "standard");
        assertTrue(e1.equals(e2));
        assertTrue(e1.equals(e2));
    }

    @Test
    public void testEntryPassEqualityNonNullity(){
        EntryPass e1 = new EntryPass("Homer", "12345", "VIP");
        assertFalse(e1.equals(null));
    }

    @Test
    public void testEntryPassEqualityNotEqual(){
        EntryPass e1 = new EntryPass("Homer", "12345", "VIP");
        EntryPass e2 = new EntryPass("Homer", "34567", "standard");
        assertFalse(e1.equals(e2));
    }


}

