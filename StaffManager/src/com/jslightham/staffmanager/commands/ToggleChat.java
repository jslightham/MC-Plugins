package com.jslightham.staffmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;

public class ToggleChat implements CommandExecutor{

	private Main plugin;
	
	public ToggleChat(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("togglechat").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			Main.chatEnabled = !Main.chatEnabled;
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("toggleChat")));
			return true;
		}else {
			if(sender.hasPermission("staffmanager.togglechat")) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("toggleChat")));
				Main.chatEnabled = !Main.chatEnabled;
			}else {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
			}
		}
		return true;
	}
}
