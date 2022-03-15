package com.luciandev;

import com.luciandev.commands.dyeCommand;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ColorCommandPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandManager commandManager = new CommandManager(this);
        commandManager.register(new dyeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
