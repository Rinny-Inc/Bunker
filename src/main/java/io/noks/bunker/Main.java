package io.noks.bunker;

import org.bukkit.plugin.java.JavaPlugin;

import io.noks.bunker.managers.PlayerManager;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.registerListeners();
		this.registerCommands();
	}
	
	@Override
	public void onDisable() {
		PlayerManager.players.clear();
	}
	
	private void registerListeners() {
		
	}
	
	private void registerCommands() {
		
	}
}
