package com.jslightham.easybans;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.easybans.utils.Utils;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (args.length < 1) {
			sender.sendMessage(Utils.chat(this.getConfig().getString("missingArguments")));
			return true;
		}

		String name, UUID;
		if (args[0].matches("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")) {
			UUID = args[0];
			name = Bukkit.getPlayer(UUID).getName();
		} else {
			name = args[0];
			UUID = Bukkit.getPlayer(name).getUniqueId().toString();
		}

		sender.sendMessage("Name: " + name + " UUID: " + UUID);
		
		if (cmd.getName().equalsIgnoreCase("ban")) {
			// TODO: Push the UUID, ban reason, and time to the Web API
			String msg = "";
			for (int i = 1; i < args.length; i++) {
				msg += args[i] + " ";
			}
			String successMsg = "";
			if (getConfig().getString("banSuccess").indexOf("%player%") < getConfig().getString("banSuccess")
					.indexOf("%reason%")) {
				successMsg += getConfig().getString("banSuccess").substring(0,
						getConfig().getString("banSuccess").indexOf("%player%"));
				successMsg += name;
				successMsg += getConfig().getString("banSuccess").substring(
						getConfig().getString("banSuccess").indexOf("%player%") + 8,
						getConfig().getString("banSuccess").indexOf("%reason%"));
				successMsg += msg;
				successMsg += getConfig().getString("banSuccess")
						.substring(getConfig().getString("banSuccess").indexOf("%reason%") + 8);
			} else {
				successMsg += getConfig().getString("banSuccess").substring(0,
						getConfig().getString("banSuccess").indexOf("%reason%"));
				successMsg += name;
				successMsg += getConfig().getString("banSuccess").substring(
						getConfig().getString("banSuccess").indexOf("%reason%") + 8,
						getConfig().getString("banSuccess").indexOf("%player%"));
				successMsg += msg;
				successMsg += getConfig().getString("banSuccess")
						.substring(getConfig().getString("banSuccess").indexOf("%player%") + 8);
			}

			sender.sendMessage(Utils.chat(successMsg));

			Player t = Bukkit.getServer().getPlayer(name);
			if(t != null) {
				t.kickPlayer(msg);
			}

		} else if (cmd.getName().equalsIgnoreCase("unban")) {
			// TODO: Push the UUID, ban reason, and time to the Web API

			String successMsg = "";

			successMsg += getConfig().getString("unbanSuccess").substring(0,
					getConfig().getString("banSuccess").indexOf("%player%"));
			successMsg += name;
			successMsg += getConfig().getString("unbanSuccess")
					.substring(getConfig().getString("unbanSuccess").indexOf("%player%") + 8);
			sender.sendMessage(successMsg);
			

		} else if (cmd.getName().equalsIgnoreCase("ebinfo")) {
			// TODO: Send request to web api to read data
		}
		return true;
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e) {
		//ToDo: Send a request to the web api to see if the player is banned and why 
	}

}
