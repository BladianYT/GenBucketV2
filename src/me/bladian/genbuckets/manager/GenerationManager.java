package me.bladian.genbuckets.manager;

import me.bladian.genbuckets.GenBucketV2;
import me.bladian.genbuckets.events.GenerationEndEvent;
import me.bladian.genbuckets.events.GenerationStartEvent;
import me.bladian.genbuckets.type.GenerationType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class GenerationManager
{

    private GenBucketV2 genBucketV2 = GenBucketV2.instance;

    /**
     *
     * @param material
     *      The material which the gen bucket creates
     * @param ticks
     *      The amount of ticks it takes to place one block
     * @param location
     *      Where the block should begin placing
     */
    public void verticalTask(final Material material, final int ticks, final Location location)
    {
        GenerationStartEvent generationStartEvent = new GenerationStartEvent(GenerationType.VERTICAL, material, ticks, location);
        Bukkit.getPluginManager().callEvent(generationStartEvent);
        final Location changingLoc = location.clone();
        final List<Location> locations = new ArrayList<>();
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if(changingLoc.getBlock().getType() == Material.AIR)
                {
                    changingLoc.getBlock().setType(material);
                    locations.add(changingLoc.clone());
                    changingLoc.add(new Vector(0, -1, 0));
                }
                else
                {
                    this.cancel();
                    GenerationEndEvent generationEndEvent = new GenerationEndEvent(GenerationType.VERTICAL, material, ticks, location, changingLoc, locations);
                    Bukkit.getPluginManager().callEvent(generationEndEvent);
                }
            }
        }.runTaskTimer(genBucketV2, 0L, ticks);
    }


    /**
     *
     * @param material
     *      The material which the gen bucket creates
     * @param ticks
     *      The amount of ticks it takes to place one block
     * @param location
     *      Where the block should begin placing
     */
    public void verticalTaskGravity(final Material material, final int ticks, final Location location)
    {
        GenerationStartEvent generationStartEvent = new GenerationStartEvent(GenerationType.VERTICAL_GRAVITY, material, ticks, location);
        Bukkit.getPluginManager().callEvent(generationStartEvent);
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
        final List<Location> locations = new ArrayList<>();
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if(changingLoc.getBlock().getType() == Material.AIR && changingLoc.getY() <= highestY)
                {
                    changingLoc.getBlock().setType(material);
                    location.add(changingLoc.clone());
                    changingLoc.add(new Vector(0, 1, 0));
                }
                else
                {
                    this.cancel();
                    GenerationEndEvent generationEndEvent = new GenerationEndEvent(GenerationType.VERTICAL_GRAVITY, material, ticks, location, changingLoc, locations);
                    Bukkit.getPluginManager().callEvent(generationEndEvent);
                }
            }
        }.runTaskTimer(genBucketV2, 0L, ticks);
    }


    /**
     *
     * @param material
     *      The material which the gen bucket creates
     * @param ticks
     *      The amount of ticks it takes to place one block
     * @param location
     *      Where the block should begin placing
     * @param distance
     *      How many blocks should the gen bucket go
     * @param blockFace
     *      This is the direction of the bucket, it'll be the opposite of the clicked block
     */
    public void horizontalTask(final Material material, final int ticks, final Location location, final int distance, final BlockFace blockFace)
    {
        GenerationStartEvent generationStartEvent = new GenerationStartEvent(GenerationType.HORIZONTAL, material, ticks, location, distance, blockFace);
        Bukkit.getPluginManager().callEvent(generationStartEvent);
        final Location changingLoc = location.clone();
        final List<Location> locations = new ArrayList<>();
        new BukkitRunnable()
        {
            int times = 0;
            @Override
            public void run()
            {
                if(changingLoc.getBlock().getType() == Material.AIR && times != distance)
                {
                    changingLoc.getBlock().setType(material);
                    locations.add(changingLoc.clone());
                    switch (blockFace)
                    {
                        case NORTH:
                            changingLoc.add(new Vector(0, 0, -1));
                            break;

                        case EAST:
                            changingLoc.add(new Vector(1, 0, 0));
                            break;

                        case SOUTH:
                            changingLoc.add(new Vector(0, 0, 1));
                            break;

                        case WEST:
                            changingLoc.add(new Vector(-1, 0, 0));
                            break;
                    }
                    times++;
                }
                else
                {
                    this.cancel();
                    GenerationEndEvent generationEndEvent = new GenerationEndEvent(GenerationType.HORIZONTAL, material, ticks, location, changingLoc, locations, distance, blockFace);
                    Bukkit.getPluginManager().callEvent(generationEndEvent);
                }
            }
        }.runTaskTimer(genBucketV2, 0L, ticks);
    }

}
