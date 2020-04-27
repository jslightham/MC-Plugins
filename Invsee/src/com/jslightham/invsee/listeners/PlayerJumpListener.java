package com.jslightham.invsee.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.jslightham.invsee.Main;
import com.jslightham.invsee.utils.Utils;

public class PlayerJumpListener implements Listener{
	
	private Main plugin;
	
	public PlayerJumpListener(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerJump(PlayerMoveEvent event) {
		for(Player p : Main.frozen) {
			if(event.getPlayer().equals(p)) {
				event.getPlayer().sendMessage(Utils.chat(plugin.getConfig().getString("youFrozen")));
				event.setCancelled(true);
			}
		}
		
	}
}
