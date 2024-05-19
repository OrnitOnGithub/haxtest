package ornit.haxtest.client.modules;

import java.util.ArrayList;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import ornit.haxtest.client.Utils;


public class ChestESP {
    public static void ChestESP() {
        int playerChunkPosX = Utils.MC.player.getChunkPos().x;
        int playerChunkPosZ = Utils.MC.player.getChunkPos().z;

        System.out.println("Your chunk pos is: "+ playerChunkPosX + " " + playerChunkPosZ);

        int playerRenderDistance = Utils.MC.options.getClampedViewDistance();
        System.out.println("Your render distance is: " + playerRenderDistance);

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
                System.out.println("Checking out: " + x + "," + z);
                // add the chunk at that coord to the chunk list
                chunkList.add(Utils.MC.world.getChunk(x, z));
            }
        }

        for (Chunk chunk : chunkList){
            for (BlockPos blockEntityPos : chunk.getBlockEntityPositions()) {
                // Temporary: print the position
                System.out.println("Tile entity at position: " + blockEntityPos);
            }
        }
    }
}
