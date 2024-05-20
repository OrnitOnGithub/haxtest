package ornit.haxtest.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import ornit.haxtest.client.modules.*;
import ornit.haxtest.client.render.Line;
import ornit.haxtest.client.render.RenderUtils;

@Environment(EnvType.CLIENT)
public class HaxtestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        // should get called each frame
        // Draws all lines in RenderUtils.lineToRenderList
        WorldRenderEvents.END.register(context -> {
             for (Line line : RenderUtils.lineToRenderList) {
                 line.Draw(context);
             }
        });


        // Anti AFK Key-bind
        KeyBinding antiafkKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.haxtest.anti_afk", // The translation key of the keybinding's name
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
        // ChestESP Key-bind
        KeyBinding chestESPKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.haxtest.chest_esp",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.haxtest.hax"
        ));
        // PlayerESP Key-bind
        KeyBinding playerESPKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.haxtest.player_esp",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.haxtest.hax"
        ));
        // AimBot Key-bind
        KeyBinding aimBotKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.haxtest.aim_bot",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_H,
                "category.haxtest.hax"
        ));


        // Register a client tick event to check for key presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            // Clear all rendered lines every tick.
            RenderUtils.clear();

            // ANTI AFK
            if (antiafkKeyBind.wasPressed()) {
                AntiAFK.Toggle();
            }
            if (AntiAFK.active) {
                AntiAFK.Run();
            }

            // SPEED
            if (speedKeybind.wasPressed()) {
                Speed.Toggle();
            }
            if (Speed.active) {
                Speed.Run();
            }

            // CHEST ESP
            if (chestESPKeyBind.wasPressed()) {
                ChestESP.Toggle();
            }
            if (ChestESP.active) {
                ChestESP.Run();
            }

            // PLAYER ESP
            if (playerESPKeybind.wasPressed()) {
                PlayerESP.Toggle();
            }
            if (PlayerESP.active) {
                PlayerESP.Run();
            }

            // AIM BOT
            if (aimBotKeyBind.wasPressed()) {
                AimBot.Toggle();
            }
            if (AimBot.active) {
                AimBot.Run();
            }
        });
    }
}