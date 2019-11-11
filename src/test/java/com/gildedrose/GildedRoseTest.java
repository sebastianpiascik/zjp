package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testNormalItem() throws Exception {
        int quality = 12, sellIn = 1;
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void testSulfuras() throws Exception {
        int quality = 12, sellIn = 10;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void testBackstage() throws Exception {
        int quality = 30, sellIn = 11;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }

    @Test
    public void testAgedBrie() throws Exception {
        int quality = 12, sellIn = 1;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(15, app.items[0].quality);
    }

    @Test
    public void testConjured() throws Exception {
        int quality = 7, sellIn = 1;
        Item[] items = new Item[] { new Item("Conjured Mana Cake", sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }
}
