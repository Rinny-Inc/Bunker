package io.noks.bunker;

import org.bukkit.plugin.java.JavaPlugin;

import io.noks.bunker.caches.Game;
import io.noks.bunker.listeners.InventoryListener;
import io.noks.bunker.listeners.PlayerListener;
import io.noks.bunker.managers.InventoryManager;
import io.noks.bunker.managers.PlayerManager;
import io.noks.bunker.utils.ItemUtils;

public class Main extends JavaPlugin {
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	private Game game;
	private ItemUtils itemUtils;
	private InventoryManager inventoryManager;
	
	@Override
	public void onEnable() {
		instance = this;
		this.game = new Game();
		this.itemUtils = new ItemUtils();
		this.inventoryManager = new InventoryManager(this);
		this.registerListeners();
		this.registerCommands();
	}
	
	@Override
	public void onDisable() {
		PlayerManager.players.clear();
	}
	
	private void registerListeners() {
		new PlayerListener(this);
		new InventoryListener(this);
	}
	
	private void registerCommands() {
		
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public ItemUtils getItemUtils() {
		return this.itemUtils;
	}
	
	public InventoryManager getInventoryManager() {
		return this.inventoryManager;
	}
}
