package ru.j2dev.gameserver.listener.actor.player;


import ru.j2dev.gameserver.listener.PlayerListener;
import ru.j2dev.gameserver.model.Player;

/**
 * Created by JunkyFunky
 * on 20.12.2017 10:14
 * group j2dev
 */
@FunctionalInterface
public interface OnPlayerClassChange extends PlayerListener {
    void onPlayerClassChange(Player player, int oldClass, int newClass);
}
