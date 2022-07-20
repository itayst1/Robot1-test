package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Shoot extends CommandBase {

    private Shooter s1;

    public Shoot(Shooter s1){
        this.s1=s1;
    }

    @Override
    public void execute(){
        s1.shoot();
    }

    @Override
    public void end(boolean interrupted) {
        s1.stop();
    }
}
