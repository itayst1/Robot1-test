package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private final WPI_VictorSPX one;

    public Intake(WPI_VictorSPX one){
        this.one=one;
    }

    public void collect(){
        one.set(0.5);
    }

    public void stop(){
        one.stopMotor();
    }

}
