package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class GildedRoseTest {

    @Test
    public void characterize() throws Exception {
        String[] names = {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert"};
        Integer[] sellins = {0, -1, 1, 2, 5, 6, 7, 10, 11, 12, MIN_VALUE, MAX_VALUE};
        Integer[] qualities = {0, -1, 1, 2, 49, 50, 51, MIN_VALUE, MAX_VALUE};
        CombinationApprovals.verifyAllCombinations(this::testCombination, names, sellins, qualities);
    }

    private Item testCombination(String name, int sellin, int quality) {
        Item[] items = new Item[]{new Item(name, sellin, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }
}
