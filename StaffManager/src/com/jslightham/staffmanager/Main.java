package com.jslightham.staffmanager;

import org.bukkit.plugin.java.JavaPlugin;

import com.jslightham.staffmanager.commands.AddStaff;
import com.jslightham.staffmanager.commands.DayCommand;
import com.jslightham.staffmanager.commands.FlyCommand;
import com.jslightham.staffmanager.commands.HealCommand;
import com.jslightham.staffmanager.commands.InvseeCommand;
import com.jslightham.staffmanager.commands.MsgCommand;
import com.jslightham.staffmanager.commands.NightCommand;
import com.jslightham.staffmanager.commands.RemStaff;
import com.jslightham.staffmanager.commands.StaffList;
import com.jslightham.staffmanager.commands.ToggleChat;
import com.jslightham.staffmanager.listeners.ChatListener;
import com.jslightham.staffmanager.listeners.JoinListener;
import com.jslightham.staffmanager.listeners.LeaveListener;

public class Main extends JavaPlugin{
	
	public static boolean chatEnabled = true;
	
	public void onEnable() {
		saveDefaultConfig();
		new AddStaff(this);
		new StaffList(this);
		new RemStaff(this);
		new ToggleChat(this);
		new DayCommand(this);
		new FlyCommand(this);
		new HealCommand(this);
		new InvseeCommand(this);
		new MsgCommand(this);
		new NightCommand(this);
		
		new ChatListener(this);
		new JoinListener(this);
		new LeaveListener(this);
	}
}
