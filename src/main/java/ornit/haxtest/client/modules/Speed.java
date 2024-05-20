package ornit.haxtest.client.modules;

import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;

public class Speed {
    public static boolean active = false;
    // an arbitrary value. 1 =/= normal speed
    public static float speedMultiplier = 7f;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        Vec3d speedVec = new Vec3d(
                Utils.MC.player.getRotationVecClient().x * speedMultiplier,
                0f,
                Utils.MC.player.getRotationVecClient().z * speedMultiplier
        );
        Utils.MC.player.move(MovementType.SELF, speedVec);
    }
}
