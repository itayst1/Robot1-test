package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class Taker extends CommandBase {

    private Intake intake;

    public Taker(Intake intake){
        this.intake=intake;
    }

    @Override
    public void execute() {
        intake.collect();
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }
}
