package brokenrobotgame.model.characteristics;

import brokenrobotgame.model.GameField;
import brokenrobotgame.model.characteristics.AbstractCharacteristic;
import brokenrobotgame.model.events.RobotActionEvent;
import brokenrobotgame.model.events.RobotActionListener;
import brokenrobotgame.model.navigation.CellPosition;

import java.awt.*;
import java.util.EventObject;

public class Humidity extends AbstractCharacteristic
{
    //Humidity
    public Humidity(GameField field, int val)
    {
        super(field, val);
    }

    @Override
    public Color drawColor() {
        return new Color(59,86,255,89);
    }

    @Override
    public String drawName() {
        return "�/" + value();
    }

    @Override
    public void update(EventObject event)
    {
        if(value()>0)
            setValue(value()-1);
    }

    public class HumidityDecreases implements RobotActionListener
    {
        @Override
        public void robotMadeMove(RobotActionEvent e)
        {
                update(e);
        }
    }

}
