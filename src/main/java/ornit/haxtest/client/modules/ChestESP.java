package ornit.haxtest.client.modules;

import java.util.ArrayList;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.chunk.Chunk;
import ornit.haxtest.client.Utils;
import ornit.haxtest.client.render.Color;
import ornit.haxtest.client.render.RenderUtils;


public class ChestESP {
    public static boolean active = false;
    public static Color chestESPColor = new Color(1, 1, 0, 1);

    public static void Toggle() {
        active = !active;
    }

    public static void Run() {
        System.out.println("ChestESP is in use");
        int playerChunkPosX = Utils.MC.player.getChunkPos().x;
        int playerChunkPosZ = Utils.MC.player.getChunkPos().z;

        //System.out.println("Your chunk pos is: "+ playerChunkPosX + " " + playerChunkPosZ);

        int playerRenderDistance = Utils.MC.options.getClampedViewDistance();
        //System.out.println("Your render distance is: " + playerRenderDistance);

        // Add every rendered chunk to a chunk list
        ArrayList<Chunk> chunkList = new ArrayList<>();
        // -r  0  +r    | r = render dist
        // X X O X X
        // X O O O X
        // O O O O O
        // X O O O X
        // X X O X X
        // iterate over every coordinate inside render distance
        for (int x = playerChunkPosX - playerRenderDistance; x < playerChunkPosX + playerRenderDistance+1; x++) {
            for (int z = playerChunkPosZ - playerRenderDistance; z < playerChunkPosZ + playerRenderDistance+1; z++) {
                //System.out.println("Checking out: " + x + "," + z);
                // add the chunk at that coord to the chunk list
                chunkList.add(Utils.MC.world.getChunk(x, z));
            }
        }

        for (Chunk chunk : chunkList){
            for (BlockPos blockEntityPos : chunk.getBlockEntityPositions()) {
                // Temporary: print the position
                // System.out.println("Tile entity at position: " + blockEntityPos);
                // RenderUtils.drawLine(new Vec3d(blockEntityPos.getX() -1, blockEntityPos.getY() -1, blockEntityPos.getZ() -1), new Vec3d(blockEntityPos.getX(), blockEntityPos.getY(), blockEntityPos.getZ()));
                RenderUtils.drawCubeAtBlock(blockEntityPos, chestESPColor);
            }
        }
    }
}
