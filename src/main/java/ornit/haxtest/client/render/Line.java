package ornit.haxtest.client.render;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;

/*
 * Class for lines. These are stored in RenderUtils.lineToRenderList. They are then drawn each frame.
 * Any part of the program who wants to draw a line needs to append it to RenderUtils.lineToRenderList.
 *
 * Note that the positions you provide must be absolute (world coordinates).
 */
public class Line {
    public Vec3d startPos;
    public Vec3d endPos;
    public Color color;

    public Line(Vec3d posA, Vec3d posB, Color lineColor) {
        startPos = posA;
        endPos = posB;
        // colors
        color = lineColor;
    }

    public void Draw(WorldRenderContext context) {
        Vec3d playerPos = Utils.MC.player.getCameraPosVec(0);
        // calculate relative position using given position (absolute) - player position (absolute)
        Vec3d start = new Vec3d(this.startPos.x - playerPos.x, this.startPos.y - playerPos.y, this.startPos.z - playerPos.z);
        Vec3d end = new Vec3d(this.endPos.x - playerPos.x, this.endPos.y - playerPos.y, this.endPos.z - playerPos.z);
        Color color = this.color;
        LineRenderer.drawLine3D(
                context.matrixStack().peek().getPositionMatrix(),
                start,
                end,
                color.r, color.g, color.b, color.a
        );
    }
}

//        WorldRenderEvents.LAST.register(context -> {
//            pissFuck++;
//            Vec3d start = new Vec3d(pissFuck, 70, 0);
//            Vec3d end = new Vec3d(100, 70, 100);
//            LineRenderer.drawLine3D(context.matrixStack().peek().getPositionMatrix(), start, end, 1.0f, 0.0f, 0.0f, 1.0f);
//        });