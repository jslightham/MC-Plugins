package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class GameMode implements CommandExecutor {
	private Main plugin;

	public GameMode(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("gm").setExecutor(this);
		
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			/*
			boolean gmChanged = false;
			boolean playerOffline = true;
			try {
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					if (args[0].contains(player.getName())) {
						playerOffline = false;
						if (args[1].toLowerCase().contains("c") || args[1].toLowerCase().contains("creative")
								|| args[1].toLowerCase().contains("s") || args[1].toLowerCase().contains("survival")
								|| args[1].toLowerCase().contains("a") || args[1].toLowerCase().contains("adventure")
								|| args[1].toLowerCase().contains("spectator")) {
							gmChanged = true;
							switch (args[1].toLowerCase()) {
							case "c":
							case "creative":
								player.setGameMode(org.bukkit.GameMode.CREATIVE);
								break;
							case "s":
							case "survival":
								player.setGameMode(org.bukkit.GameMode.SURVIVAL);
								break;
							case "a":
							case "adventure":
								player.setGameMode(org.bukkit.GameMode.ADVENTURE);
								break;
							case "spectator":
								player.setGameMode(org.bukkit.GameMode.SPECTATOR);
								break;
							}
							player.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
							return true;
						}
					}
				}
			} catch (Exception e) {
				
			}
			
			if (playerOffline)
				System.out.println(Utils.chat(plugin.getConfig().getString("playerOffline")));
			if (!gmChanged) {
				System.out.println(Utils.chat(plugin.getConfig().getString("invalidGameMode")));
			}
			return true;
			*/
			
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
			
		} else {				
			Player p = (Player) sender;
			if(args.length < 1) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
				return true;
			}
			Player g = p;
			boolean gameModeChanged = false;
			if (p.hasPermission("essentialslight.gm")) {
				try {
					for (Player player : Bukkit.getServer().getOnlinePlayers()) {
						if (args[0].equals(player.getName())) {
							g = player;
						}
					}
				} catch (Exception e) {

				}
				try {
				if (args[1].toLowerCase().contains("c") || args[1].toLowerCase().contains("creative")
						|| args[1].toLowerCase().contains("s") || args[1].toLowerCase().contains("survival")
						|| args[1].toLowerCase().contains("a")
						|| args[1].toLowerCase().contains("adventure")
						|| args[1].toLowerCase().contains("spectator")) {
					switch (args[1].toLowerCase()) {
					case "c":
					case "creative":
						g.setGameMode(org.bukkit.GameMode.CREATIVE);
						g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
						gameModeChanged = true;
						break;
					case "s":
					case "survival":
						g.setGameMode(org.bukkit.GameMode.SURVIVAL);
						g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
						gameModeChanged = true;
						break;
					case "a":
					case "adventure":
						g.setGameMode(org.bukkit.GameMode.ADVENTURE);
						g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
						gameModeChanged = true;
						break;
					case "spectator":
						g.setGameMode(org.bukkit.GameMode.SPECTATOR);
						g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
						gameModeChanged = true;
						break;
					default:
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
						gameModeChanged = true;
						break;
					}
				}
				}catch(Exception e) {
					if (args[0].toLowerCase().contains("c") || args[0].toLowerCase().contains("creative")
							|| args[0].toLowerCase().contains("s") || args[0].toLowerCase().contains("survival")
							|| args[0].toLowerCase().contains("a")
							|| args[0].toLowerCase().contains("adventure")
							|| args[0].toLowerCase().contains("spectator")) {
						switch (args[0].toLowerCase()) {
						case "c":
						case "creative":
							g.setGameMode(org.bukkit.GameMode.CREATIVE);
							g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
							gameModeChanged = true;
							break;
						case "s":
						case "survival":
							g.setGameMode(org.bukkit.GameMode.SURVIVAL);
							g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
							gameModeChanged = true;
							break;
						case "a":
						case "adventure":
							g.setGameMode(org.bukkit.GameMode.ADVENTURE);
							g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
							gameModeChanged = true;
							break;
						case "spectator":
							g.setGameMode(org.bukkit.GameMode.SPECTATOR);
							g.sendMessage(Utils.chat(plugin.getConfig().getString("GameMode.changedMode")));
							gameModeChanged = true;
							break;
						}
				}
			}
				if(!gameModeChanged)
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
			}

			else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
			}
		}
		return true;

	}

}
