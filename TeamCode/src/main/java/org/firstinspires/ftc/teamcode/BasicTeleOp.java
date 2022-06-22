package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.StartEndCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.commands.BasicMecanumDriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.BasicMecanumDrive;

@TeleOp
public class BasicTeleOp extends CommandOpMode {
    private Motor fL,fR,bL,bR;
    private SimpleServo servo;
    private Motor intakeMotor;
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
        intakeMotor = new Motor(hardwareMap,"intakeMotor");
        servo = new SimpleServo(hardwareMap,"servo",-180,180, AngleUnit.DEGREES);
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
        controller.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenHeld(new StartEndCommand(()->{intakeMotor.set(-0.5);},()->{intakeMotor.set(0.0);}));
        controller.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(new StartEndCommand(()->{intakeMotor.set(0.5);},()->{intakeMotor.set(0.0);}));
        controller.getGamepadButton(GamepadKeys.Button.A).toggleWhenPressed(
                new InstantCommand(()->{servo.setPosition(0.75);}),
                new InstantCommand(()->{servo.setPosition(0);})
        );
    }
}
