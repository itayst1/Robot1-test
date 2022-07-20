package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;

public class ReleaseCargo extends ParallelCommandGroup {

    private Shooter shooter;
    private Storage storage;

    public ReleaseCargo(Shooter shooter, Storage storage){
        this.shooter=shooter;
        this.storage=storage;
        addCommands(new Shoot(shooter), new Store(storage));
    }
}
