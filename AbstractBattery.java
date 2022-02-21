package brokenrobotgame.model;

import brokenrobotgame.model.navigation.CellPosition;

abstract public class AbstractBattery
{
    // ---------------- После уничтожения батареи, доступ к ней запрещен -----------------

    private boolean _isDestroy = false;     // батарея подлежит использованию

    // Уничтожить батарею
    public void destroy()
    {
        _amountОfСharge = 0;
        _isDestroy = true;
    }


    // ------------------- Устанавливаем связь с игровым полем -----------------
    private GameField _field;

    // ----------------------- Емкость и заряд батареи -------------------------
    private int _chargeCapacity = 100;                  // емкость в условных единицах
    private int _amountОfСharge = _chargeCapacity;      // заряд в условных единицах

    public AbstractBattery (GameField field, int capacity, int amount)
    {
        // TODO исключение, если заряд больше емкости
        if (amount>capacity)
            throw new RuntimeException("ERROR: amount of charge is greater than capacity");

        _field = field;
        _chargeCapacity = capacity;
        _amountОfСharge = amount;
    }
    //Уменьшение заряда батареи
    public int chargeCapacity()
    {
        // TODO исключение, если батарея уничтожена
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        return _chargeCapacity;
    }

    public int amountОfСharge()
    {
        // TODO исключение, если батарея уничтожена
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        return _amountОfСharge;
    }

    public void reduceCharge(int delta)
    {
        // TODO исключение, если батарея уничтожена
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        // TODO исключение, если delta не положительное
        if(delta<0)
        {
            throw new RuntimeException("ERROR: delta is negative");
        }

        _amountОfСharge -= delta;

        if(_amountОfСharge < 0)
            _amountОfСharge = 0;
    }


    // ----------------------- Позиция батарейки -------------------------

    CellPosition _position;                             // позиция

    public CellPosition position()
    {
        // TODO исключение, если батарея уничтожена
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        return _position;
    }

    boolean setPosition(CellPosition pos)
    {
        boolean success = false;

        if(pos == null)                         // батарейка вне поля
        {
            _position = null;
            success = true;
        }
        else if(_field.battery(pos)!= null)     // позиция уже занята другой батарейкой
        {
            success = false;
        }
        else                                    // позиция свободна
        {
            _position = pos;
            success = true;
        }

        return success;
    }
}
