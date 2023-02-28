package io.noks.bunker.caches;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Team {
	private List<UUID> blue;
	private List<UUID> green;
	private List<UUID> red;
	private List<UUID> yellow;
	
	public Team() {
		this.blue = new ArrayList<>();
		this.green = new ArrayList<>();
		this.red = new ArrayList<>();
		this.yellow = new ArrayList<>();
	}
	
	public List<UUID> blue() {
		return this.blue;
	}
	
	public List<UUID> green() {
		return this.green;
	}
	
	public List<UUID> red() {
		return this.red;
	}
	
	public List<UUID> yellow() {
		return this.yellow;
	}
	
	public List<UUID> getPlayerTeam(UUID uuid) {
		if (this.blue.contains(uuid)) {
			return this.blue;
		}
		if (this.green.contains(uuid)) {
			return this.green;
		}
		if (this.red.contains(uuid)) {
			return this.red;
		}
		if (this.yellow.contains(uuid)) {
			return this.yellow;
		}
		return null;
	}
}
