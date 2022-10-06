package frc.robot.Commands;

import edu.wpi.first.math.Vector;
import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Vision;
import frc.robot.Constants;
import frc.robot.Constants.Speeds;
import frc.robot.SubSystems.Chassis;

public class DriveToCenter extends CommandBase {

    private Vision v;
    private static DriveToCenter m_instance;

    private double error,lastError=0,integral,d,target, speed=0, distanceTol=0, speedTol=0;

    public DriveToCenter(double d, double s){
        addRequirements(Chassis.getInstance());
        v=new Vision(7112); 
        distanceTol=d;
        speedTol=s;
        this.target = 4;
    }

    public Vector2d correctX(double s){
        Vector2d vec=new Vector2d(v.getXYZ()[0]+s, s);
        vec.x/=(vec.magnitude());
        vec.y/=(vec.magnitude());
        vec.x*=s;
        return vec;
    }
    

    @Override
    public void execute() {
        error = target - v.getXYZ()[2];
        if(Math.abs(v.getXYZ()[2]) > 10){
            return;
        }
        d=lastError-error;
        speed=error*Constants.PID.VELOCITY_KP+integral*Constants.PID.VELOCITY_KI-d*Constants.PID.VELOCITY_KD;
        if(Math.abs(speed) >= 0.3){
            return;
        }
        // Vector2d vec=correctX(speed);
        Chassis.getInstance().driveTank(speed, speed);
        SmartDashboard.putNumber("speed", speed);
        SmartDashboard.putNumber("distance", v.getXYZ()[2]);
        SmartDashboard.putNumber("error", error);
        integral+=error;
        SmartDashboard.putNumber("integral", integral);
        lastError=error;
    }

    @Override
    public boolean isFinished() {
        return(Math.abs(v.getXYZ()[2]-target) <= distanceTol && speed < speedTol);
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }
}
