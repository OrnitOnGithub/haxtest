package ornit.haxtest.client.modules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import org.lwjgl.glfw.GLFW;
import ornit.haxtest.client.Utils;

public class AutoClicker {
    public static boolean active = false;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        //long windowHandle = client.getWindow().getHandle();

        // Simulate mouse button press and release
        //InputUtil.setMouseButtonState(windowHandle, GLFW.GLFW_MOUSE_BUTTON_1, true);
        //InputUtil.setMouseButtonState(windowHandle, GLFW.GLFW_MOUSE_BUTTON_1, false);

        
    }
}
