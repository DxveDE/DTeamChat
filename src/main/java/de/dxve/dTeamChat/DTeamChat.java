package de.dxve.dTeamChat;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.dxve.dTeamChat.commands.DTeamChatCommand;
import de.dxve.dTeamChat.listener.JoinListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Consumer;

/**
 * DTeamChat by DxveDE
 *
 * @author DxveDE
 * @version 1.0.0
 */
public final class DTeamChat extends JavaPlugin {

    @Getter private static DTeamChat instance;
    @Getter private boolean updateCheck;

    @Override
    public void onLoad() {
        instance = this;

        getLogger().info("◢◤ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◥◣");
        getLogger().info(" ");
        getLogger().info("  »  " + getPluginMeta().getName() + " v" + this.getPluginMeta().getVersion() + " by " + this.getPluginMeta().getAuthors());
        getLogger().info(" ");
        getLogger().info("  »  Plugin was loaded.");
        getLogger().info(" ");
        getLogger().info("◥◣ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◢◤");
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Init variables
        if(getConfig().getInt("settings.max-blocks") < 0) getConfig().set("settings.max-blocks", 64);
        updateCheck = getConfig().getBoolean("settings.update-checker");

        // Init commands & events
        getCommand("dteamchat").setExecutor(new DTeamChatCommand());
        if(updateCheck) Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        // finished
        getLogger().info("◢◤ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◥◣");
        getLogger().info(" ");
        getLogger().info("  »  " + getPluginMeta().getName() + " v" + this.getPluginMeta().getVersion() + " by " + this.getPluginMeta().getAuthors());
        getLogger().info(" ");
        getLogger().info("  »  Plugin was enabled.");
        getLogger().info(" ");
        getLogger().info("◥◣ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◢◤");
        if(updateCheck) {
            getLatestVersion(latestVersion -> {
                String currentVersion = getPluginMeta().getVersion();
                if (!currentVersion.equalsIgnoreCase(latestVersion)) {
                    getLogger().info("◢◤ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◥◣");
                    getLogger().info(" ");
                    getLogger().info("  »  An update with version " + latestVersion + " is available!");
                    getLogger().info("  »  Download: https://github.com/DxveDE/" + getPluginMeta().getName() + "/releases/latest");
                    getLogger().info(" ");
                    getLogger().info("◥◣ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◢◤");
                }
            });
        }
    }

    @Override
    public void onDisable() {
        //saveConfig();

        getLogger().info("◢◤ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◥◣");
        getLogger().info(" ");
        getLogger().info("  »  " + getPluginMeta().getName() + " v" + this.getPluginMeta().getVersion() + " by " + this.getPluginMeta().getAuthors());
        getLogger().info(" ");
        getLogger().info("  »  Plugin was disabled.");
        getLogger().info(" ");
        getLogger().info("◥◣ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ◢◤");
    }

    public String getConfigMessage(String path) {
        return (getConfig().getString(path).replace("%prefix%", getConfig().getString("prefix"))).replace("&", "§");
    }

    public void getLatestVersion(Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
            try {
                URL url = new URL("https://api.github.com/repos/DxveDE/" + getPluginMeta().getName() + "/releases/latest");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Accept", "application/vnd.github.v3+json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
                    JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
                    String latestVersion = json.get("tag_name").getAsString();
                    consumer.accept(latestVersion);
                }
            } catch (Exception exception) {
                getLogger().warning("  »  Update-Check failed:");
                getLogger().warning(exception.getMessage());
            }
        });
    }
}
