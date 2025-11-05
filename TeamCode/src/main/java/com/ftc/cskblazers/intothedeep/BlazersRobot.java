package com.ftc.cskblazers.intothedeep;

import com.ftc.cskblazers.intothedeep.components.Intake;
import com.ftc.cskblazers.intothedeep.components.Launch;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.ftc.cskblazers.intothedeep.components.DriveTrain;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.Servo;

public class BlazersRobot {

    private DriveTrain driveTrain=null;
    private Intake intake=null;
    private Launch launch=null;

    Telemetry telemetry;


    public BlazersRobot(HardwareMap hardwareMap){

        driveTrain = new DriveTrain(hardwareMap);
        intake = new Intake(hardwareMap);
        launch = new Launch(hardwareMap);

    }

   public void stop(){

       driveTrain.stop();
    }
    public void move(double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed){

        driveTrain.move(frontLeftSpeed,frontRightSpeed,backLeftSpeed,backRightSpeed);

    }
    public void drive(double verticalPosition, double horizontalPosition, double pivot){

        driveTrain.run(verticalPosition,horizontalPosition,pivot);

   }

    public void drive(double verticalPosition, double horizontalPosition, double pivot, double speed){

        driveTrain.run(verticalPosition,horizontalPosition,pivot,speed);

    }
   public void setReverse(){
        driveTrain.setReverse();
   }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void intakeForward(){
        intake.intakeIn();
    }
    public void intakeBackward(){
        intake.intakeOut();
    }
    public void shoot(){
        launch.shootForward();
    }
    public void stopShoot(){
        launch.shootStop();
    }
    public void stopIntake(){
        intake.stopIntake();
    }
    public void shootBackward(){
        launch.shootBackward();
    }
    public void releaseArtifact(){
        intake.releaseArtifact();
    }
    public void holdArtifact(){
        intake.holdArtifact();
    }







    public void printPositions(){
        driveTrain.printPositions();
    }


    public float getRobotForwardPosition(){
        return driveTrain.getForwardPosition();
    }
    public float getRobotSidePosition(){
       return driveTrain.getSidePosition();
    }
    public void resetDriveTrainEncoders(){
        driveTrain.resetEncoders();
    }




}
