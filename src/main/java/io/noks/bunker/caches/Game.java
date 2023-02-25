package io.noks.bunker.caches;

import java.util.List;
import java.util.UUID;

import io.noks.bunker.enums.GameState;
import net.minecraft.util.com.google.common.collect.Lists;

public class Game {
	private List<UUID> players;
	private GameState state;
	
	public Game() {
		this.players = Lists.newArrayList();
		this.state = GameState.WAITING;
	}

	
}
