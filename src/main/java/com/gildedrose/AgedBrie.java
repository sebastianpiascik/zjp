package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        setSellIn(getSellIn() - 1);
        increaseQuality();
        if (getSellIn() < 0) increaseQuality();
    }
}
