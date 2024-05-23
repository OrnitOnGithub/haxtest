package ornit.haxtest.client.render;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import java.util.ArrayList;

/*
 * Utility function for rendering. Most importantly contains lineToRenderList.
 */
public class RenderUtils {
    public static ArrayList<Line> lineToRenderList = new ArrayList<>();
    public static ArrayList<Text> textToRenderList = new ArrayList<>();
    public static ArrayList<String> activeModList = new ArrayList<>();

    public static int activeModListMargin = 10; // in pixels

    public static void drawLine(Vec3d posA, Vec3d posB, Color color) {
        lineToRenderList.add(new Line(posA, posB, color));
    }
    public static void drawText(String text, float posX, float posY, int colorInt) {
        textToRenderList.add(new Text(text, posX, posY, colorInt));
    }
    public static void drawModList() {
        int y_position = activeModListMargin;
        int modColor = 0;
        for (String activeMod : activeModList) {
            drawText(activeMod, activeModListMargin, y_position, modColor);
            y_position += 15;
            modColor += 50;
        }
    }
    public static void setModActive(String modName) {
        activeModList.add(modName);
    }

    public static void drawCubeAtBlock(BlockPos blockPos, Color cubeColor) {
        Vec3d posA = new Vec3d(blockPos.getX() +0, blockPos.getY(), blockPos.getZ() +0);
        Vec3d posB = new Vec3d(posA.x + 0, posA.y + 0, posA.z + 1);
        Vec3d posC = new Vec3d(posA.x + 1, posA.y + 0, posA.z + 0);
        Vec3d posD = new Vec3d(posA.x + 1, posA.y + 0, posA.z + 1);
        Vec3d posE = new Vec3d(posA.x + 0, posA.y + 1, posA.z + 0);
        Vec3d posF = new Vec3d(posA.x + 0, posA.y + 1, posA.z + 1);
        Vec3d posG = new Vec3d(posA.x + 1, posA.y + 1, posA.z + 0);
        Vec3d posH = new Vec3d(posA.x + 1, posA.y + 1, posA.z + 1);

        drawLine(posA, posB, cubeColor);
        drawLine(posB, posD, cubeColor);
        drawLine(posD, posC, cubeColor);
        drawLine(posC, posA, cubeColor);
        drawLine(posA, posE, cubeColor);
        drawLine(posB, posF, cubeColor);
        drawLine(posD, posH, cubeColor);
        drawLine(posC, posG, cubeColor);
        drawLine(posE, posF, cubeColor);
        drawLine(posF, posH, cubeColor);
        drawLine(posH, posG, cubeColor);
        drawLine(posG, posE, cubeColor);
    }
    public static void drawCubeAtPos(Vec3d pos, Color cubeColor) {
        Vec3d posA = pos;
        Vec3d posB = new Vec3d(posA.x + 0, posA.y + 0, posA.z + 1);
        Vec3d posC = new Vec3d(posA.x + 1, posA.y + 0, posA.z + 0);
        Vec3d posD = new Vec3d(posA.x + 1, posA.y + 0, posA.z + 1);
        Vec3d posE = new Vec3d(posA.x + 0, posA.y + 1, posA.z + 0);
        Vec3d posF = new Vec3d(posA.x + 0, posA.y + 1, posA.z + 1);
        Vec3d posG = new Vec3d(posA.x + 1, posA.y + 1, posA.z + 0);
        Vec3d posH = new Vec3d(posA.x + 1, posA.y + 1, posA.z + 1);

        drawLine(posA, posB, cubeColor);
        drawLine(posB, posD, cubeColor);
        drawLine(posD, posC, cubeColor);
        drawLine(posC, posA, cubeColor);
        drawLine(posA, posE, cubeColor);
        drawLine(posB, posF, cubeColor);
        drawLine(posD, posH, cubeColor);
        drawLine(posC, posG, cubeColor);
        drawLine(posE, posF, cubeColor);
        drawLine(posF, posH, cubeColor);
        drawLine(posH, posG, cubeColor);
        drawLine(posG, posE, cubeColor);
    }

    public static void clear() {
        lineToRenderList.clear();
        textToRenderList.clear();
        activeModList.clear();
    }
}
