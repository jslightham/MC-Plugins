package com.jslightham.invsee.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.jslightham.invsee.Main;
import com.jslightham.invsee.utils.Utils;

public class FreezeCommand implements CommandExecutor{
	
	private Main plugin;
	
	public FreezeCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("freeze").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		boolean hasPerms = false;
		if(!(sender instanceof Player)) {
			hasPerms = true;
		}else {
			if(sender.hasPermission("invsee.freeze")) {
				hasPerms = true;
			}
		}
		
		if(hasPerms) {
			if (args.length < 1) {
				sender.sendMessage(Utils.chat(plugin.getConfig().getString("missingArguments")));
				return true;
			}else {
				Player t = Bukkit.getPlayer(args[0]);
				if(t == null) {
					sender.sendMessage(Utils.chat(plugin.getConfig().getString("playerOffline")));
					return true;
				}else {
					if(t.getWalkSpeed() > 0) {
						t.setWalkSpeed(0);
						t.setFlySpeed(0);
						Main.frozen.add(t);
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("playerFrozen")));
					}else {
						t.setWalkSpeed((float) 0.2);
						t.setFlySpeed((float)0.2);
						Main.frozen.remove(t);
						sender.sendMessage(Utils.chat(plugin.getConfig().getString("playerUnfrozen")));
					}
					return true;
				}
			}
		}else {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("permissionMessage")));
		}
		
		
		return true;
	}
}
