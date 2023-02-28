package io.noks.bunker.enums;

public enum Enchantments {
	FULL_PROTECTION_I(1000),
	SHARPNESS_I(400),
	FEATHER_FALLING_IV(200);
	
	private int price;
	
	Enchantments(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
}
