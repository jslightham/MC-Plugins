package com.jslightham.staffmanager.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.staffmanager.Main;
import com.jslightham.staffmanager.utils.Utils;

public class FlyCommand implements CommandExecutor {

	private Main plugin;

	public FlyCommand(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("fly").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("errorMessage")));
			return true;
		}
		Player p = (Player) sender;
		if (p.hasPermission("staffmanager.fly")) {
			if (p.getAllowFlight()) {
				p.setFlying(false);
				p.setAllowFlight(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.onDisable")));
				return true;
			} else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.onEnable")));
				return true;
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
		}

		return false;
	}

}