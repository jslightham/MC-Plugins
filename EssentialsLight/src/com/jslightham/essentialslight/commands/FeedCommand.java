package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class FeedCommand implements CommandExecutor {

	private Main plugin;

	public FeedCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("feed").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String c = "";
		for (int i = 0; i < args.length; i++) {
			c += args[i] + " ";
		}
		if (!(sender instanceof Player)) {
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				if (c.contains(player.getName())) {
					player.setFoodLevel(20);
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("Feed.setFood")));
				}
			}

			return true;
		} else {
			Player p = (Player) sender;
			if (p.hasPermission("essentialslight.feed")) {
				boolean gmChanged = false;
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					if (c.contains(player.getName())) {
						player.setFoodLevel(20);
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("Feed.setFood")));
						gmChanged = true;
						return true;
					}
				}
				if (!gmChanged) {
					p.setFoodLevel(20);
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("Feed.setFood")));
				}
			}
		}

		return true;
	}

}
