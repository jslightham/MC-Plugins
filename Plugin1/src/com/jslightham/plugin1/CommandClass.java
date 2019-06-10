package com.jslightham.plugin1;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] arg3) {
		if(command.getName().equals("heal")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(arg3.length > 0) {
					try {
						player.setHealth(Integer.parseInt(arg3[0]));
						System.out.println("Your health is now: " + arg3[0]);
					}catch (Exception e) {
						player.sendMessage("That is not a valid health!");
					}
				}
			}else {
				System.out.println("Command may only be executed by players. ");
			}
		}
		return true;
	}

}
