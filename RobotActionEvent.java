package brokenrobotgame.model.events;

import java.util.EventObject;

/*
 * �������, ��������� � ����� ������������� ������
 */
public class RobotActionEvent extends EventObject {
    public RobotActionEvent(Object source) { 
        super(source); 
    } 

    public void newAction(){doSmth();}

    public int doSmth(){return 3;}
} 
