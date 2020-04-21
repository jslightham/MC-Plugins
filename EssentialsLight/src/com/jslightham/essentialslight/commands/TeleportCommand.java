package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class TeleportCommand implements CommandExecutor {

	private Main plugin;

	public TeleportCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("tphere").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
		}

		Player p = (Player) sender;
		if (p.hasPermission("essentialslight.tphere")) {
			try {
				@SuppressWarnings("unused")
				String mentionedPlayer = args[0];
			} catch (Exception e) {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
				return true;
			}
			boolean isTeleported = false;
			try {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					if (args[0].contains(player.getName())) {
						isTeleported = true;
						player.teleport(p);
						player.sendMessage(Utils.chat(plugin.getConfig().getString("TeleportCommand.onTeleport")));
						return true;
					}
				}
			} catch (Exception e) {

			}
			if (!isTeleported)
				p.sendMessage(Utils.chat(plugin.getConfig().getString("playerOffline")));
			return true;
		}
		return true;
	}

}
