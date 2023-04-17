package me.kokodevs.danielostntrainwand;

import me.kokodevs.danielostntrainwand.commands.TNTCommand;
import me.kokodevs.danielostntrainwand.listeners.ItemListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
public final class DanielosTNTRainWand extends JavaPlugin {

    public ItemStack tntBaseStick;

    @Override
    public void onEnable() {
        //item creation
        tntBaseStick = new ItemStack(Material.STICK, 1);
        ItemMeta meta = tntBaseStick.getItemMeta();
        meta.setDisplayName("TNT WAND");
        tntBaseStick.setItemMeta(meta);



        getCommand("tntcommand").setExecutor(new TNTCommand(this));
        getServer().getPluginManager().registerEvents(new ItemListener(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
    }
}
