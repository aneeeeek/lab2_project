package brokenrobotgame.model;

import brokenrobotgame.model.navigation.CellPosition;

/*
 * Battery - обладает зарядом, который может отдавать другим устройствам
 */
public class Battery extends AbstractBattery, Unit, Cell
{
    public Battery(GameField field, int capacity, int amount)
    {
        super(field,capacity,amount);
		capacity++;
		amount++;
    }
}
