package ornit.haxtest.client.modules;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.RenderUtils;

import java.util.List;

public class KillAura {
    public static boolean active = false;
    /*
     * Delay between kill-aura hits (in ticks)
     */
    public static int tickHitDelay = 12;
    // holds current time passed. Hit only when this is bigger than tickHitDelay
    public static int currentTickDelay = 0;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        RenderUtils.setModActive("KillAura");
        //long windowHandle = client.getWindow().getHandle();

        // Simulate mouse button press and release
        //InputUtil.setMouseButtonState(windowHandle, GLFW.GLFW_MOUSE_BUTTON_1, true);
        //InputUtil.setMouseButtonState(windowHandle, GLFW.GLFW_MOUSE_BUTTON_1, false);

        // Find the closest player
        int index = 0;
        int shortestIndex = 0;
        double shortestDistance = AimBot.aimbotEngageDistance; // initial value is also min distance
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
        if (shortestIndex != 0 && currentTickDelay > tickHitDelay) { // I don't think this is needed.
            List<AbstractClientPlayerEntity> players = Utils.MC.world.getPlayers(); // Use getPlayers() instead of getEntities()
            AbstractClientPlayerEntity closestPlayer = players.get(shortestIndex); // Get the closest player from the list
            //System.out.println(closestPlayer);
            Utils.MC.interactionManager.attackEntity(Utils.MC.player, closestPlayer);
            Utils.MC.player.swingHand(Hand.MAIN_HAND);
            currentTickDelay = 0;
        }
        else {
            currentTickDelay++;
        }
    }
}
