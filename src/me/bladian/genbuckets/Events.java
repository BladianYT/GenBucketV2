package me.bladian.genbuckets;

import me.bladian.genbuckets.manager.GenerationManager;
import me.bladian.genbuckets.util.Reference;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

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

    private GenBucketV2 genBucketV2 = GenBucketV2.instance;
    private Economy economy = genBucketV2.getEconomy();
    private Reference reference = genBucketV2.getReference();
    private Inventories inventories = genBucketV2.getInventories();
    private GenerationManager generationManager = genBucketV2.getGenerationManager();

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
                        generationManager.verticalTask(Material.COBBLESTONE, reference.TICKS, water);
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
                        generationManager.verticalTaskGravity(Material.SAND, reference.TICKS, water);
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
                        generationManager.verticalTask(Material.OBSIDIAN, reference.TICKS, water);
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
                        generationManager.horizontalTask(Material.COBBLESTONE, reference.TICKS, water, reference.HORIZONTAL_BUCKET_COBBLESTONE_DISTANCE, f);
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
                        generationManager.horizontalTask(Material.OBSIDIAN, reference.TICKS, water, reference.HORIZONTAL_BUCKET_OBSIDIAN_DISTANCE, f);
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
}
