package io.noks.bunker.managers;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.noks.bunker.Main;
import io.noks.bunker.enums.CombatShopEnum;

public class InventoryManager {
	private Inventory combatShopInventory;
	private Inventory buildShopInventory;
	private Inventory sellItemInventory;
	private Inventory enchantingInventory;
	
	private Main main;
	public InventoryManager(Main main) {
		this.main = main;
		this.combatShopInventory = main.getServer().createInventory(null, 54, ChatColor.RED.toString() + ChatColor.BOLD + "Combat Shop");
		this.buildShopInventory = main.getServer().createInventory(null, 36, ChatColor.RED.toString() + ChatColor.BOLD + "Build Shop");
		this.sellItemInventory = main.getServer().createInventory(null, 9, ChatColor.RED.toString() + ChatColor.BOLD + "Sell Items");
		this.enchantingInventory = main.getServer().createInventory(null, 9, ChatColor.GREEN.toString() + ChatColor.BOLD + "Tim The Enchanter");
		this.initCombatShopInventory();
		this.initBuildShopInventory();
		this.initSellItemInventory();
		this.initEnchantingInventory();
	}
	
	private void initCombatShopInventory() {
		if (this.combatShopInventory.firstEmpty() == -1) {
			this.combatShopInventory.clear();
		}
		this.fillGlass(this.combatShopInventory);
		
		for (CombatShopEnum items : CombatShopEnum.values()) {
			final List<String> lore = Arrays.asList(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			if (items.getContent() != null) {
				for (ItemStack content : items.getContent()) {
					lore.add(ChatColor.GRAY.toString() + content.getAmount() + "x " + WordUtils.capitalizeFully(content.getType().toString().replaceAll("_", " ")));
				}
			} else {
				lore.add(ChatColor.GRAY.toString() + items.getItemStack().getAmount() + "x " + WordUtils.capitalizeFully(items.getItemStack().getType().toString().replaceAll("_", " ")));
			}
			if (items.isRightClickable()) {
				lore.add(ChatColor.YELLOW + "Rightclick to buy " + items.getItemStack().getMaxStackSize() + " for " + items.getPrice() * items.getItemStack().getMaxStackSize() + "$");
			}
			lore.add(ChatColor.GREEN + "Price: " + ChatColor.YELLOW + items.getPrice() + "$");
			lore.add(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			this.combatShopInventory.setItem(items.getSlot(), this.main.getItemUtils().getItemStack(items.getItemStack(), WordUtils.capitalizeFully(items.name().replaceAll("_", "")), (String[])lore.toArray()));
		}
	}
	
	private void initBuildShopInventory() {
		if (this.buildShopInventory.firstEmpty() == -1) {
			this.buildShopInventory.clear();
		}
		this.fillGlass(this.buildShopInventory);
	}

	private void initSellItemInventory() {
		if (this.sellItemInventory.firstEmpty() == -1) {
			this.sellItemInventory.clear();
		}
		this.fillGlass(this.sellItemInventory);
	}	

	private void initEnchantingInventory() {
		if (this.enchantingInventory.firstEmpty() == -1) {
			this.enchantingInventory.clear();
		}
		this.fillGlass(this.enchantingInventory);
	}
	
	private void fillGlass(Inventory inv) {
		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, this.main.getItemUtils().getItemMaterial(Material.STAINED_GLASS_PANE, 15, " "));
		}
	}
}
