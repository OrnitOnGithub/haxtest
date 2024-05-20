package ornit.haxtest.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import com.mojang.blaze3d.systems.RenderSystem;


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
}