package com.jslightham.essentialslight;

import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.essentialslight.commands.BroadcastCommand;
import com.jslightham.essentialslight.commands.DayCommand;
import com.jslightham.essentialslight.commands.FeedCommand;
import com.jslightham.essentialslight.commands.FlyCommand;
import com.jslightham.essentialslight.commands.GameMode;
import com.jslightham.essentialslight.commands.HealCommand;
import com.jslightham.essentialslight.commands.HomeCommand;
import com.jslightham.essentialslight.commands.InvseeCommand;
import com.jslightham.essentialslight.commands.MsgCommand;
import com.jslightham.essentialslight.commands.NightCommand;
import com.jslightham.essentialslight.commands.SetSpawnCommand;
import com.jslightham.essentialslight.commands.SethomeCommand;
import com.jslightham.essentialslight.commands.SpawnCommand;
import com.jslightham.essentialslight.commands.TeleportCommand;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new FlyCommand(this);
		new TeleportCommand(this);
		new GameMode(this);
		new HealCommand(this);
		new FeedCommand(this);
		new SetSpawnCommand(this);
		new SpawnCommand(this);
		new DayCommand(this);
		new NightCommand(this);
		new BroadcastCommand(this);
		new MsgCommand(this);
		new InvseeCommand(this);
		new SethomeCommand(this);
		new HomeCommand(this);
	}

}
