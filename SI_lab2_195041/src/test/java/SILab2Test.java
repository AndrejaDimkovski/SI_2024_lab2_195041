import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryBranch() {
        // Test Case 1: allItems = [null], payment = 500
        List<Item> items1 = new ArrayList<>();
        items1.add(null);
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, 500));
        assertFalse(ex1.getMessage().contains("allItems list can't be null!"));

        // Test Case 2: allItems = [new Item(null, null, 500, 0)], payment = 500
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(null, null, 500, 0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, 500));
        assertTrue(ex2.getMessage().contains("No barcode!"));

        // Test Case 3: allItems = [new Item(null, "123456789", 500, 0)], payment = 500
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item(null, "123456789", 500, 0));
        assertTrue(SILab2.checkCart(items3, 500));

        // Test Case 4: allItems = [new Item("Item1", "123456789", 500, 0)], payment = 400
        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("Item1", "123456789", 500, 0));
        assertFalse(SILab2.checkCart(items4, 400));

        // Test Case 5: allItems = [new Item("Item2", "012345678", 500, 0.1f)], payment = 500
        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("Item2", "012345678", 500, 0.1f));
        assertTrue(SILab2.checkCart(items5, 500));

        // Test Case 6: allItems = [new Item("Item3", "01234567-2", 500, 0.1f)], payment = 500
        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("Item3", "01234567-2", 500, 0.1f));
        RuntimeException ex6 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items6, 500));
        assertTrue(ex6.getMessage().contains("Invalid character in item barcode!"));
    }
    @Test
    void testMultipleCondition() {
        // Test Cases Multiple Condition
        // TTT
        Item itemTTT = new Item("Item1", "0123456789", 400, 0.1f);
        List<Item> itemsTTT = new ArrayList<>();
        itemsTTT.add(itemTTT);
        assertTrue(SILab2.checkCart(itemsTTT, 500));

        // TTF
        Item itemTTF = new Item("Item2", "1123456789", 400, 0.1f);
        List<Item> itemsTTF = new ArrayList<>();
        itemsTTF.add(itemTTF);
        assertTrue(SILab2.checkCart(itemsTTF, 500));

        // TFT
        Item itemTFT = new Item("Item3", "0123456789", 400, 0.0f);
        List<Item> itemsTFT = new ArrayList<>();
        itemsTFT.add(itemTFT);
        assertTrue(SILab2.checkCart(itemsTFT, 500));

        // TFF
        Item itemTFF = new Item("Item4", "1123456789", 400, 0.0f);
        List<Item> itemsTFF = new ArrayList<>();
        itemsTFF.add(itemTFF);
        assertTrue(SILab2.checkCart(itemsTFF, 500));

        // FTT
        Item itemFTT = new Item("Item5", "0123456789", 200, 0.1f);
        List<Item> itemsFTT = new ArrayList<>();
        itemsFTT.add(itemFTT);
        assertTrue(SILab2.checkCart(itemsFTT, 500));

        // FTF
        Item itemFTF = new Item("Item6", "1123456789", 200, 0.1f);
        List<Item> itemsFTF = new ArrayList<>();
        itemsFTF.add(itemFTF);
        assertTrue(SILab2.checkCart(itemsFTF, 500));

        // FFT
        Item itemFFT = new Item("Item7", "0123456789", 200, 0.0f);
        List<Item> itemsFFT = new ArrayList<>();
        itemsFFT.add(itemFFT);
        assertTrue(SILab2.checkCart(itemsFFT, 500));

        // FFF
        Item itemFFF = new Item("Item8", "1123456789", 200, 0.0f);
        List<Item> itemsFFF = new ArrayList<>();
        itemsFFF.add(itemFFF);
        assertTrue(SILab2.checkCart(itemsFFF, 500));
    }
}