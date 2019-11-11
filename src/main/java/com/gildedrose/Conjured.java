package com.gildedrose;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        setSellIn(getSellIn() - 1);
        for (int i = 0; i < 2; i++) {
            decreaseQuality();
            if (getSellIn() < 0) {
                decreaseQuality();
            }
        }
    }
}
