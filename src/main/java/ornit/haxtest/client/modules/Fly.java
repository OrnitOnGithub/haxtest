package ornit.haxtest.client.modules;

import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.RenderUtils;

public class Fly {
    public static boolean active = false;
    // an arbitrary value. 1 =/= normal speed
    public static float flySpeed = 1;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        RenderUtils.setModActive("Fly");
        if (Utils.MC.options.jumpKey.wasPressed()) {
            Vec3d speedVec = new Vec3d(
                Utils.MC.player.getVelocity().x,
                flySpeed,
                Utils.MC.player.getVelocity().z
            );
            Utils.MC.player.setVelocity(speedVec);
        } else if (Utils.MC.options.sneakKey.wasPressed()) {
            Vec3d speedVec = new Vec3d(
                Utils.MC.player.getVelocity().x,
                -flySpeed,
                Utils.MC.player.getVelocity().z
            );
            Utils.MC.player.setVelocity(speedVec);
        }
    }
}
