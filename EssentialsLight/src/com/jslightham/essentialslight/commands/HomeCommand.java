package com.jslightham.essentialslight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class HomeCommand implements CommandExecutor{
	private Main plugin;
	
	public HomeCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("home").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
		}else {
			Player p = (Player) sender;
			if(p.hasPermission("essentialslight.feed")) {
				if(Utils.getLocationFromString(plugin.getConfig().getString("Homes."+p.getUniqueId())) != null) {
					p.teleport(Utils.getLocationFromString(plugin.getConfig().getString("Homes."+p.getUniqueId())));
					p.sendMessage(Utils.chat(plugin.getConfig().getString("Homes.onTeleport")));
				}else {
					p.sendMessage(Utils.chat(plugin.getConfig().getString("Homes.noHome")));
				}
			}else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
			}
		}
		
		
		return true;
	}
}
