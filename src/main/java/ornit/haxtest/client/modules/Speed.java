package ornit.haxtest.client.modules;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;

public class Speed {
    public static boolean speedRunning = false;
    // an arbitrary value. 1 =/= normal speed
    public static float speedMultiplier = 1f;

    public static void ToggleSPeed() {
        speedRunning = !speedRunning;
    }

    public static void Speed() {
        Vec3d speedVec = new Vec3d(
                Utils.MC.player.getRotationVecClient().x * speedMultiplier,
                0f,
                Utils.MC.player.getRotationVecClient().z * speedMultiplier
        );
        Utils.MC.player.move(MovementType.SELF, speedVec);
    }
}
