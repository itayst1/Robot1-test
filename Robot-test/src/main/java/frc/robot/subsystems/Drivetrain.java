package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    private final WPI_TalonSRX right1;
    private final WPI_TalonSRX right2;
    private final WPI_TalonSRX left1;
    private final WPI_TalonSRX left2;

    public Drivetrain(WPI_TalonSRX right1, WPI_TalonSRX right2, WPI_TalonSRX left1, WPI_TalonSRX left2){
        this.right1=right1;
        this.right2=right2;
        this.left1=left1;
        this.left2=left2;

        left2.follow(left1);
        right2.follow(right1);

        right1.setInverted(true);
        right2.setInverted(true);
    }

    public void driveForward(double left, double right){
        left1.set(left);
        right1.set(right);
    }

    public void stop(){
        left1.stopMotor();
        right1.stopMotor();
    }

}
