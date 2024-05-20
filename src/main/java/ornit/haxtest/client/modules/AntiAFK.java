package ornit.haxtest.client.modules;

import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;
import ornit.haxtest.client.Utils;

public class AntiAFK {
    private static long lastMoveTime = 0;
    private static final long MOVE_DELAY_MS = 1000;

    public static boolean active = false;
    public static float speedMultiplier = 0.2f;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        System.out.println("AntiAFK is in use!");

        // Move once left and once right, with some delay in between
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastMoveTime) >= MOVE_DELAY_MS) {

            speedMultiplier = -speedMultiplier; // invert multiplier to invert movement

            // an arbitrary value. 1 =/= normal speed
            Vec3d speedVec = new Vec3d(
                    Utils.MC.player.getRotationVecClient().x * speedMultiplier,
                    0f,
                    Utils.MC.player.getRotationVecClient().z * speedMultiplier
            );
            Utils.MC.player.move(MovementType.SELF, speedVec);
            lastMoveTime = currentTime;
        }
    }
}
