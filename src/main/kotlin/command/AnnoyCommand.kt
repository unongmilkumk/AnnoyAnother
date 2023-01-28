package command

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class AnnoyCommand : CommandExecutor {
    @Suppress("DEPRECATION")
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size >= 2) {
            var target = sender as Player

            val nickname = args[0]
            val action = args[1]
            //var behave = ""
            //if (args.size == 3) behave = args[2]

            if (Bukkit.getPlayer(nickname) != null) target = Bukkit.getPlayer(nickname)!!
            when(action) {
                "jump" -> {
                    target.velocity = target.location.direction.multiply(1).setY(1)
                }
                "drop" -> {
                    target.dropItem(true)
                }
                "attack" -> {
                    target.attack(target)
                }
                "openinv" -> {
                    sender.openInventory(target.inventory)
                }
            }
        }
        return true
    }
}