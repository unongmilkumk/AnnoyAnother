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
            val ret = arrayListOf("shift", "sprint", "jump", "swimming", "drop", "attack")
            return ret.toMutableList()
        } else if (args.size == 3) {
            val up = arrayListOf("shift", "sprint", "swimming")
            if (up.contains(args[2])) {
                return arrayListOf("up", "down").toMutableList()
            }
        }
        return null
    }
}