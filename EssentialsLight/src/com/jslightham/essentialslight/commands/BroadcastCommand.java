package com.jslightham.essentialslight.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jslightham.essentialslight.Main;
import com.jslightham.essentialslight.utils.Utils;

public class BroadcastCommand implements CommandExecutor {

	private Main plugin;

	public BroadcastCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("broadcast").setExecutor(this);
		plugin.getCommand("bc").setExecutor(this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			String msg = "";
			for(int i = 0; i<args.length; i++) {
				msg+= args[i] + " ";
			}
			for (Player player : Bukkit.getServer().getOnlinePlayers()) {
				player.sendMessage(Utils.chat(plugin.getConfig().getString("Broadcast.broadcastPrefix") + msg));
			}
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("Broadcast.broadcastPrefix") + msg));
			return true;
		}else {
			Player p = (Player) sender;
			if (p.hasPermission("essentialslight.broadcast")) {
				String msg = "";
				for(int i = 0; i<args.length; i++) {
					msg+= args[i] + " ";
				}
				for (Player player : Bukkit.getServer().getOnlinePlayers()) {
					player.sendMessage(Utils.chat(plugin.getConfig().getString("Broadcast.broadcastPrefix") + msg));
				}
			}else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
			}
		}

	return true;
}

}
