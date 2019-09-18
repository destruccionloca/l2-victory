package ru.j2dev.gameserver.network.lineage2.clientpackets;

import ru.j2dev.gameserver.manager.MatchingRoomManager;
import ru.j2dev.gameserver.model.Player;

public class RequestExitPartyMatchingWaitingRoom extends L2GameClientPacket {
    @Override
    protected void readImpl() {
    }

    @Override
    protected void runImpl() {
        final Player player = getClient().getActiveChar();
        if (player == null) {
            return;
        }
        MatchingRoomManager.getInstance().removeFromWaitingList(player);
    }
}
