package ornit.haxtest.client.modules;

import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.RenderUtils;

public class NoFallDamage {
    public static boolean active = false;

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        RenderUtils.setModActive("NoFallDamage");

        if (Utils.MC.player.fallDistance > 2) {
            Utils.MC.player.networkHandler.sendPacket(
                new net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.OnGroundOnly(true)
            );
        }
    }
}
