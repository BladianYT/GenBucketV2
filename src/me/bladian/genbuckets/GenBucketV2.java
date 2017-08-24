package me.bladian.genbuckets;

import me.bladian.genbuckets.command.ComGenBucket;
import me.bladian.genbuckets.manager.GenerationManager;
import me.bladian.genbuckets.util.Reference;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class GenBucketV2 extends JavaPlugin
{

    public static GenBucketV2 instance;

    private Reference reference;
    private Inventories inventories;
    private GenerationManager generationManager;

    private Economy economy;


    @Override
    public void onEnable()
    {
        instance = this;

        saveDefaultConfig();

        setupEconomy();

        reference = new Reference();


        Bukkit.broadcastMessage("TESTING");
        Bukkit.broadcastMessage(String.valueOf(getConfig().getInt("vertical.cobblestone.buy")));
        Bukkit.broadcastMessage(String.valueOf(getConfig().getInt("vertical.cobblestone.use")));

        reference.setBUCKET_COBBLESTONE_BUY(getConfig().getInt("vertical.cobblestone.buy"));
        reference.setBUCKET_COBBLESTONE_USE(getConfig().getInt("vertical.cobblestone.use"));
        reference.setBUCKET_SAND_BUY(getConfig().getInt("vertical.sand.buy"));
        reference.setBUCKET_SAND_USE(getConfig().getInt("vertical.sand.use"));
        reference.setBUCKET_OBSIDIAN_BUY(getConfig().getInt("vertical.obsidian.buy"));
        reference.setBUCKET_OBSIDIAN_USE(getConfig().getInt("vertical.obsidian.use"));


        reference.setHORIZONTAL_BUCKET_COBBLESTONE_BUY(getConfig().getInt("horizontal.cobblestone.buy"));
        reference.setHORIZONTAL_BUCKET_COBBLESTONE_USE(getConfig().getInt("horizontal.cobblestone.use"));
        reference.setHORIZONTAL_BUCKET_COBBLESTONE_DISTANCE(getConfig().getInt("horizontal.cobblestone.distance"));

        reference.setHORIZONTAL_BUCKET_OBSIDIAN_BUY(getConfig().getInt("horizontal.obsidian.buy"));
        reference.setHORIZONTAL_BUCKET_OBSIDIAN_USE(getConfig().getInt("horizontal.obsidian.use"));
        reference.setHORIZONTAL_BUCKET_OBSIDIAN_DISTANCE(getConfig().getInt("horizontal.obsidian.distance"));

        reference.setTICKS(getConfig().getInt("ticks"));

        inventories = new Inventories();

        generationManager = new GenerationManager();


        ComGenBucket comGenBucket = new ComGenBucket();
        getCommand("gb").setExecutor(comGenBucket);

        Events events = new Events();
        getServer().getPluginManager().registerEvents(events, this);
    }

    @Override
    public void onDisable()
    {

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }


    public Reference getReference()
    {
        return reference;
    }

    public Inventories getInventories()
    {
        return inventories;
    }

    public Economy getEconomy()
    {
        return economy;
    }

    public GenerationManager getGenerationManager()
    {
        return generationManager;
    }
}
