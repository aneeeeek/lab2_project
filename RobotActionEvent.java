package brokenrobotgame.model.events;

import java.util.EventObject;

/*Create new action*/

/*Add doSmth*/

/*
 * —обытие, св€занное с любой де€тельностью робота
 */
public class RobotActionEvent extends EventObject {
    public RobotActionEvent(Object source) { 
        super(source); 
    } 

    public newAction(){doSmth();}
} 
