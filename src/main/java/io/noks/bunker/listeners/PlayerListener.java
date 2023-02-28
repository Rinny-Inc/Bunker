package io.noks.bunker.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import io.noks.bunker.Main;
import io.noks.bunker.managers.PlayerManager;

public class PlayerListener implements Listener {
	private Main plugin;

	public PlayerListener(Main main) {
		this.plugin = main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		final Player player = event.getPlayer();
		new PlayerManager(player.getUniqueId());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		final Player player = event.getPlayer();
		PlayerManager.get(player.getUniqueId()).remove();
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onGettingKicked(PlayerKickEvent event) {
		event.setLeaveMessage(null);
		this.onQuit(new PlayerQuitEvent(event.getPlayer(), event.getLeaveMessage()));
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDeath(PlayerDeathEvent event) {
		// TODO: remove from the game if DTR < 0
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRespawn(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		// TODO: DTR < 0 dont respawn in game
	}

	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerInteractSoup(PlayerInteractEvent event) {
		if (!event.hasItem()) {
			return;
		}
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			final Player player = event.getPlayer();
			if (!player.isDead() && player.getItemInHand().getType() == Material.MUSHROOM_SOUP && player.getHealth() < player.getMaxHealth()) {
				player.setHealth(Math.min(player.getHealth() + 7.0D, player.getMaxHealth()));
				player.getItemInHand().setType(Material.BOWL);
				player.updateInventory();
			}
		}
	}

}
