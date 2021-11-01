package com.kenzie.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MainTest {

    HashMap<String, EntryPass> entryPassesByName = new HashMap<>();
    ArrayList<String> blockList = new ArrayList<>();

    @Test
    public void testEntryPass_Constructor(){
        EntryPass entryPass = new EntryPass("Homer","12345","VIP");
        assertNotNull(entryPass);
    }

    @Test
    public void testAddPassIfUnique_CanAddOnePass(){
        entryPassesByName.clear();
        EntryPass entryPass = new EntryPass("Homer","12345","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass);
        assertEquals(1, entryPassesByName.size(),"Test: Add one EntryPass to empty HashMap");
        assertNotNull(entryPassesByName.get("Homer12345"),"Test: Key set to name+id");
    }

    @Test
    public void testAddPassIfUnique_CanAddMultiplePasses(){
        entryPassesByName.clear();
        EntryPass entryPass1 = new EntryPass("Homer","12345","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass1);
        EntryPass entryPass2 = new EntryPass("Maggie","23456","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass2);
        EntryPass entryPass3 = new EntryPass("Marge","34567","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass3);

        assertEquals(3, entryPassesByName.size(),"Test: Add multiple EntryPass to empty HashMap");
    }


    @Test
    public void testAddPassIfUnique_DuplicatePassNotAdded(){
        entryPassesByName.clear();
        EntryPass entryPass1 = new EntryPass("Homer","12345","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass1);

        EntryPass entryPass2 = new EntryPass("Maggie","12345","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass2);

        assertEquals(1, entryPassesByName.size(),"Test: Duplicate pass not added");
        assertNotNull(entryPassesByName.get("Homer12345"), "Test: Original EntryPass kept");

        EntryPass entryPass3 = new EntryPass("Lisa","12345","vip");
        Main.addPassIfUnique(entryPassesByName,entryPass3);

        //assertEquals(1, entryPassesByName.size(),"Test: Duplicate pass case-insensitive not added");
        //assertNotNull(entryPassesByName.get("Homer12345"), "Test: Original EntryPass kept");
    }

    @Test
    public void testAddPassIfUnique_NewPassSameKeyUpdated(){
        entryPassesByName.clear();
        EntryPass entryPass1 = new EntryPass("Homer","12345","VIP");
        Main.addPassIfUnique(entryPassesByName,entryPass1);

        EntryPass entryPass2 = new EntryPass("Homer","12345","general");
        Main.addPassIfUnique(entryPassesByName,entryPass2);

        assertEquals(1, entryPassesByName.size(),"Test: Duplicate key updates entry");
        assertNotNull(entryPassesByName.get("Homer12345"), "Test: Original key retained");
        EntryPass currentEntry = entryPassesByName.get("Homer12345");
        assertEquals("general", currentEntry.getAccessLevel(), "Test: accessLevel updated");
    }


    @Test
    public void testGetVIPList_VIPFound(){
        entryPassesByName.clear();
        EntryPass entryPass1 = new EntryPass("Homer","12345","VIP");
        EntryPass entryPass2 = new EntryPass("Maggie","23456","vip");
        EntryPass entryPass3 = new EntryPass("Marge","34567","general");
        entryPassesByName.put("Homer12345",entryPass1);
        entryPassesByName.put("Maggie23456",entryPass2);
        entryPassesByName.put("Marge34567",entryPass3);
        ArrayList<String> vipList = Main.getVIPList(entryPassesByName);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Homer");
        expectedList.add("Maggie");
        assertEquals(2, vipList.size(),"Test: Found vips in list");
        assertEquals(expectedList,vipList,"Test: VIP ArrayList contains expected values");
        entryPassesByName.clear();
        assertEquals(0,Main.getVIPList(entryPassesByName).size(),"Test: No VIP returns empty list");
    }

}

