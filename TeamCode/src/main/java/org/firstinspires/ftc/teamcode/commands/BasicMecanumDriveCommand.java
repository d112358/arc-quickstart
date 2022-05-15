package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.BasicMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.rr.MecanumDriveSubsystem;

import java.util.function.DoubleSupplier;

public class BasicMecanumDriveCommand extends CommandBase{
    private final BasicMecanumDrive drive;
    private final DoubleSupplier leftY, leftX, rightX;

    public BasicMecanumDriveCommand(BasicMecanumDrive drive, DoubleSupplier leftY,
                               DoubleSupplier leftX, DoubleSupplier rightX) {
        //initializes drive and other variables
        this.drive = drive;
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;

        addRequirements(drive);
    }
    //executes the drive subsystem
    @Override
    public void execute() {
        drive.run(leftY.getAsDouble(), leftX.getAsDouble(), rightX.getAsDouble());
    }
}