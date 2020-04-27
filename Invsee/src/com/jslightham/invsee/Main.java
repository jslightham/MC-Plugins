package com.jslightham.invsee;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.invsee.commands.EnderchestCommand;
import com.jslightham.invsee.commands.FreezeCommand;
import com.jslightham.invsee.commands.InvseeCommand;
import com.jslightham.invsee.listeners.PlayerJumpListener;

public class Main extends JavaPlugin{
	
	public static ArrayList<Player> frozen = new ArrayList<Player>();
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new InvseeCommand(this);
		new EnderchestCommand(this);
		new FreezeCommand(this);
		new PlayerJumpListener(this);
	}
}
