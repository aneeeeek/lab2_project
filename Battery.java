package brokenrobotgame.model;

import brokenrobotgame.model.navigation.CellPosition;

/*
 * Battery - �������� �������, ������� ����� �������� ������ �����������
 */
public class Battery extends AbstractBattery
{
    public Battery(GameField field, int capacity, int amount)
    {
        super(field,capacity,amount);
    }
	
	public capacityUpdate()
	{
		capacity++;
	}
	
	public amountUpdate()
	{
		amount++;
	}
}
