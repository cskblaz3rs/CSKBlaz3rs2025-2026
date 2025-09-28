package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawInbound {

    public static final double OPEN_SERVO = 0.6;
    public static final double CLOSE_SERVO = 0.995;
    private Servo clawInbound = null;
    private Servo clawAngleInbound = null;

    private Servo clawRotateInbound = null;

    boolean initFlag = true;

    public static String CLAW_SERVO_NAME = "inbound claw";
    public static String CLAWANGLE_SERVO_NAME = "inbound angle";
    public static String CLAWROTATE_SERVO_NAME = "inbound rotate";

    public ClawInbound(HardwareMap hardwareMap) {

        clawInbound = hardwareMap.get(Servo.class, CLAW_SERVO_NAME);
        clawAngleInbound = hardwareMap.get(Servo.class, CLAWANGLE_SERVO_NAME);
        clawRotateInbound = hardwareMap.get(Servo.class, CLAWROTATE_SERVO_NAME);
        //clawAngle.setPosition(0.0);
        //claw.setPosition(CLOSE_SERVO);
    }

    public void open() {
        //if(claw.getPosition()==CLOSE_SERVO) {
        //claw.setDirection(Servo.Direction.FORWARD);
        clawInbound.setPosition(OPEN_SERVO);
        //}
    }

    public boolean isOpen() {
        if (clawInbound.getPosition() == OPEN_SERVO) {
            return true;
        } else {
            return false;
        }
    }


    public void close() {
        //if(claw.getPosition()==OPEN_SERVO) {
        //claw.setDirection(Servo.Direction.REVERSE);
        clawInbound.setPosition(CLOSE_SERVO);
        //System.out.println("Claw Position: "+claw.getPosition());
        //}
    }


    public void rotateClock() {

        System.out.println("Claw Angle Position: " +clawAngleInbound.getPosition());
        // claw.setDirection(Servo.Direction.FORWARD);
        clawAngleInbound.setPosition(clawAngleInbound.getPosition() + 0.05);
        try{
            Thread.sleep(100);
        }catch(Exception e){

        }
    }
    public void rotateAntiClock() {

        System.out.println("Claw Angle Position: " +clawAngleInbound.getPosition());

        //claw.setDirection(Servo.Direction.FORWARD);
        clawAngleInbound.setPosition(clawAngleInbound.getPosition() - 0.05);
        try{
            Thread.sleep(100);
        }catch(Exception e){

        }
    }


    public void startPosition(){
        clawRotateInbound.setPosition(0.4);
        clawAngleInbound.setPosition(0.15);
        clawInbound.setPosition(CLOSE_SERVO);
    }
    public void transferInPosition(){
        clawAngleInbound.setPosition(0.7);
    }
    public void transferOutPosition(){
        clawInbound.setPosition(OPEN_SERVO);
    }

    public void resetPosition(){
        clawInbound.setPosition(OPEN_SERVO);
        clawAngleInbound.setPosition(1.7);
    }
    public void fullClose(){
        clawInbound.setPosition(1.0);
    }

    public void inboundRotateHorizontal(){
        System.out.println("Rotate Angle:"+clawRotateInbound.getPosition());
        clawRotateInbound.setPosition(0.4);
    }
    public void inboundRotateVertical(){
        System.out.println("Rotate Angle:"+clawRotateInbound.getPosition());
        clawRotateInbound.setPosition(0.8);
    }
    public Servo getClaw(){
        return clawInbound;
    }

}
