package com.jslightham.staffmanager.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;


public class DayCommand implements CommandExecutor {

	private Main plugin;

	public DayCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("day").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				player.getWorld().setTime(1000);
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("Day.onSet")));
			}
			
			return true;
		} else {
			Player p = (Player) sender;
			if (p.hasPermission("staffmanager.day")) {
				p.getWorld().setTime(1000);
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("Day.onSet")));
			}
		}
		return true;
	}
}
