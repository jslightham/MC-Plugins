package com.jslightham.simpleTPA.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import org.bukkit.entity.Player;

public class TPAreq {
	private Player player1, player2;
	private LocalTime timeCreated;
	private LocalDate dateCreated;
	
	public TPAreq(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
}
