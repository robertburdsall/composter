package xyz.nkomarn.protocol.packets;

import io.netty.buffer.ByteBuf;
import xyz.nkomarn.protocol.Packet;

public class PacketIncrementStatistic extends Packet {
    @Override
    public ByteBuf encode(Object message) {
        return null;
    }

    @Override
    public Object decode(ByteBuf buffer) {
        return null;
    }
    //TODO 0xC8
}
