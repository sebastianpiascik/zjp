package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) continue;
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))  updateBackstage(item);
            else if (item.name.equals("Aged Brie")) updateAgedBrie(item);
            else if (item.name.startsWith("Conjured")) updateConjured(item);
            else updateNormalItem(item);
        }
    }

    public void updateAgedBrie(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.sellIn < 0) increaseQuality(item);
    }

    public void updateConjured(Item item) {
        decreaseSellIn(item);
        for (int i = 0; i < 2; i++) {
            decreaseQuality(item);
            if (item.sellIn < 0) {
                decreaseQuality(item);
            }
        }
    }

    public void updateBackstage(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.sellIn < 10) increaseQuality(item);
        if (item.sellIn < 5) increaseQuality(item);
        if (item.sellIn < 0) item.quality -= item.quality;
    }

    public void updateNormalItem(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    public void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}