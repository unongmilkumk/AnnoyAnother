import command.AnnoyCommand
import org.bukkit.ChatColor
import org.bukkit.command.CommandExecutor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        logger.info("${ChatColor.GOLD}Plugin start annoying you")
    }

    override fun onDisable() {
        logger.info("${ChatColor.GOLD}Playground finish annoying you")
        registerCommand("annoy", AnnoyCommand())
    }

    private fun registerEvent(listener : Listener) {
        server.pluginManager.registerEvents(listener, this@Main)
    }
    private fun registerCommand(name: String, command: CommandExecutor) {
        server.getPluginCommand(name)!!.setExecutor(command)
    }
}