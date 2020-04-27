package com.jslightham.staffmanager.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.jslightham.staffmanager.Main;

public class LeaveListener implements Listener{
	
	private Main plugin;
	
	public LeaveListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(event.getPlayer().hasPermission("staffmanager.silentquit")) {
			event.setQuitMessage("");
		}
		
	}
}
