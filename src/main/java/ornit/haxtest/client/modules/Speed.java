package ornit.haxtest.client.modules;

import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.RenderUtils;

public class Speed {
    public static boolean active = false;
    public static float speedMultiplier = 7f;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        RenderUtils.setModActive("Speed");
        /*
        // OLD IMPLEMENTATION
        Vec3d speedVec = new Vec3d(
                Utils.MC.player.getRotationVecClient().x * speedMultiplier,
                0f,
                Utils.MC.player.getRotationVecClient().z * speedMultiplier
        );
        Utils.MC.player.move(MovementType.SELF, speedVec);
        */
        Vec3d speedVec = new Vec3d(
                Utils.MC.player.getVelocity().x * speedMultiplier,
                Utils.MC.player.getVelocity().y,
                Utils.MC.player.getVelocity().z * speedMultiplier
        );
        Utils.MC.player.move(MovementType.SELF, speedVec);
    }
}
