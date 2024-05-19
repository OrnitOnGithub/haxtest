package ornit.haxtest.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.option.KeyBinding;


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
    public static void setKeyPressed(KeyBinding keyBinding, boolean pressed) {
        InputUtil.Key key = keyBinding.getDefaultKey();
        int keyCode = key.getCode();

        // Update the key binding state
        KeyBinding.setKeyPressed(key, pressed);

        // Manually update the key pressed map
        //InputUtil.setKeyPressed(keyCode, pressed);
    }
}