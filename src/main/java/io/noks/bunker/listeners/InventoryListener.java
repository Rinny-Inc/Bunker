package io.noks.bunker.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import io.noks.bunker.Main;
import net.md_5.bungee.api.ChatColor;

public class InventoryListener implements Listener {
	private Main plugin;

	public InventoryListener(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onInventoryClick(InventoryClickEvent event) {
		final Inventory inventory = event.getInventory();
		if (inventory == null) {
			return;
		}
		if (inventory.getType() != InventoryType.CHEST) {
			return;
		}
		final ItemStack item = event.getCurrentItem();
		
		if (item == null || item.getType() == null || item.getItemMeta() == null || item.getItemMeta().getDisplayName() == null) {
			return;
		}
		final String title = ChatColor.stripColor(inventory.getTitle().toLowerCase());
		
		if (title.equals("combat shop")) {
			if (event.getClick() == ClickType.RIGHT) {
				// TODO: RIGHT CLICK
				return;
			}
			// TODO: OTHER CLICK
			return;
		}
		if (title.equals("build shop")) {
			
			return;
		}
		if (title.equals("sell items")) {
			if (event.getClick() == ClickType.RIGHT) {
				// TODO: RIGHT CLICK
				return;
			}
			// TODO: OTHER CLICK
			return;
		}
		if (title.equals("tim the enchanter")) {
			
		}
	}
}
