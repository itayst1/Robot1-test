package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private final WPI_VictorSPX one;
    private final WPI_VictorSPX two;
    private final DigitalInput limit;

    public Shooter(WPI_VictorSPX one, WPI_VictorSPX two, DigitalInput limit) {
        this.one = one;
        this.two=two;
        this.limit=limit;

        two.follow(one);
    }

    public void shoot(){
        one.set(0.5);
    }

    public void stop(){
        one.stopMotor();
    }

    public boolean getLimit(){
        return limit.get();
    }

}
