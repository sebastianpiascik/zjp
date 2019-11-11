package com.gildedrose;

public class Backstage extends Item {
    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        setSellIn(getSellIn() - 1);
        increaseQuality();
        if (getSellIn() < 10) increaseQuality();
        if (getSellIn() < 5) increaseQuality();
        if (getSellIn() < 0) setQuality(getQuality() - getQuality());
    }
}
