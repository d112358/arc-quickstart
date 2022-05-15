package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.commands.BasicMecanumDriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.BasicMecanumDrive;

@TeleOp
public class BasicTeleOp extends CommandOpMode {
    private Motor fL,fR,bL,bR;
    private BasicMecanumDrive drive;
    private BasicMecanumDriveCommand driveC;
    private GamepadEx controller;
    @Override
    public void initialize() {
        //initiate motors
        fL=new Motor(hardwareMap,"frontLeft");
        fR=new Motor(hardwareMap,"frontRight");
        bR=new Motor(hardwareMap,"backRight");
        bL=new Motor(hardwareMap,"backLeft");
        //set the running mode for motors
        fL.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fR.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bR.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bL.motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //set the direction for motors
        fL.motor.setDirection(DcMotor.Direction.FORWARD);
        fR.motor.setDirection(DcMotor.Direction.FORWARD);
        bR.motor.setDirection(DcMotor.Direction.FORWARD);
        bL.motor.setDirection(DcMotor.Direction.FORWARD);
        //initialize drive subsystem and drive command
        drive = new BasicMecanumDrive(fL,fR,bL,bR);
        driveC=new BasicMecanumDriveCommand(drive,controller::getLeftX,controller::getLeftY,controller::getRightX);
        //register the subsystem and set the command as the default for the drive subsystem
        register(drive);
        drive.setDefaultCommand(driveC);
    }
}
