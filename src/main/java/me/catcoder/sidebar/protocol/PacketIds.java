package me.catcoder.sidebar.protocol;

import static me.catcoder.sidebar.protocol.ProtocolConstants.map;


public enum PacketIds {

    UPDATE_TEAMS(
            map(ProtocolConstants.MINECRAFT_1_12_2, 0x44),
            map(ProtocolConstants.MINECRAFT_1_13, 0x47),
            map(ProtocolConstants.MINECRAFT_1_14, 0x4B),
            map(ProtocolConstants.MINECRAFT_1_15, 0x4C),
            map(ProtocolConstants.MINECRAFT_1_17, 0x55),
            map(ProtocolConstants.MINECRAFT_1_19_1, 0x58),
            map(ProtocolConstants.MINECRAFT_1_19_3, 0x56),
            map(ProtocolConstants.MINECRAFT_1_19_4, 0x5A)
    ),
    UPDATE_SCORE(
            map(ProtocolConstants.MINECRAFT_1_12_2, 0x45),
            map(ProtocolConstants.MINECRAFT_1_13, 0x48),
            map(ProtocolConstants.MINECRAFT_1_14, 0x4C),
            map(ProtocolConstants.MINECRAFT_1_15, 0x4D),
            map(ProtocolConstants.MINECRAFT_1_17, 0x56),
            map(ProtocolConstants.MINECRAFT_1_19_1, 0x59),
            map(ProtocolConstants.MINECRAFT_1_19_3, 0x57),
            map(ProtocolConstants.MINECRAFT_1_19_4, 0x5B)

    ),
    OBJECTIVE_DISPLAY(
            map(ProtocolConstants.MINECRAFT_1_12_2, 0x3B),
            map(ProtocolConstants.MINECRAFT_1_13, 0x3E),
            map(ProtocolConstants.MINECRAFT_1_14, 0x42),
            map(ProtocolConstants.MINECRAFT_1_15, 0x43),
            map(ProtocolConstants.MINECRAFT_1_17, 0x4C),
            map(ProtocolConstants.MINECRAFT_1_19_1, 0x4F),
            map(ProtocolConstants.MINECRAFT_1_19_3, 0x4D),
            map(ProtocolConstants.MINECRAFT_1_19_4, 0x51)

    ),
    OBJECTIVE(
            map(ProtocolConstants.MINECRAFT_1_12_2, 0x42),
            map(ProtocolConstants.MINECRAFT_1_13, 0x45),
            map(ProtocolConstants.MINECRAFT_1_14, 0x49),
            map(ProtocolConstants.MINECRAFT_1_15, 0x4A),
            map(ProtocolConstants.MINECRAFT_1_17, 0x53),
            map(ProtocolConstants.MINECRAFT_1_19_1, 0x56),
            map(ProtocolConstants.MINECRAFT_1_19_3, 0x54),
            map(ProtocolConstants.MINECRAFT_1_19_4, 0x58)
    );

    private final ProtocolConstants.ProtocolMapping[] mappings;

    PacketIds(ProtocolConstants.ProtocolMapping... mappings) {
        this.mappings = mappings;
    }

    public int getPacketId(int serverVersion) {

        for (int protocol = ProtocolConstants.MINIMUM_SUPPORTED_VERSION;
             protocol <= ProtocolConstants.MAXIMUM_SUPPORTED_VERSION; protocol++) {
            int index = 0;

            for (ProtocolConstants.ProtocolMapping mapping : mappings) {
                if (mapping.getProtocol() == protocol
                        && mapping.getProtocol() <= serverVersion
                        && (index == mappings.length - 1 || mappings[index + 1].getProtocol() > serverVersion))
                    return mapping.getPacketId();

                index++;
            }

        }

        throw new IllegalArgumentException("Unsupported protocol version: " + serverVersion);
    }
}
