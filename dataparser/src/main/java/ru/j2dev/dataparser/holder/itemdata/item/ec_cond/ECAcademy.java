package ru.j2dev.dataparser.holder.itemdata.item.ec_cond;

import ru.j2dev.dataparser.annotations.class_annotations.ParseSuper;
import ru.j2dev.dataparser.annotations.value.IntValue;

/**
 * @author : Camelion
 * @date : 28.08.12  12:32
 */
@ParseSuper
public class ECAcademy extends DefaultEquipCond {
    @IntValue(withoutName = true)
    public int academy;
}
