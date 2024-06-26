package ornit.haxtest.client.modules;

import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import java.util.List;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.RenderUtils;

public class AimBot {
    public static boolean active = false;
    public static double aimbotEngageDistance = 7;
    public static double eyeHeightOffset = 1.5;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        RenderUtils.setModActive("AimBot");

        // Find the closest player
        int index = 0;
        int shortestIndex = 0;
        double shortestDistance = aimbotEngageDistance; // initial value is also min distance
        for (Entity playerEntity : Utils.MC.world.getPlayers()) {
            //Utils.MC.player.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, entity.getPos());
            Vec3d playerPos = Utils.MC.player.getPos();
            Vec3d entityPos = playerEntity.getPos();

            double distance = Math.sqrt(Math.pow(playerPos.x - entityPos.x, 2) + Math.pow(playerPos.y - entityPos.y, 2) + Math.pow(playerPos.z - entityPos.z, 2));

            if (distance < shortestDistance && distance > 0.5) {
                shortestDistance = distance;
                shortestIndex = index;
            }
            index++;
        }
        if (shortestIndex != 0) { // I don't think this is needed.
            List<AbstractClientPlayerEntity> players = Utils.MC.world.getPlayers(); // Use getPlayers() instead of getEntities()
            AbstractClientPlayerEntity closestPlayer = players.get(shortestIndex); // Get the closest player from the list
            Vec3d aimPos = new Vec3d(closestPlayer.getPos().x, closestPlayer.getPos().y + eyeHeightOffset, closestPlayer.getPos().z);
            Utils.MC.player.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, aimPos);
        }
    }
}
