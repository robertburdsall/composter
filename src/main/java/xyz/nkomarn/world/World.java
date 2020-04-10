package xyz.nkomarn.world;

import xyz.nkomarn.type.Chunk;
import xyz.nkomarn.type.Location;
import xyz.nkomarn.type.Player;
import xyz.nkomarn.world.generator.WorldGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class World {
    public final Location spawn = new Location(this, 0, 15, 0); // TODO implement for player spawning at some point
    private final HashMap<Chunk.Key, Chunk> chunks = new HashMap<>();
    // TODO entities list

    private long time = 0;
    private WorldGenerator generator;
    private ChunkIO io = new ChunkIO();

    public World(WorldGenerator generator) {
        this.generator = generator;
    }

    public Chunk getChunk(final int x, final int z) {
        Chunk.Key key = new Chunk.Key(x, z);
        Chunk chunk = chunks.get(key);
        if (chunk == null) {
            try {
                chunk = io.read(x, z);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (chunk == null) {
                chunk = generator.generate(x, z);
                /*try {
                    io.write(x, z, chunk); // TODO Once generator is done, redo this
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            chunks.put(key, chunk);
        }
        return chunk;
    }

    // TODO save chunks, etc
}
