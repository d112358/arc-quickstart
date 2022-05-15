package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
public class BasicMecanumDrive extends SubsystemBase{
    private MecanumDrive drive;
    private Motor fL,fR,bL,bR;
    public BasicMecanumDrive(Motor fL, Motor fR, Motor bL, Motor bR) {
        //Initiates motors and drive
        this.fL = fL;
        this.fR = fR;
        this.bL = bL;
        this.bR = bR;
        drive = new MecanumDrive(fL,fR,bL,bR);
    }
    public void run(double strafeSpeed,double forwardSpeed,double turn){
        //Moves robot based on parameters
        drive.driveRobotCentric(strafeSpeed, forwardSpeed, turn);
    }
}