package me.bladian.genbuckets;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class Events implements Listener
{

    private Core core = Core.instance;
    private Economy economy = core.getEconomy();
    private Reference reference = core.getReference();
    private Inventories inventories = core.getInventories();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        if(e.getClickedInventory().getName().equalsIgnoreCase(inventories.inventory.getName()))
        {
            if(e.getCurrentItem() != null)
            {
                if(e.getCurrentItem().getType() != Material.AIR)
                {
                    ItemStack itemStack = e.getCurrentItem();
                    if(itemStack.getType() == Material.LAVA_BUCKET)
                    {
                        Player p = (Player) e.getWhoClicked();
                        if(e.getSlot() == 11)
                        {
                            if(economy.getBalance(p) >= reference.BUCKET_COBBLESTONE_BUY)
                            {
                                p.getInventory().addItem(itemStack.clone());
                                p.sendMessage("§aYou bought " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.BUCKET_COBBLESTONE_BUY);
                                economy.withdrawPlayer(p, reference.BUCKET_COBBLESTONE_BUY);
                            }
                            else
                            {
                                p.sendMessage("§cYou don't have enough money to buy this");
                            }
                            e.setCancelled(true);
                        }
                        if(e.getSlot() == 12)
                        {
                            if(economy.getBalance(p) >= reference.BUCKET_SAND_BUY)
                            {
                                p.getInventory().addItem(itemStack.clone());
                                p.sendMessage("§aYou bought " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.BUCKET_SAND_BUY);
                                economy.withdrawPlayer(p, reference.BUCKET_SAND_BUY);
                            }
                            else
                            {
                                p.sendMessage("§cYou don't have enough money to buy this");
                            }
                            e.setCancelled(true);
                        }
                        if(e.getSlot() == 13)
                        {
                            if(economy.getBalance(p) >= reference.BUCKET_OBSIDIAN_BUY)
                            {
                                p.getInventory().addItem(itemStack.clone());
                                p.sendMessage("§aYou bought " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.BUCKET_OBSIDIAN_BUY);
                                economy.withdrawPlayer(p, reference.BUCKET_OBSIDIAN_BUY);
                            }
                            else
                            {
                                p.sendMessage("§cYou don't have enough money to buy this");
                            }
                            e.setCancelled(true);
                        }
                        if(e.getSlot() == 14)
                        {
                            if(economy.getBalance(p) >= reference.HORIZONTAL_BUCKET_COBBLESTONE_BUY)
                            {
                                p.getInventory().addItem(itemStack.clone());
                                p.sendMessage("§aYou bought " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.HORIZONTAL_BUCKET_COBBLESTONE_BUY);
                                economy.withdrawPlayer(p, reference.HORIZONTAL_BUCKET_COBBLESTONE_BUY);
                            }
                            else
                            {
                                p.sendMessage("§cYou don't have enough money to buy this");
                            }
                            e.setCancelled(true);
                        }
                        if(e.getSlot() == 15)
                        {
                            if(economy.getBalance(p) >= reference.HORIZONTAL_BUCKET_OBSIDIAN_BUY)
                            {
                                p.getInventory().addItem(itemStack.clone());
                                p.sendMessage("§aYou bought " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.HORIZONTAL_BUCKET_OBSIDIAN_BUY);
                                economy.withdrawPlayer(p, reference.HORIZONTAL_BUCKET_OBSIDIAN_BUY);
                            }
                            else
                            {
                                p.sendMessage("§cYou don't have enough money to buy this");
                            }
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBucketEmpty(PlayerBucketEmptyEvent e)
    {
        Player p = e.getPlayer();
        if(e.getBucket() == Material.LAVA_BUCKET)
        {
            ItemStack itemStack = p.getItemInHand();
            if(itemStack.getItemMeta().getDisplayName() != null)
            {

                if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(inventories.vertCobble.getItemMeta().getDisplayName()))
                {
                    if(economy.getBalance(p) >= reference.BUCKET_COBBLESTONE_USE)
                    {
                        e.setCancelled(true);
                        Location clicked = e.getBlockClicked().getLocation();
                        BlockFace f = e.getBlockFace();
                        Location water = new Location(clicked.getWorld(), clicked.getX() + f.getModX(), clicked.getY() + f.getModY(), clicked.getZ() + f.getModZ());
                        vertTask(Material.COBBLESTONE, reference.TICKS, water);
                        p.sendMessage("§aYou used " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.BUCKET_COBBLESTONE_USE);
                        economy.withdrawPlayer(p, reference.BUCKET_COBBLESTONE_USE);
                    }
                    else
                    {
                        p.sendMessage("§cYou don't have enough money to use this");
                    }
                }
                if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(inventories.vertSand.getItemMeta().getDisplayName()))
                {
                    if(economy.getBalance(p) >= reference.BUCKET_SAND_USE)
                    {
                        e.setCancelled(true);
                        Location clicked = e.getBlockClicked().getLocation();
                        BlockFace f = e.getBlockFace();
                        Location water = new Location(clicked.getWorld(), clicked.getX() + f.getModX(), clicked.getY() + f.getModY(), clicked.getZ() + f.getModZ());
                        vertTaskFalling(Material.SAND, reference.TICKS, water);
                        p.sendMessage("§aYou used " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.BUCKET_SAND_USE);
                        economy.withdrawPlayer(p, reference.BUCKET_SAND_USE);
                    }
                    else
                    {
                        p.sendMessage("§cYou don't have enough money to use this");
                    }
                }
                if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(inventories.vertObsidian.getItemMeta().getDisplayName()))
                {
                    if(economy.getBalance(p) >= reference.BUCKET_OBSIDIAN_USE)
                    {
                        e.setCancelled(true);
                        Location clicked = e.getBlockClicked().getLocation();
                        BlockFace f = e.getBlockFace();
                        Location water = new Location(clicked.getWorld(), clicked.getX() + f.getModX(), clicked.getY() + f.getModY(), clicked.getZ() + f.getModZ());
                        vertTask(Material.OBSIDIAN, reference.TICKS, water);
                        p.sendMessage("§aYou used " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.BUCKET_OBSIDIAN_USE);
                        economy.withdrawPlayer(p, reference.BUCKET_OBSIDIAN_USE);
                    }
                    else
                    {
                        p.sendMessage("§cYou don't have enough money to use this");
                    }
                }
                if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(inventories.horiCobble.getItemMeta().getDisplayName()))
                {
                    if(economy.getBalance(p) >= reference.HORIZONTAL_BUCKET_COBBLESTONE_USE)
                    {
                        e.setCancelled(true);
                        Location clicked = e.getBlockClicked().getLocation();
                        BlockFace f = e.getBlockFace();
                        Location water = new Location(clicked.getWorld(), clicked.getX() + f.getModX(), clicked.getY() + f.getModY(), clicked.getZ() + f.getModZ());
                        horiTask(Material.COBBLESTONE, reference.TICKS, water, reference.HORIZONTAL_BUCKET_COBBLESTONE_DISTANCE, f);
                        p.sendMessage("§aYou used " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.HORIZONTAL_BUCKET_COBBLESTONE_USE);
                        economy.withdrawPlayer(p, reference.HORIZONTAL_BUCKET_COBBLESTONE_USE);
                    }
                    else
                    {
                        p.sendMessage("§cYou don't have enough money to use this");
                    }
                }
                if(itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(inventories.horiObsidian.getItemMeta().getDisplayName()))
                {
                    if(economy.getBalance(p) >= reference.HORIZONTAL_BUCKET_OBSIDIAN_USE)
                    {
                        e.setCancelled(true);
                        Location clicked = e.getBlockClicked().getLocation();
                        BlockFace f = e.getBlockFace();
                        Location water = new Location(clicked.getWorld(), clicked.getX() + f.getModX(), clicked.getY() + f.getModY(), clicked.getZ() + f.getModZ());
                        horiTask(Material.OBSIDIAN, reference.TICKS, water, reference.HORIZONTAL_BUCKET_OBSIDIAN_DISTANCE, f);
                        p.sendMessage("§aYou used " + itemStack.getItemMeta().getDisplayName() + "§a for§e $" + reference.HORIZONTAL_BUCKET_OBSIDIAN_USE);
                        economy.withdrawPlayer(p, reference.HORIZONTAL_BUCKET_OBSIDIAN_USE);
                    }
                    else
                    {
                        p.sendMessage("§cYou don't have enough money to use this");
                    }
                }
            }
        }
    }


    private void vertTask(final Material material, int ticks, Location location)
    {
        final Location changingLoc = location.clone();
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if(changingLoc.getBlock().getType() == Material.AIR)
                {
                    changingLoc.getBlock().setType(material);
                    changingLoc.add(new Vector(0, -1, 0));
                }
                else
                {
                    this.cancel();
                }
            }
        }.runTaskTimer(core, 0L, ticks);
    }

    private void vertTaskFalling(final Material material, int ticks, final Location location)
    {
        final Location changingLoc = location.clone();
        final int highestY = location.getBlockY();
        int lowestY = 0;
        for(int i = highestY; i>=0; i--)
        {
            Location newLoc = new Location(changingLoc.getWorld(), changingLoc.getX(), i, changingLoc.getZ());
            if(newLoc.getBlock().getType() != Material.AIR)
            {
                lowestY = newLoc.add(new Vector(0, 1, 0)).getBlockY();
                break;
            }
        }
        changingLoc.setY(lowestY);
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if(changingLoc.getBlock().getType() == Material.AIR && changingLoc.getY() <= highestY)
                {
                    changingLoc.getBlock().setType(material);
                    changingLoc.add(new Vector(0, 1, 0));
                }
                else
                {
                    this.cancel();
                }
            }
        }.runTaskTimer(core, 0L, ticks);
    }

    private void horiTask(final Material material, int ticks, Location location, final int distance, final BlockFace blockFace)
    {
        final Location changingLoc = location.clone();
        new BukkitRunnable()
        {
            int times = 0;
            @Override
            public void run()
            {
                if(changingLoc.getBlock().getType() == Material.AIR && times != distance)
                {
                    changingLoc.getBlock().setType(material);
                    if(blockFace == BlockFace.NORTH)
                    {
                        changingLoc.add(new Vector(0, 0, -1));
                    }
                    else if(blockFace == BlockFace.EAST)
                    {
                        changingLoc.add(new Vector(1, 0, 0));
                    }
                    else if(blockFace == BlockFace.SOUTH)
                    {
                        changingLoc.add(new Vector(0, 0, 1));
                    }
                    else if(blockFace == BlockFace.WEST)
                    {
                        changingLoc.add(new Vector(-1, 0, 0));
                    }
                    times++;
                }
                else
                {
                    this.cancel();
                }
            }
        }.runTaskTimer(core, 0L, ticks);
    }

    private String getBlockDirection(Player player)
    {
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0)
        {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5)
        {
            return "N";
        }
        else if (22.5 <= rotation && rotation < 67.5)
        {
            return "NE";
        }
        else if (67.5 <= rotation && rotation < 112.5)
        {
            return "E";
        }
        else if (112.5 <= rotation && rotation < 157.5)
        {
            return "SE";
        }
        else if (157.5 <= rotation && rotation < 202.5)
        {
            return "S";
        }
        else if (202.5 <= rotation && rotation < 247.5)
        {
            return "SW";
        }
        else if (247.5 <= rotation && rotation < 292.5)
        {
            return "W";
        }
        else if (292.5 <= rotation && rotation < 337.5)
        {
            return "NW";
        }
        else if (337.5 <= rotation && rotation < 360.0)
        {
            return "N";
        }
        else
        {
            return null;
        }
    }
}
