package ornit.haxtest.client.modules;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.Color;
import ornit.haxtest.client.render.RenderUtils;

public class PlayerESP {
    public static boolean active;
    public static Color playerESPColor = new Color(0, 1, 1, 1);
    public static void Toggle() {
        active = !active;
    }
    public static void Run() {
        for (PlayerEntity player : Utils.MC.world.getPlayers()) {
            if (player != Utils.MC.player) {

                Vec3d playerPos = player.getPos();
                Vec3d playerPosLower = new Vec3d(playerPos.x -0.5, playerPos.y + 0, playerPos.z -0.5);
                Vec3d playerPosUpper = new Vec3d(playerPos.x -0.5, playerPos.y + 1, playerPos.z -0.5);

                RenderUtils.drawCubeAtPos(playerPosLower, playerESPColor);
                RenderUtils.drawCubeAtPos(playerPosUpper, playerESPColor);
            }
        }
    }
}
