package command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class AnnoyTabComplete : TabCompleter {
    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): MutableList<String>? {
        if (args.size == 1) {
            val ret = ArrayList<String>().toMutableList()
            Bukkit.getOnlinePlayers().forEach {
                ret.add(it.name)
            }
            return ret
        } else if (args.size == 2) {
            val ret = arrayListOf("jump", "drop", "attack", "openinv")
            return ret.toMutableList()
        }
        return null
    }
}