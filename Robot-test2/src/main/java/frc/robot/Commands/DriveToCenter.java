package frc.robot.Commands;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Vision;
import frc.robot.SubSystems.Chassis;
import frc.robot.SubSystems.Constants;
import frc.robot.SubSystems.Constants.Speeds;

public class DriveToCenter extends CommandBase {

    private Vision v;
    private static DriveToCenter m_instance;

    private double error,lastError=0,integral,d,target, speed=0, distanceTol=0, speedTol=0;

    public DriveToCenter(double d, double s){
        addRequirements(Chassis.getInstance());
        v=new Vision(7112); 
        distanceTol=d;
        speedTol=s;
        this.target = 3;
    }

    // public static DriveToCenter getInstance(){
    //     if(m_instance==null){
    //         m_instance=new DriveToCenter();
    //     }
    //     return m_instance;
    // }
    

    @Override
    public void execute() {
        error = target - v.getXYZ()[2];
        if(Math.abs(v.getXYZ()[2]) > 10){
            return;
        }
        d=lastError-error;
        speed=error*Constants.PID.VELOCITY_KP+integral*Constants.PID.VELOCITY_KI-d*Constants.PID.VELOCITY_KD;
        if(Math.abs(speed) >= 0.6){
            return;
        }
        Chassis.getInstance().driveStraight(speed*1.6);
        SmartDashboard.putNumber("speed", speed);
        SmartDashboard.putNumber("distance", v.getXYZ()[2]);
        SmartDashboard.putNumber("error", error);
        integral+=error;
        SmartDashboard.putNumber("integral", integral);
        lastError=error;
    }

    @Override
    public boolean isFinished() {
        return(Math.abs(v.getXYZ()[2]-target) <= 0.1 && speed < 0.05);
    }

    @Override
    public void end(boolean interrupted) {
        Chassis.getInstance().stop();
    }
}
