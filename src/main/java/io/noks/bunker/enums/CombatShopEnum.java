package io.noks.bunker.enums;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum CombatShopEnum {
	SWORD(new ItemStack(Material.DIAMOND_SWORD, 1), 18, 100, false, null),
	HELMET(new ItemStack(Material.DIAMOND_HELMET, 1), 10, 75, false, null),
	CHESTPLATE(new ItemStack(Material.DIAMOND_CHESTPLATE, 1), 19, 200, false, null),
	LEGGINGS(new ItemStack(Material.DIAMOND_LEGGINGS, 1), 28, 150, false, null),
	BOOTS(new ItemStack(Material.DIAMOND_BOOTS, 1), 37, 75, false, null),
	DIAMOND_SET(new ItemStack(Material.DIAMOND, 1), 20, 600, false, Arrays.asList(new ItemStack(Material.DIAMOND_SWORD, 1), new ItemStack(Material.DIAMOND_HELMET, 1), new ItemStack(Material.DIAMOND_CHESTPLATE, 1), new ItemStack(Material.DIAMOND_LEGGINGS, 1), new ItemStack(Material.DIAMOND_BOOTS, 1))),
	ENDERPEARL(new ItemStack(Material.DIAMOND, 1), 21, 25, true, null), // rightclick = 400 for 16
	ANTIDOTE(new ItemStack(Material.POTION, 1), 39, 150, false, null),
	POTION_SPEED(new ItemStack(Material.POTION, 1, (short) 8226), 14, 10, false, null),
	POTION_POISON(new ItemStack(Material.POTION, 1, (short) 16420), 15, 10, false, null),
	POTION_SLOWNESS(new ItemStack(Material.POTION, 1, (short) 16426), 16, 10, false, null),
	RED_MUSHROOM(new ItemStack(Material.RED_MUSHROOM, 16), 23, 10, false, null),
	BROWN_MUSHROOM(new ItemStack(Material.BROWN_MUSHROOM, 16), 24, 10, false, null),
	BOWL(new ItemStack(Material.BOWL, 16), 25, 10, false, null),
	SOUP(new ItemStack(Material.MUSHROOM_SOUP, 1), 41, 20, true, null);
	
	private ItemStack item;
	private int slot;
	private int price;
	private boolean rightClickable;
	private List<ItemStack> content;
	 
	CombatShopEnum(ItemStack item, int slot, int price, boolean rightClickable, @Nullable List<ItemStack> content) {
		this.item = item;
		this.slot = slot;
		this.price = price;
		this.rightClickable = rightClickable;
		this.content = content;
	}
	
	public ItemStack getItemStack() {
		return this.item;
	}
	
	public int getSlot() {
		return this.slot;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public boolean isRightClickable() {
		return this.rightClickable;
	}
	
	public List<ItemStack> getContent() {
		return this.content;
	}
}
