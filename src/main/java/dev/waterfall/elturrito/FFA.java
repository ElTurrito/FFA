package dev.waterfall.elturrito;

import dev.waterfall.elturrito.commands.FFACommand;
import dev.waterfall.elturrito.commands.SpawnCommand;
import dev.waterfall.elturrito.listeners.FFAListener;
import dev.waterfall.elturrito.utils.CC;
import dev.waterfall.elturrito.utils.YamlDoc;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public class FFA extends JavaPlugin {

    @Getter public static FFA instance;
    @Getter YamlDoc configFile;

    @Override
    public void onEnable() {
        instance = this;

        CC.console(CC.translate("&f&m-------------------"));
        CC.console(CC.translate("&aEnabling FFA"));
        CC.console(CC.translate("&aWaterfall Development"));
        CC.console(CC.translate("&f&m--------------------"));
        configFile = new YamlDoc("config.yml");

        this.getCommand("ffa").setExecutor(new FFACommand(this));
        this.getCommand("spawn").setExecutor(new SpawnCommand(this));
        this.getServer().getPluginManager().registerEvents(new FFAListener(), this);
    }

    @Override
    public void onDisable() {
        CC.console(CC.translate("&f&m-------------------"));
        CC.console(CC.translate("&cDisabling FFA"));
        CC.console(CC.translate("&cWaterfall Development"));
        CC.console(CC.translate("&f&m--------------------"));
    }
}
