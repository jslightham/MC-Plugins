package com.jslightham.staffmanager.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;

public class ChatListener implements Listener{
	
	private Main plugin;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
		 
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void chatCheck(AsyncPlayerChatEvent event) {
		
		if(Main.chatEnabled) {
		
		if(event.getMessage().length() > 2) {
			if(event.getPlayer().hasPermission("staffmanager.staffchat")) {
				if(event.getMessage().substring(0, 2).equals("@s")) {
					
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(p.hasPermission("staffmanager.staffchat")) {
							p.sendMessage(Utils.chat(plugin.getConfig().getString("prefix")) + event.getPlayer().getName() + ": " + event.getMessage());
						}
					}
					event.setCancelled(true);
				}
			}
		}	
		
		if(event.getMessage().length() > 5) {
			if(event.getMessage().substring(0, 5).equals("@help")) {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(p.hasPermission("staffmanager.help")) {
						p.sendMessage(Utils.chat(plugin.getConfig().getString("prefixh")) + event.getPlayer().getName() + ": " + event.getMessage());
					}
				}
				event.setCancelled(true);
			}
		}
		
		}else {
			event.getPlayer().sendMessage(Utils.chat(plugin.getConfig().getString("chatLocked")));
			event.setCancelled(true);
		}
		
		
		
	}
}
