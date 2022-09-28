package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.SubSystems.Constants;

public class Controls {
    
    public static Joystick m_leftJoystick=new Joystick(Constants.JoystickPorts.leftJoystick);
    public static Joystick m_rightJoystick=new Joystick(Constants.JoystickPorts.rightJoystick);

}
