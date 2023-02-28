package io.noks.bunker.caches;

import java.util.List;
import java.util.UUID;

import io.noks.bunker.enums.GameState;
import net.minecraft.util.com.google.common.collect.Lists;

public class Game {
	private List<UUID> players;
	private GameState state;
	private Team teams;
	
	public Game() {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
		this.teams = new Team();
	}
	
	public boolean isWinned() {
		// TODO: CHECK IF THE KOTH IS WINNED BEFORE CHECKING IF TEAMS ARE EMPTY
		int nonEmptyCount = 0;

	    if (!teams.blue().isEmpty()) {
	        nonEmptyCount++;
	    }
	    if (!teams.green().isEmpty()) {
	        nonEmptyCount++;
	    }
	    if (!teams.red().isEmpty()) {
	        nonEmptyCount++;
	    }
	    if (!teams.yellow().isEmpty()) {
	        nonEmptyCount++;
	    }
	    return nonEmptyCount == 1;
	}

	public boolean isPlayerInGame(UUID uuid) {
		return this.players.contains(uuid);
	}
}
