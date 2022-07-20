package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;

public class IntakeCargo extends SequentialCommandGroup {

    public Intake intake;
    public Storage storage;
    public Shooter shooter;

    public IntakeCargo(Intake intake, Storage storage, Shooter shooter) {
        this.intake = intake;
        this.storage = storage;
        this.shooter = shooter;
        addCommands(new ParallelCommandGroup(new Taker(intake), new Store(storage).withInterrupt(storage::getLimit)),
                new ParallelCommandGroup(new Taker(intake), new Shoot(shooter)).withInterrupt(shooter::getLimit));
    }
}
