package ru.j2dev.gameserver.network.lineage2.clientpackets;

import ru.j2dev.gameserver.model.Player;
import ru.j2dev.gameserver.network.lineage2.serverpackets.PrivateStoreManageListSell;
import ru.j2dev.gameserver.utils.TradeHelper;

public class RequestPrivateStoreSellManageList extends L2GameClientPacket {
    @Override
    protected void readImpl() {
    }

    @Override
    protected void runImpl() {
        final Player activeChar = getClient().getActiveChar();
        if (activeChar == null) {
            return;
        }
        if (activeChar.isActionsDisabled()) {
            activeChar.sendActionFailed();
            return;
        }
        if (activeChar.getSittingTask()) {
            activeChar.sendActionFailed();
            return;
        }
        if (activeChar.isInStoreMode()) {
            activeChar.setPrivateStoreType(Player.STORE_PRIVATE_NONE);
            activeChar.standUp();
            activeChar.broadcastCharInfo();
        } else if (!TradeHelper.checksIfCanOpenStore(activeChar, 1)) {
            activeChar.sendActionFailed();
            return;
        }
        activeChar.sendPacket(new PrivateStoreManageListSell(activeChar, false));
    }
}
