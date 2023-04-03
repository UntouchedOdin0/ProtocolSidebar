package me.catcoder.sidebar.util.version;

import com.viaversion.viaversion.ViaVersionPlugin;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class VersionUtil {

    public static final int SERVER_VERSION = MinecraftProtocolVersion.getCurrentVersion();

    static {
        Bukkit.getLogger().info("[ProtocolSidebar] Server version: " + MinecraftVersion.getCurrentVersion());
        Bukkit.getLogger().info("[ProtocolSidebar] Please report any bugs to the developer: https://github.com/CatCoderr/ProtocolSidebar/issues");
    }

    public static int getPlayerVersion(@NonNull UUID id) {
        boolean isVia = Bukkit.getPluginManager().isPluginEnabled("ViaVersion");
        return isVia ? JavaPlugin.getPlugin(ViaVersionPlugin.class).getApi().getPlayerVersion(id) : SERVER_VERSION;
    }
}
