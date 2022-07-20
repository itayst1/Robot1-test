package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Storage extends SubsystemBase {

    public final WPI_VictorSPX one;
    public final DigitalInput limit;


    public Storage(WPI_VictorSPX one, DigitalInput limit) {
        this.one = one;
        this.limit=limit;
    }

    public void store(){
        one.set(0.5);
    }

    public void stop(){
        one.stopMotor();
    }

    public boolean getLimit(){
        return limit.get();
    }
}
