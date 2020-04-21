package com.jslightham.invsee.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.invsee.Main;
import com.jslightham.invsee.utils.Utils;

public class EnderchestCommand implements CommandExecutor{
	
	private Main plugin;
	
	public EnderchestCommand(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("enderchest").setExecutor(this);
		plugin.getCommand("ec").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
		}else {
			Player p = (Player) sender;
			if(p.hasPermission("invsee.enderchest")) {
				if (args.length < 1) {
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("enderchestOpened")));
					p.openInventory(p.getEnderChest());
					return true;
				}else {
					Player t = Bukkit.getPlayer(args[0]);
					if(t == null) {
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("playerOffline")));
						return true;
					}else {
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("enderchestOpened")));
						p.openInventory(t.getEnderChest());
						return true;
					}
				}
			}else {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
			}
		}
		return true;
	}
	
}
