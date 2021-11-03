package com.kenzie.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{

    /*
        A EntryPass is unique if there is no pass with the same ID and access level.
        You will need to override equals() in EntryPass to check for equality of these items
        The equals() comparison is case-sensitive meaning VIP is not equal to vip. This is okay.
     */

    public static boolean addPassIfUnique(HashMap<String, EntryPass> entryPassHashMap, EntryPass entryPass){
        //fill in method
        String key = entryPass.getName() + entryPass.getId();

            if (!(entryPassHashMap.containsValue(entryPass))) {
                entryPassHashMap.put(key, entryPass);
                return true;
            } else {
                return false;
            }
        }
    /*
        getVIPList should return any name with a VIP pass. In this method, consider any case value of "vip"
        to be a valid VIP pass. Example: "vip" and "VIP" are both VIP passes.
     */
    public static ArrayList<String> getVIPList(HashMap<String, EntryPass> hashMap){
        //fill in method
        ArrayList<String> vipList = new ArrayList<>();

        for (HashMap.Entry<String, EntryPass> entry : hashMap.entrySet()) {
            if (entry.getValue().getAccessLevel().equalsIgnoreCase("VIP")) {
                vipList.add(entry.getValue().getName());
            }
        }
        return vipList;
    }

    public static void main(String[] args) {
        HashMap<String, EntryPass> entryPassesByName = new HashMap<>();
        ArrayList<String> blockList = new ArrayList<>();

        //define local variables as needed

        // write your code here
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Enter name:");
            String name = scan.nextLine();

            System.out.println("Enter id:");
            String id = scan.nextLine();

            System.out.println("Enter your access level:");
            String accessLevel = scan.nextLine();

            EntryPass scanObject = new EntryPass(name, id, accessLevel);

            if (addPassIfUnique(entryPassesByName, scanObject)) {
                System.out.println("Added to EntryList");
            } else if (!addPassIfUnique(entryPassesByName, scanObject)) {
                blockList.add(name);
                System.out.println("Blocked");
            }

            System.out.println("Continue? Y/N");
            String response = scan.nextLine();
            if (response.equalsIgnoreCase("N")){
                break;
            }
        }

        //Use this print statement at the end of the program. Do not modify!
        System.out.println("Entry Pass List:");
        System.out.println(entryPassesByName.entrySet());
        System.out.println("Blocked list:");
        System.out.println(blockList);
        System.out.println("VIP List:");
        System.out.println(getVIPList(entryPassesByName));
    }
}