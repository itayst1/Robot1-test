package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Storage;

public class Store extends CommandBase {

    public Storage store;

    public Store(Storage store){
        this.store=store;
    }

    @Override
    public void execute(){
        store.store();
    }

    @Override
    public void end(boolean interrupted){
        store.stop();
    }
}
