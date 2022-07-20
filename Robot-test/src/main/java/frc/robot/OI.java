package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveForward;
import frc.robot.commands.IntakeCargo;
import frc.robot.commands.ReleaseCargo;
import frc.robot.commands.Rotate;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;

public class OI {

    private final XboxController xbox = new XboxController(0);

    public OI(Drivetrain d, Intake intake, Storage storage, Shooter shooter) {
        JoystickButton b = new JoystickButton(xbox, XboxController.Button.kB.value);
        JoystickButton x = new JoystickButton(xbox, XboxController.Button.kX.value);
        JoystickButton a = new JoystickButton(xbox, XboxController.Button.kA.value);
        JoystickButton rb = new JoystickButton(xbox, XboxController.Button.kRightBumper.value);

        b.whenPressed(new DriveForward(d).withTimeout(0.5));
        x.whenPressed(new Rotate(d).withTimeout(2));
        a.whenPressed(new IntakeCargo(intake, storage, shooter).withTimeout(3));
        rb.whileHeld(new ReleaseCargo(shooter, storage));
    }

}
