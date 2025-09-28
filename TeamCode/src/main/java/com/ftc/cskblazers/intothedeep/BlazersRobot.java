package com.ftc.cskblazers.intothedeep;

import android.drm.DrmStore;

import com.ftc.cskblazers.intothedeep.components.ClawInbound;
import com.ftc.cskblazers.intothedeep.components.ClawOutbound;
import com.ftc.cskblazers.intothedeep.components.Hanger;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.ftc.cskblazers.intothedeep.components.DriveTrain;
import com.ftc.cskblazers.intothedeep.components.InboundSystem;
import com.ftc.cskblazers.intothedeep.components.OutboundSystem;
import com.ftc.cskblazers.intothedeep.components.Vision;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.Servo;

public class BlazersRobot {

    private DriveTrain driveTrain=null;
    private InboundSystem inBoundSystem  = null;


    private ClawInbound clawinbound=null;

    private ClawOutbound clawoutbound= null;
    //private Vision vision;

    private Hanger hanger;

    Telemetry telemetry;


    public BlazersRobot(HardwareMap hardwareMap){

        driveTrain = new DriveTrain(hardwareMap);
        inBoundSystem = new InboundSystem(hardwareMap);
        hanger = new Hanger(hardwareMap);
        //vision=new Vision(hardwareMap);
        clawinbound = new ClawInbound(hardwareMap);
        clawoutbound = new ClawOutbound(hardwareMap);

    }
    public void specimenPick(){
        clawoutbound.clawSpecimenPick();
    }
    public void specimenOutboundHookPosition(){
        clawoutbound.hookSpecimen();
    }
    public void startPositions(){
        clawoutbound.specimenPickUpPosition();
        clawinbound.startPosition();
        inBoundSystem.startPosition();
        hanger.lift();
    }
    public void inboundFullClose(){
        clawinbound.fullClose();
    }
    public void adjustedStartPositions(){
        //clawoutbound.specimenPickUpPosition();
        clawinbound.startPosition();
        inBoundSystem.startPosition();
        hanger.lift();
    }
    public void clawInboundPositionStart(){
        clawinbound.startPosition();
    }
    public void inboundSetPosition(double position){
        inBoundSystem.setPosition(position);
    }
    public void specimenPauseHang(){
        clawoutbound.specimenHang1Position();
        sleep(300);
        clawoutbound.specimenHang2Position();
    }
    public void hangInitial(){
        hanger.initialPosition();
    }
    public void sleep(int time){
        try{
            Thread.sleep(time);
        }catch(Exception e){

        }
    }
    public void dropPosition(){
        clawoutbound.clawTransferOutPosition();
        sleep(100);
        clawoutbound.clawAngleTransferOutPosition();
        sleep(100);
        hanger.transferOutSystem();
    }
    public void outboundToTop(){
        hanger.transferOutSystem();
    }
    public void specimenHangPosition(){
        hanger.specimenHangPosition();
    }
    public void transfer(){
        inBoundSystem.setPosition(0.3);
        clawoutbound.transferInPosition();
        clawinbound.transferInPosition();
        sleep(1300);
        inBoundSystem.transferPosition();
        sleep(700);
        clawoutbound.clawTransferOutPosition();
        sleep(700);
        clawinbound.transferOutPosition();
        sleep(1000);
        clawoutbound.clawAngleTransferOutPosition();
        sleep(1000);
        clawinbound.close();
        sleep(700);
        clawinbound.startPosition();
        sleep(700);
        inBoundSystem.startPosition();



    }

    public void inboundClawUp(){
        clawinbound.transferInPosition();
    }
    public void inboundClawDown(){
        clawinbound.startPosition();
    }
    public void lowerTransfer(){
        clawoutbound.transferInPosition();
        sleep(500);
        clawinbound.transferInPosition();
        sleep(1000);
        clawoutbound.clawTransferOutPosition();
        sleep(1000);
        clawinbound.transferOutPosition();
        sleep(1000);
        clawoutbound.clawAngleTransferOutPosition();
        sleep(500);
        hanger.specimenHangPosition();
        System.out.println("Complete");
        sleep(500);
        clawinbound.resetPosition();
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


    //public void senseColor(){
       // vision.getColor();
    //}



    public void extendInbound(){
        inBoundSystem.inboundForward();
    }
    public void compressInbound(){
        inBoundSystem.inboundBackward();
    }


    public void openInboundClaw(){
        clawinbound.open();
    }
    public void outboundSpecimenPick(){
        clawoutbound.specimenPickUpPosition();
    }
    public void outboundSpecimenDrop(){
        clawoutbound.specimenHangPosition();
    }
    public void closeInboundClaw(){
        clawinbound.close();
    }
    public void openOutboundClaw(){
        clawoutbound.open();;
    }
    public void closeOutboundClaw(){
        clawoutbound.close();
    }
    public void closeOutboundClawFull(){
        clawoutbound.fullCloseClaw();
    }
    public void rotateOutboundClawForward(){
        clawoutbound.rotateOutboundClock();
    }
    public void rotateOutboundClawBackward(){
        clawoutbound.rotateOutboundAntiClock();
    }

    public void rotateClawForward(){
        clawinbound.rotateClock();;
    }
    public void rotateClawBackward(){
        clawinbound.rotateAntiClock();
    }

    public void setHangPosition(int position){
        hanger.hangSetPosition(position);
    }
    public void looseOutboundClawGrip(){
        clawoutbound.loosenClawGrip();
    }
    public void inboundRotateClock(){
        clawinbound.inboundRotateHorizontal();
    }
    public void inboundRotateCounterclock(){
        clawinbound.inboundRotateVertical();
    }

    public void moveHangerUp(){
        hanger.moveUp();
    }
    public void moveHangerDown(){
        hanger.moveDown();
    }
    public void liftMe(){
        hanger.lift();
    }
    public void liftForward(){
        hanger.forwardLift();
    }
    public Servo getClawServo(){
        return clawinbound.getClaw();
    }
    public void moveOutbound(int position, DcMotorSimple.Direction direction, double power){
        //outboundSystem.move(position,direction,power);
    }
    public void printPositions(){
        driveTrain.printPositions();
    }
    public void inboundAutoPickPosition(){
        //outboundSystem.autoPickPosition();
    }
    public void Outbound2SpinUp(){
        clawoutbound.clawAngle2MoveUP();
    }
    public void Outbound2SpinDown(){
        clawoutbound.clawAngle2MoveDOWN();
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
