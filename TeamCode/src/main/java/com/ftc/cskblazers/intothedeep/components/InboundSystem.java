package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

public class InboundSystem {

    private  Servo inboundServo   = null;

    private static String INBOUND_SERVO_NAME="inbound";



    public InboundSystem(HardwareMap hardwareMap){
        inboundServo = hardwareMap.get(Servo.class,INBOUND_SERVO_NAME );
        inboundServo.setDirection(Servo.Direction.REVERSE);

    }
    public void inboundForward(){
        System.out.println("Inbound pos:"+inboundServo.getPosition());
        if(inboundServo.getPosition()>0.25) {
            inboundServo.setPosition(inboundServo.getPosition() - 0.02);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }
    public void inboundBackward(){
        System.out.println("Inbound pos:"+inboundServo.getPosition());
        if(inboundServo.getPosition()<0.65) {
            inboundServo.setPosition(inboundServo.getPosition() + 0.02);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }
    public void startPosition(){
        inboundServo.setPosition(0.65);
    }
    public void transferPosition(){
        inboundServo.setPosition(0.45);
    }

    public void setPosition(double position){
        inboundServo.setPosition(position);
    }


}
