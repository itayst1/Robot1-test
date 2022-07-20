package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveForward extends CommandBase {

    private Drivetrain d;

    public DriveForward(Drivetrain d) {
        this.d = d;
        addRequirements(d);
    }

    @Override
    public void execute() {
        d.driveForward(0.5, 0.5);
    }

    @Override
    public void end(boolean interrupted) {
        d.stop();
    }
}