package io.noks.bunker.enums;

import org.bukkit.Material;

public enum ItemSellable {
	DIAMOND(Material.DIAMOND, 100),
	GOLD(Material.GOLD_INGOT, 50),
	IRON(Material.IRON_INGOT, 25),
	COAL(Material.COAL, 10);
	
	private Material material;
	private int price;
	
	ItemSellable(Material material, int price) {
		this.material = material;
		this.price = price;
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
	public int getPrice() {
		return this.price;
	}
}
