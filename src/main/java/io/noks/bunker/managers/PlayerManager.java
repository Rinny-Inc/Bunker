package io.noks.bunker.managers;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.collect.Maps;

public class PlayerManager {
	public static final Map<UUID, PlayerManager> players = Maps.newConcurrentMap();
	private final Player player;
	private final UUID playerUUID;

	public PlayerManager(UUID playerUUID) {
		this.playerUUID = playerUUID;
		this.player = Bukkit.getPlayer(this.playerUUID);
		players.putIfAbsent(playerUUID, this);
	}

	public static PlayerManager get(UUID playerUUID) {
		if (players.containsKey(playerUUID)) {
			return (PlayerManager) players.get(playerUUID);
		}
		return null;
	}

	public void remove() {
		players.remove(this.playerUUID);
	}

	public Player getPlayer() {
		return this.player;
	}

	public UUID getPlayerUUID() {
		return this.playerUUID;
	}
}
