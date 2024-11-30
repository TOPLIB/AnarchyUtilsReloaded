package me.toplib.anarchyutilsreloaded;

import me.toplib.anarchyutilsreloaded.Utils.ChatUitls;
import me.toplib.anarchyutilsreloaded.Utils.UpdateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AnarchyUtilsReloaded extends JavaPlugin {
    private static AnarchyUtilsReloaded instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Starting the AnarchyUtilsReloaded plugin");

        if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getLogger().severe("Could not find PlaceholderAPI! This plugin is required."); //
            Bukkit.getPluginManager().disablePlugin(this);
        }
        try{
            if(UpdateManager.hasUpdate()){
                getLogger().warning(ChatUitls.colorize("&fNew update is out! Your version: &c" + UpdateManager.getCurrentVersion()
                        + "&f, latest version: &a" + UpdateManager.getLatestVersion() + "&f."));
            }
        } catch (Exception ignored){

        }



    }


    public static AnarchyUtilsReloaded getInstance() {
        return instance;
    }
}
