package com.jslightham.staffmanager.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;

public class RemStaff implements CommandExecutor{
	private Main plugin;
	
	public RemStaff(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("removestaff").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean hasPerms = false;
		if(!(sender instanceof Player)) {
			hasPerms = true;
		}else {
			if(sender.hasPermission("staffmanager.remstaff")) {
				hasPerms = true;
			}
		}
		
		if(hasPerms) {
			if(args.length  < 1) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArgs")));
				return true;
			}
			
			String staffString = plugin.getConfig().getString("staffMembers");
			
			if(staffString.equals("")) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("noStaff")));
				return true;
			}else {
				String[] arr = staffString.split(",");
				String ret = "";
				
				for(int i =0; i<arr.length; i++) {
					if(Bukkit.getOfflinePlayer(UUID.fromString(arr[i])).getName().equals(args[0])) {
						arr[i] = null;
					}
				}
				
				for(String s : arr) {
				      if(s != null && s.length() > 0) {
				         ret+= s + ",";
				      }
				}
				
				plugin.getConfig().set("staffMembers", ret);
				plugin.saveConfig();
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("staffRemoved")));
			}
		}else {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
		}
		
		return true;
		
	}
}
