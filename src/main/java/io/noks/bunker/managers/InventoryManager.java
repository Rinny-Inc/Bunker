package io.noks.bunker.managers;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.noks.bunker.Main;
import io.noks.bunker.enums.BuildShopEnum;
import io.noks.bunker.enums.CombatShopEnum;
import io.noks.bunker.enums.Enchantments;
import io.noks.bunker.enums.ItemSellable;

public class InventoryManager {
	private Inventory combatShopInventory;
	private Inventory buildShopInventory;
	private Inventory enchantingInventory;
	
	private Main main;
	public InventoryManager(Main main) {
		this.main = main;
		this.combatShopInventory = main.getServer().createInventory(null, 54, ChatColor.RED.toString() + ChatColor.BOLD + "Combat Shop");
		this.buildShopInventory = main.getServer().createInventory(null, 27, ChatColor.RED.toString() + ChatColor.BOLD + "Build Shop");
		this.enchantingInventory = main.getServer().createInventory(null, 9, ChatColor.GREEN.toString() + ChatColor.BOLD + "Tim The Enchanter");
		this.initCombatShopInventory();
		this.initBuildShopInventory();
		this.initEnchantingInventory();
	}
	
	private void initCombatShopInventory() {
		if (this.combatShopInventory.firstEmpty() == -1) {
			this.combatShopInventory.clear();
		}
		this.fillGlass(this.combatShopInventory);
		
		for (CombatShopEnum items : CombatShopEnum.values()) {
			final List<String> lore = Arrays.asList(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			final String itemName = WordUtils.capitalizeFully(items.name().replaceAll("_", ""));
			if (items.getContent() != null) {
				for (ItemStack content : items.getContent()) {
					lore.add(ChatColor.GRAY.toString() + content.getAmount() + "x " + WordUtils.capitalizeFully(content.getType().toString().replaceAll("_", " ")));
				}
			} else {
				lore.add(ChatColor.GRAY.toString() + items.getItemStack().getAmount() + "x " + (items.name().contains("POTION") ? itemName : WordUtils.capitalizeFully(items.getItemStack().getType().toString().replaceAll("_", " "))));
			}
			if (items.isRightClickable()) {
				lore.add(ChatColor.YELLOW + "    - " + ChatColor.GREEN + "Right-click to " + (items == CombatShopEnum.MUSHROOM_SOUP ? "fill your inventory" : "buy " + items.getItemStack().getMaxStackSize() + " for " + (items.getPrice() * items.getItemStack().getMaxStackSize()) + "$"));
			}
			lore.add(ChatColor.GREEN + "Price: " + ChatColor.YELLOW + items.getPrice() + "$");
			lore.add(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			this.combatShopInventory.setItem(items.getSlot(), this.main.getItemUtils().getItemStack(items.getItemStack(), itemName, (String[])lore.toArray()));
		}
	}
	
	private void initBuildShopInventory() {
		if (this.buildShopInventory.firstEmpty() == -1) {
			this.buildShopInventory.clear();
		}
		this.fillGlass(this.buildShopInventory);
		
		int slot = 0;
		for (BuildShopEnum items : BuildShopEnum.values()) {
			final List<String> lore = Arrays.asList(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			final String itemName = WordUtils.capitalizeFully(items.name().replaceAll("_", ""));
			lore.add(ChatColor.GRAY.toString() + items.getItemStack().getAmount() + "x " + WordUtils.capitalizeFully(items.getItemStack().getType().toString().replaceAll("_", " ")));
			lore.add(ChatColor.GREEN + "Price: " + ChatColor.YELLOW + items.getPrice() + "$");
			lore.add(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			if (items == BuildShopEnum.PICKAXE) {
				slot = 21;
			}
			this.buildShopInventory.setItem(slot, this.main.getItemUtils().getItemStack(items.getItemStack(), itemName, (String[])lore.toArray()));
			slot++;
		}
	}

	public Inventory openSellItemInventory(Player player) {
		final Inventory sellItemInventory = this.main.getServer().createInventory(null, 9, ChatColor.RED.toString() + ChatColor.BOLD + "Sell Items");
		if (sellItemInventory.firstEmpty() == -1) {
			sellItemInventory.clear();
		}
		this.fillGlass(sellItemInventory);
		int slot = 1;
		for (ItemSellable items : ItemSellable.values()) {
			final List<String> lore = Arrays.asList(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			lore.add(ChatColor.GRAY.toString() + "Sell 1 " + WordUtils.capitalizeFully(items.getMaterial().toString().replaceAll("_", "")) + " for " + items.getPrice() + "$");
			if (player.getInventory().contains(items.getMaterial())) {
				// TODO: 
			}
			lore.add(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "-------------------");
			sellItemInventory.setItem(slot, this.main.getItemUtils().getItemStack(new ItemStack(items.getMaterial(), 1), WordUtils.capitalizeFully(items.name().replaceAll("_", "")), (String[])lore.toArray()));
			slot += 2;
		}
		return sellItemInventory;
	}	

	private void initEnchantingInventory() {
		if (this.enchantingInventory.firstEmpty() == -1) {
			this.enchantingInventory.clear();
		}
		this.fillGlass(this.enchantingInventory);
		
		int slot = 0;
		for (Enchantments enchants : Enchantments.values()) {
			final List<String> lore = Arrays.asList(ChatColor.GREEN.toString() + "Price: " + ChatColor.YELLOW + enchants.getPrice() + "$");
			this.enchantingInventory.setItem(slot, this.main.getItemUtils().getItemStack(new ItemStack(Material.ENCHANTED_BOOK, 1), WordUtils.capitalizeFully(enchants.name().replaceAll("_", "")), (String[])lore.toArray()));
			slot++;
		}
	}
	
	private void fillGlass(Inventory inv) {
		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, this.main.getItemUtils().getItemMaterial(Material.STAINED_GLASS_PANE, 15, " "));
		}
	}
}
