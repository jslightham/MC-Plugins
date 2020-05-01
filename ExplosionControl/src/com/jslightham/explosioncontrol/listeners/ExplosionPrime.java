package com.jslightham.explosioncontrol.listeners;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftCreeper;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftLargeFireball;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftTNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

import com.jslightham.explosioncontrol.Main;

public class ExplosionPrime implements Listener{
	private Main plugin;
	
	public ExplosionPrime(Main plugin) {
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPrime(ExplosionPrimeEvent event) {
		if(event.getEntity() instanceof CraftTNTPrimed) {
			String temp = plugin.getConfig().getString("tntFire");
			boolean a = Boolean.parseBoolean(temp);
			event.setFire(a);
			
			temp = plugin.getConfig().getString("tntRadius");
			int b = Integer.parseInt(temp);
			event.setRadius(b);
			
			temp = plugin.getConfig().getString("tntCancelled");
			boolean c = Boolean.parseBoolean(temp);
			event.setCancelled(c);
		}else if(event.getEntity() instanceof CraftCreeper) {
			String temp = plugin.getConfig().getString("creeperFire");
			boolean a = Boolean.parseBoolean(temp);
			event.setFire(a);
			
			temp = plugin.getConfig().getString("creeperRadius");
			int b = Integer.parseInt(temp);
			event.setRadius(b);
			
			temp = plugin.getConfig().getString("creeperCancelled");
			boolean c = Boolean.parseBoolean(temp);
			event.setCancelled(c);
			
		}else if(event.getEntity() instanceof CraftLargeFireball){
			String temp = plugin.getConfig().getString("fireballFire");
			boolean a = Boolean.parseBoolean(temp);
			event.setFire(a);
			
			temp = plugin.getConfig().getString("fireballRadius");
			int b = Integer.parseInt(temp);
			event.setRadius(b);
			
			temp = plugin.getConfig().getString("fireballCancelled");
			boolean c = Boolean.parseBoolean(temp);
			event.setCancelled(c);
			
		}else {
			String temp = plugin.getConfig().getString("otherFire");
			boolean a = Boolean.parseBoolean(temp);
			event.setFire(a);
			
			temp = plugin.getConfig().getString("otherRadius");
			int b = Integer.parseInt(temp);
			event.setRadius(b);
			
			temp = plugin.getConfig().getString("otherCancelled");
			boolean c = Boolean.parseBoolean(temp);
			event.setCancelled(c);
		}
	}
	
}
