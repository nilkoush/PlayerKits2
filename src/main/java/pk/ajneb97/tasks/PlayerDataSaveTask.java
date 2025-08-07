package pk.ajneb97.tasks;

import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.scheduler.BukkitRunnable;
import pk.ajneb97.PlayerKits2;

public class PlayerDataSaveTask {

	private PlayerKits2 plugin;
	private boolean end;
	MyScheduledTask task;
	public PlayerDataSaveTask(PlayerKits2 plugin) {
		this.plugin = plugin;
		this.end = false;
	}
	
	public void end() {
		end = true;
	}
	
	public void start(int seconds) {
		long ticks = seconds* 20L;

		task = PlayerKits2.getScheduler().runTaskTimerAsynchronously(() -> {
				if(end) {
					task.cancel();
				}else {
					execute();
				}
		}, 0L, ticks);
	}
	
	public void execute() {
		plugin.getConfigsManager().getPlayersConfigManager().saveConfigs();
	}
}
