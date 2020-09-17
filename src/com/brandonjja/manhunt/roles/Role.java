package com.brandonjja.manhunt.roles;

public enum Role {
	HUNTER("Hunter"), RUNNER("Runner"), ASSASSIN("Assassin");
	
	private final String name;
	
	private Role(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
