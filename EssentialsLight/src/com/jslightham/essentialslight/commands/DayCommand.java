package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

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
			if (p.hasPermission("essentialslight.day")) {
				p.getWorld().setTime(1000);
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("Day.onSet")));
			}
		}
		return true;
	}
}
