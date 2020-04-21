package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class MsgCommand implements CommandExecutor {
	private Main plugin;

	public MsgCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("msg").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean sentMsg = false;
		if (!(sender instanceof Player)) {
			if (args.length < 1) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
			} else {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					if (args[0].equals(player.getName())) {
						String msg = "";
						for (int i = 1; i < args.length; i++) {
							msg += args[i] + " ";
						}
						sender.sendMessage(Utils.chat("&6[Me -> " + player.getName() + "] &f" + msg));
						player.sendMessage(Utils.chat("&6[Console -> Me] &f" + msg));
						sentMsg = true;
					}
				}
			}
		}else {
			Player p = (Player) sender;
			if (p.hasPermission("essentialslight.msg")) {
				if (args.length < 1) {
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
				} else {
					for (Player player : Bukkit.getServer().getOnlinePlayers()) {
						if (args[0].equals(player.getName())) {
							String msg = "";
							for (int i = 1; i < args.length; i++) {
								msg += args[i] + " ";
							}
							sender.sendMessage(Utils.chat("&6[Me -> " + player.getName() + "] &f" + msg));
							player.sendMessage(Utils.chat("&6[" + sender.getName() + " -> Me] &f" + msg));
							sentMsg = true;
						}
					}
				}
			}
		}
		if(!sentMsg)
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));

		return true;
	}
}