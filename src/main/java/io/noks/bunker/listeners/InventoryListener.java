package io.noks.bunker.listeners;

import org.bukkit.event.Listener;

import io.noks.bunker.Main;

public class InventoryListener implements Listener {
	private Main plugin;

	public InventoryListener(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}
}
