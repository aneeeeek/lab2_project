package brokenrobotgame.model;

import brokenrobotgame.model.navigation.CellPosition;

abstract public class AbstractBattery
{
    // ---------------- ����� ����������� �������, ������ � ��� �������� -----------------

    private boolean _isDestroy = false;     // ������� �������� �������������

    // ���������� �������
    public void destroy()
    {
        _amount�f�harge = 0;
        _isDestroy = true;
    }


    // ------------------- ������������� ����� � ������� ����� -----------------
    private GameField _field;

    // ----------------------- ������� � ����� ������� -------------------------
    private int _chargeCapacity = 100;                  // ������� � �������� ��������
    private int _amount�f�harge = _chargeCapacity;      // ����� � �������� ��������

    public AbstractBattery (GameField field, int capacity, int amount)
    {
        // TODO ����������, ���� ����� ������ �������
        if (amount>capacity)
            throw new RuntimeException("ERROR: amount of charge is greater than capacity");

        _field = field;
        _chargeCapacity = capacity;
        _amount�f�harge = amount;
    }
    //���������� ������ �������
    public int chargeCapacity()
    {
        // TODO ����������, ���� ������� ����������
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        return _chargeCapacity;
    }

    public int amount�f�harge()
    {
        // TODO ����������, ���� ������� ����������
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        return _amount�f�harge;
    }

    public void reduceCharge(int delta)
    {
        // TODO ����������, ���� ������� ����������
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        // TODO ����������, ���� delta �� �������������
        if(delta<0)
        {
            throw new RuntimeException("ERROR: delta is negative");
        }

        _amount�f�harge -= delta;

        if(_amount�f�harge < 0)
            _amount�f�harge = 0;
    }


    // ----------------------- ������� ��������� -------------------------

    CellPosition _position;                             // �������

    public CellPosition position()
    {
        // TODO ����������, ���� ������� ����������
        if(_isDestroy)
        {
            throw new RuntimeException("ERROR: battery is destroyed");
        }

        return _position;
    }

    boolean setPosition(CellPosition pos)
    {
        boolean success = false;

        if(pos == null)                         // ��������� ��� ����
        {
            _position = null;
            success = true;
        }
        else if(_field.battery(pos)!= null)     // ������� ��� ������ ������ ����������
        {
            success = false;
        }
        else                                    // ������� ��������
        {
            _position = pos;
            success = true;
        }

        return success;
    }
}
