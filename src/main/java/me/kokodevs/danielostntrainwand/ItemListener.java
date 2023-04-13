package me.kokodevs.danielostntrainwand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemListener implements Listener {

    private final DanielosTNTRainWand plugin;

    public ItemListener(DanielosTNTRainWand plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void handleItem(PlayerInteractEvent e) {
        if (!e.getAction().isRightClick() || !e.hasItem()) return;
        if (e.getItem().isSimilar(plugin.tntBaseStick)) {
            e.getPlayer().getInventory().setItemInMainHand(null);
            Location location;
            if (getPlayerTeam(e.getPlayer()).equals(plugin.getConfig().getString("base2.name"))) {
                location = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("base1.x"), plugin.getConfig().getInt("base1.y"), plugin.getConfig().getInt("base1.z"));
            } else {
                location = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("base2.x"), plugin.getConfig().getInt("base2.y"), plugin.getConfig().getInt("base2.z"));
            }

            int radius = plugin.getConfig().getInt("radius");

            location.setY(location.getY() + 10);

            for (int x = -radius; x < radius; x++) {
                for (int z = -radius; z < radius; z++) {
                    if (x % 2 == 0 && z % 2 == 0) {
                        location.getWorld().spawn(new Location(location.getWorld(), location.getX() + x, location.getY(), location.getZ() + z), TNTPrimed.class);
                    }
                }
            }
        }
    }

    private String getPlayerTeam(Player p) {
        return Bukkit.getScoreboardManager().getMainScoreboard().getTeams().stream().filter(team -> team.hasPlayer(p)).findFirst().get().getName();
    }

}
