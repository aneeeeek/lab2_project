package brokenrobotgame.model;

import brokenrobotgame.model.characteristics.AbstractCharacteristic;
import brokenrobotgame.model.characteristics.CellCharacteristic;
import brokenrobotgame.model.navigation.MiddlePosition;
import brokenrobotgame.model.navigation.CellPosition;
import java.util.ArrayList;


/*
 * GameField - абстракция поля, состоящего из ячеек;  
 * контейнер для игровых юнитов (робота, стен и батареек)
 */
public class GameField {

    // ------------------------------ Размеры ---------------------------
	
    public GameField ()
    {
        setSize(10, 10);
    }
        
    public final void setSize(int width, int height)
    {
        CellPosition.setHorizontalRange(1, width);
        CellPosition.setVerticalRange(1, height);
    }

    public int width() {
        return CellPosition.horizontalRange().length();
    }

    public int height() {
        return CellPosition.verticalRange().length();
    }
	
    // ---------------------------- Робот ---------------------

    //!!!
    Robot _robot;

    // Устанавливаем двустороннюю связь с роботом
    public void setRobot(Robot robot)
    {
        if(robot!=null && _robot!=robot) {
            if (_robot != null) {
                removeRobot();
            }

            _robot = robot;
            _robot.setField(this);
        }
    }

    public boolean removeRobot()
    {
        if(_robot==null)
            return false;

        Robot r = _robot;
        _robot=null;
        r.removeField();

        return true;
    }

	
    // ---------------------------- Стены ----------------------------

    private ArrayList<WallPiece> _wallPool = new ArrayList();   // стены

    public boolean isWall(MiddlePosition pos)
    {
        for (WallPiece obj : _wallPool)
        {
            if(obj.position().equals(pos))  return true;
        }
        
        return false;
    }
    
    public boolean addWall(MiddlePosition pos, WallPiece obj)
    {
        boolean success = obj.setPosition(pos);
        
        if(success) _wallPool.add(obj);
        
        return success;
    }

    // ---------------------------- Двери ----------------------------

    private ArrayList<Door> _doorPool = new ArrayList();        // двери

    public Door door(MiddlePosition pos)
    {
        for (Door obj : _doorPool)
        {
            if(obj.position().equals(pos))  return obj;
        }
        
        return null;
    }
    
    public boolean addDoor(MiddlePosition pos, Door obj)
    {
        boolean success = obj.setPosition(pos);
        
        if(success) _doorPool.add(obj);
        
        return success;
    }

    // -------------------------- Характеристики ---------------------
    private ArrayList<CellCharacteristic> _characteristics = new ArrayList();  // характеристики

    public CellCharacteristic characteristic (CellPosition pos)
    {
        for (CellCharacteristic obj : _characteristics)
        {
            if(obj.position().equals(pos))  return obj;
        }

        return null;
    }

    public boolean addCharacteristic(CellPosition pos, CellCharacteristic obj)
    {
        boolean success = obj.setPosition(pos);

        if(success) _characteristics.add(obj);

        return success;
    }

    public boolean removeCharacteristic(CellCharacteristic obj)
    {
        boolean success = _characteristics.remove(obj);

        if(success) obj.setPosition(null);

        return success;
    }

    // ---------------------------- Батарейки ----------------------------
    
    private ArrayList<AbstractBattery> _batteryPool = new ArrayList();  // батарейки

    public AbstractBattery battery(CellPosition pos)
    {
        for (AbstractBattery obj : _batteryPool)
        {
            if(obj.position().equals(pos))  return obj;
        }
        
        return null;
    }
	
    public boolean addBattery(CellPosition pos, AbstractBattery obj)
    {
        boolean success = obj.setPosition(pos);
        
        if(success) _batteryPool.add(obj);
        
        return success;
    }
    
    public boolean removeBattery(AbstractBattery obj)
    {
        boolean success = _batteryPool.remove(obj);
        
        if(success) obj.setPosition(null);
        
        return success;
    }
    
    // ---------------------------- Очистка ----------------------------
    
    public void clear()
    {
        //!!!
        removeRobot();

        _wallPool.clear();
        _batteryPool.clear();
    }
}