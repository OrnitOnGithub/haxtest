package ornit.haxtest.client;

import net.minecraft.client.MinecraftClient;
import ornit.haxtest.client.modules.*;

public class Utils {
    public static final MinecraftClient MC = MinecraftClient.getInstance();

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // Restore the interrupted status
            Thread.currentThread().interrupt();
        }
    }

    public static void disableAllMods() {
        AimBot.active = false;
        AntiAFK.active = false;
        ChestESP.active = false;
        KillAura.active = false;
        PlayerESP.active = false;
        Speed.active = false;
    }
}