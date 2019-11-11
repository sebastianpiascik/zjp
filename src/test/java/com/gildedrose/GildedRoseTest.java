package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void testNormalItem() throws Exception {
        int quality = 12, sellIn = 1;
        Item item = normalItem(quality, sellIn);
        updateItem(item);
        assertEquals(0, item.getSellIn());
        assertEquals(11, item.getQuality());
        updateItem(item);
        assertEquals(-1, item.getSellIn());
        assertEquals(9, item.getQuality());
    }

    @Test
    public void testSulfuras() throws Exception {
        int quality = 12, sellIn = 10;
        Item item = sulfuras(quality, sellIn);
        updateItem(item);
        assertEquals(10, item.getSellIn());
        assertEquals(12, item.getQuality());
    }

    @Test
    public void testBackstage() throws Exception {
        int quality = 30, sellIn = 11;
        Item item = backstage(quality, sellIn);
        updateItem(item);
        assertEquals(10, item.getSellIn());
        assertEquals(31, item.getQuality());
        updateItem(item);
        assertEquals(9, item.getSellIn());
        assertEquals(33, item.getQuality());
    }

    @Test
    public void testAgedBrie() throws Exception {
        int quality = 12, sellIn = 1;
        Item item = agedBrie(quality, sellIn);
        updateItem(item);
        assertEquals(0, item.getSellIn());
        assertEquals(13, item.getQuality());
        updateItem(item);
        assertEquals(-1, item.getSellIn());
        assertEquals(15, item.getQuality());
    }

    @Test
    public void testConjured() throws Exception {
        int quality = 7, sellIn = 1;
        Item item = conjured(quality, sellIn);
        updateItem(item);
        assertEquals(0, item.getSellIn());
        assertEquals(5, item.getQuality());
        updateItem(item);
        assertEquals(-1, item.getSellIn());
        assertEquals(1, item.getQuality());
    }

    private Item normalItem(int quality, int sellIn){
        return new NormalItem("Elixir of the Mongoose", sellIn, quality);
    }

    private Item sulfuras(int quality, int sellIn){
        return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    private Item backstage(int quality, int sellIn){
        return new Backstage("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    private Item agedBrie(int quality, int sellIn){
        return new AgedBrie("Aged Brie", sellIn, quality);
    }

    private Item conjured(int quality, int sellIn){
        return new Conjured("Conjured Mana Cake", sellIn, quality);
    }

    private void updateItem(Item item){
        Item[] items = new Item[] { item };
        new GildedRose(items).updateQuality();
    }

}
