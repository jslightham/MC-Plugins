package com.jslightham.essentialslight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class SethomeCommand implements CommandExecutor{

	private Main plugin;
	
	public SethomeCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("sethome").setExecutor(this);
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("essentialslight.sethome")) {
			plugin.getConfig().set("Homes."+p.getUniqueId(), Utils.getStringFromLocation(p.getLocation()));
			plugin.saveConfig();
			p.sendMessage(Utils.chat(plugin.getConfig().getString("Homes.homeSet")));
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
		}
		
		return true;
	}
}
