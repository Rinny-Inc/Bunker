package io.noks.bunker.enums;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum BuildShopEnum {
	STONE(new ItemStack(Material.STONE, 16), 20),
	COBBLESTONE(new ItemStack(Material.COBBLESTONE, 16), 20),
	CHEST(new ItemStack(Material.CHEST, 16), 50),
	GATE(new ItemStack(Material.FENCE_GATE, 16), 25),
	LADDER(new ItemStack(Material.LADDER, 16), 10),
	BUTTON(new ItemStack(Material.STONE_BUTTON, 16), 5),
	TRAPPED_CHEST(new ItemStack(Material.TRAPPED_CHEST, 16), 50),
	PICKAXE(new ItemStack(Material.DIAMOND_PICKAXE, 1), 50),
	AXE(new ItemStack(Material.DIAMOND_AXE, 1), 50),
	SHOVEL(new ItemStack(Material.DIAMOND_SPADE, 1), 50);
	
	private ItemStack itemStack;
	private int price;
	
	BuildShopEnum(ItemStack itemStack, int price) {
		this.itemStack = itemStack;
		this.price = price;
	}
	
	public ItemStack getItemStack() {
		return this.itemStack;
	}
	
	public int getPrice() {
		return this.price;
	}
}
