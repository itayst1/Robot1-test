package frc.robot;

public class RobotMap {

    public interface CAN{

        int DRIVETRAIN_LEFT_TALON_1=1;
        int DRIVETRAIN_LEFT_TALON_2=3;
        int DRIVETRAIN_RIGHT_TALON_1=2;
        int DRIVETRAIN_RIGHT_TALON_2=4;

        int SHOOTER_VICTOR_1=-1;
        int SHOOTER_VICTOR_2=-1;

        int INTAKE_VICTOR=-1;

        int STORAGE_VICTOR=-1;

    }

    public interface DIO{

        int SHOOTER_LIMIT=-1;

        int STORAGE_LIMIT=-1;
    }

}
