package org.firstinspires.ftc.teamcode.drive;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MecanumDriveOpMode extends OpMode{
    //These are the motors for the drive
    private Motor fL,fR,bL,bR;
    private MecanumDrive drive;
    private GamepadEx controller;
    @Override
    public void init(){
        //Instantiates drive and the controller
        drive = new MecanumDrive(fL,fR,bL,bR);
        controller = new GamepadEx(gamepad1);
    }
    @Override
    public void loop() {
        /*This is sets up drive controllers. The parameters for driveRobotCentric method are (strafeSpeed,forwardSpeed,turn)*/
        drive.driveRobotCentric(controller.getLeftX(),controller.getLeftY(),controller.getRightX());
    }
}
