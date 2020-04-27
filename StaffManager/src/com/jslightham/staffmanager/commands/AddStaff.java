package com.jslightham.staffmanager.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;

public class AddStaff implements CommandExecutor{
	
	private Main plugin;
	
	public AddStaff(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("addstaff").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean hasPerms = false;
		if (!(sender instanceof Player)) {
			hasPerms = true;
		}else {
			Player p = (Player) sender;
			if (p.hasPermission("staffmanager.addstaff")) {
				hasPerms = true;
			}
			
		}
		
		Player g = null;
		if(hasPerms) {
			if(args.length < 1) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
				return true;
			}else {
				String staffString = plugin.getConfig().getString("staffMembers");
				if(staffString.equals("")) {
					staffString = "";
				}
				UUID player = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
				
				staffString += player;
				
				plugin.getConfig().set("staffMembers", staffString + ",");
				plugin.saveConfig();
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("staffAdded")));
				
			}
			
		}else {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
		}
		
		return true;
		
	}
	
}
