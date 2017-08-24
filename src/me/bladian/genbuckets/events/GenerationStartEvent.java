package me.bladian.genbuckets.events;

import me.bladian.genbuckets.type.GenerationType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Bladian. Before using the code, kindly ask permission to him via the following methods.
 * <p>
 * Twitter: BladianMC
 * Discord: Bladian#6411
 * <p>
 * Thank you for reading!
 */


public class GenerationStartEvent extends Event
{
    @Override
    public HandlerList getHandlers()
    {
        return null;
    }

    private GenerationType generationType;
    private Material material;
    private int ticks;
    private Location location;
    private  int distance;
    private BlockFace blockFace;


    /**
     *
     * @param generationType
     *      The type of generation (Horizontal, Vertical, Vertical with Gravity)
     * @param material
     *      The material which the gen bucket creates
     * @param ticks
     *      The amount of ticks it takes to place one block
     * @param location
     *      Where the block should begin placing
     *
     */
    public GenerationStartEvent(GenerationType generationType, Material material, int ticks, Location location)
    {
        this.generationType = generationType;
        this.material = material;
        this.ticks = ticks;
        this.location = location;
    }

    /**
     *
     * @param generationType
     *      The type of generation (Horizontal, Vertical, Vertical with Gravity)
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
    public GenerationStartEvent(GenerationType generationType, Material material, int ticks, Location location, int distance, BlockFace blockFace)
    {
        this.generationType = generationType;
        this.material = material;
        this.ticks = ticks;
        this.location = location;
        this.distance = distance;
        this.blockFace = blockFace;
    }

    public GenerationType getGenerationType()
    {
        return generationType;
    }

    public Material getMaterial()
    {
        return material;
    }

    public int getTicks()
    {
        return ticks;
    }

    public Location getLocation()
    {
        return location;
    }

    public int getDistance()
    {
        return distance;
    }

    public BlockFace getBlockFace()
    {
        return blockFace;
    }
}
