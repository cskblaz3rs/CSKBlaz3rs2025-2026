package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawOutbound {
    public static final double CLOSE_SERVO   =  0.47;
    public  static final double OPEN_SERVO   =  0.9;
    boolean initFlag = true;
    private Servo clawOutbound     = null;
    private Servo clawAngle1Outbound     = null;
    private Servo clawAngle2Outbound     = null;

    public static String CLAW_OUTBOUND_SERVO_NAME="claw outbound";
    public static String CLAWANGLE1_OUTBOUND_SERVO_NAME="claw angle1 outbound";

    public static String CLAWANGLE2_OUTBOUND_SERVO_NAME="claw angle2 outbound";

    public ClawOutbound(HardwareMap hardwareMap){

        clawOutbound = hardwareMap.get(Servo.class, CLAW_OUTBOUND_SERVO_NAME);
        clawOutbound.setDirection(Servo.Direction.FORWARD);
        clawAngle1Outbound = hardwareMap.get(Servo.class, CLAWANGLE1_OUTBOUND_SERVO_NAME);
        clawAngle1Outbound.setDirection(Servo.Direction.FORWARD);
        clawAngle2Outbound = hardwareMap.get(Servo.class, CLAWANGLE2_OUTBOUND_SERVO_NAME);
        clawAngle2Outbound.setDirection(Servo.Direction.REVERSE);
        //clawAngle.setPosition(0.0);
        //claw.setPosition(CLOSE_SERVO);
    }
    public void open(){
        //if(claw.getPosition()==CLOSE_SERVO) {
        //claw.setDirection(Servo.Direction.FORWARD);
        clawOutbound.setPosition(OPEN_SERVO);
        //}
    }

    public boolean isOpen(){
        if(clawOutbound.getPosition()==OPEN_SERVO) {
            return true;
        }else {
            return false;
        }
    }


    public void close(){
        //if(claw.getPosition()==OPEN_SERVO) {
        //claw.setDirection(Servo.Direction.REVERSE);
        clawOutbound.setPosition(CLOSE_SERVO);
        //System.out.println("Claw Position: "+claw.getPosition());
        //}
    }
    public void fullCloseClaw(){
        clawOutbound.setPosition(0.95);
    }


    public void rotateOutboundClock() {
        System.out.println("Claw Angle Position: " +clawAngle1Outbound.getPosition());
        // claw.setDirection(Servo.Direction.FORWARD);
        clawAngle1Outbound.setPosition(clawAngle1Outbound.getPosition() + 0.05);
        try{
            Thread.sleep(100);
        }catch(Exception e){

        }
    }
    public void rotateOutboundAntiClock() {
        System.out.println("Claw Angle Position: " +clawAngle1Outbound.getPosition());

        //claw.setDirection(Servo.Direction.FORWARD);
        clawAngle1Outbound.setPosition(clawAngle1Outbound.getPosition() - 0.05);
        try{
            Thread.sleep(100);
        }catch(Exception e){

        }
    }
    public void startPosition(){
        clawOutbound.setPosition(1.0);
        //clawAngle1Outbound.setPosition(0.0);
        clawAngle2Outbound.setPosition(0.0);
    }

    public void hookSpecimen(){
        clawAngle1Outbound.setPosition(0.7);
    }




    public void transferInPosition(){
        clawOutbound.setPosition(OPEN_SERVO);
        clawAngle1Outbound.setPosition(0.85);
    }
    public void clawTransferOutPosition(){
        clawOutbound.setPosition(CLOSE_SERVO);
    }
    public void clawAngleTransferOutPosition(){
        clawAngle1Outbound.setPosition(0.4);

    }
    public void clawSpecimenPick(){
        clawAngle1Outbound.setPosition(0.35);
    }
    //0.15
    public Servo getClaw(){
        return clawOutbound;
    }
    public void specimenPickUpPosition(){
        clawAngle2Outbound.setPosition(1.0);
        clawAngle1Outbound.setPosition(0.19);
    }
    public void specimenHangPosition() {
        clawAngle1Outbound.setPosition(0.6);
        clawAngle2Outbound.setPosition(0.8);
    }
    public void specimenHang1Position() {
        clawAngle1Outbound.setPosition(0.65);
    }
    public void specimenHang2Position(){
        clawAngle2Outbound.setPosition(0.77);
    }
    public void clawAngle2MoveUP(){
        clawAngle2Outbound.setPosition(0.0);
    }
    public void clawAngle2MoveDOWN(){
        clawAngle2Outbound.setPosition(1.0);
    }
    public void loosenClawGrip(){
        clawOutbound.setPosition(0.59);
    }
}


