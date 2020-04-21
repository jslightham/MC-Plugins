package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class InvseeCommand implements CommandExecutor {
	private Main plugin;

	public InvseeCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("invsee").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
		} else {
			Player p = (Player) sender;
			if (p.hasPermission("essentialslight.invsee")) {
				if(args.length == 1) {
					Player t = Bukkit.getPlayer(args[0]);
					if(t == null) {
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
					}else {
						p.openInventory(t.getInventory());
					}
				}else {
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
				}
			} else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
			}
		}

		return true;
	}
}
