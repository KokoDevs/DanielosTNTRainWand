package me.kokodevs.danielostntrainwand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.type.TNT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.jetbrains.annotations.NotNull;

public class TNTCommand implements CommandExecutor {

    private final DanielosTNTRainWand plugin;

    public TNTCommand(DanielosTNTRainWand plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p) {

            if (!p.hasPermission("danielplugin.tntstick")) return true;

            p.getInventory().addItem(plugin.tntBaseStick);

        }

        return true;
    }
}
