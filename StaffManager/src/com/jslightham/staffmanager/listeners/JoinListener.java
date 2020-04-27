package com.jslightham.staffmanager.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.jslightham.staffmanager.Main;

public class JoinListener implements Listener{
	
	private Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if(event.getPlayer().hasPermission("staffmanager.silentjoin")) {
			event.setJoinMessage("");
		}
		
	}
}
