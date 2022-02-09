package me.iknees.pluginprovino;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class PluginProvino extends JavaPlugin {

    private HashMap<String, UUID> chunks;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.chunks = new HashMap<>();
        getCommand("claim").setExecutor(new ClaimCommand(this));
        getServer().getPluginManager().registerEvents(new Listeners(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void addChunk(String chunk, UUID owner)
    {
        chunks.put(chunk, owner);
    }

    public boolean isChunk(String chunk)
    {
        return chunks.containsKey(chunk);
    }

    public UUID getOwner(String chunk)
    {
        return chunks.get(chunk);
    }
}
