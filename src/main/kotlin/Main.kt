import command.AnnoyCommand
import command.AnnoyTabComplete
import org.bukkit.ChatColor
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("${ChatColor.GOLD}Plugin start annoying you")
        server.getPluginCommand("annoy")!!.setExecutor(AnnoyCommand())
        server.getPluginCommand("annoy")!!.tabCompleter = AnnoyTabComplete()
    }

    override fun onDisable() {
        logger.info("${ChatColor.GOLD}Playground finish annoying you")
    }
}