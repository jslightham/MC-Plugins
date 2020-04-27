package com.jslightham.staffmanager.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;

public class StaffList implements CommandExecutor{
	
	private Main plugin;
	
	public StaffList(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("staff").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		String staffString = plugin.getConfig().getString("staffMembers");
		if(staffString.equals("")) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("noStaff")));
		}else {
			
			String[] arr = staffString.split(",");
			
			String retString = "";
			
			for(int i =0; i<arr.length; i++) {
				retString += Bukkit.getOfflinePlayer(UUID.fromString(arr[i])).getName() + ", ";
			}
			
			retString = retString.substring(0, retString.length() -2);
			
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("prefixs")) + retString);
			
		}
		
		return true;
	}

}
