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
        registerCommand("annoy", AnnoyCommand())
        registerTabCommand("annoy", AnnoyTabComplete())
    }

    override fun onDisable() {
        logger.info("${ChatColor.GOLD}Playground finish annoying you")
    }

    private fun registerEvent(listener : Listener) {
        server.pluginManager.registerEvents(listener, this@Main)
    }
    private fun registerCommand(name: String, command: CommandExecutor) {
        server.getPluginCommand(name)!!.setExecutor(command)
    }
    private fun registerTabCommand(name: String, tabCompleter: TabCompleter) {
        server.getPluginCommand(name)!!.tabCompleter = tabCompleter
    }
}