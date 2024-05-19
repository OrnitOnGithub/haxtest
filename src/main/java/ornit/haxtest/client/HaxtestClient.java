package ornit.haxtest.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import ornit.haxtest.client.modules.*;

@Environment(EnvType.CLIENT)
public class HaxtestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        System.out.println("Client initialised!");

        // Anti AFK Key-bind
        KeyBinding antiafkKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.haxtest.antiafk", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_H, // The keycode of the key
                "category.haxtest.hax" // The translation key of the keybinding's category.
        ));
        // Speed Key-bind
        KeyBinding speedKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.haxtest.speed",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.haxtest.hax"
        ));

        // Register a client tick event to check for key presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // ANTI AFK
            if (antiafkKeyBind.wasPressed()) {
                AntiAFK.ToggleAntiAFK();
            }
            if (AntiAFK.antiAFKRunning) {
                AntiAFK.RunAntiAFK();
            }

            // SPEED
            if (speedKeybind.wasPressed()) {
                Speed.ToggleSPeed();
            }
            if (Speed.speedRunning) {
                Speed.Speed();
            }

        });
    }


}