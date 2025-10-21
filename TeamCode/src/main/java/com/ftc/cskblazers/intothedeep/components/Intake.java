package com.ftc.cskblazers.intothedeep.components;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private Servo intake1 = null;
    private Servo intake2= null;
    public static String INTAKE1_SERVO_NAME = "intake1";
    public static String INTAKE2_SERVO_NAME = "intake2";
    public Intake(HardwareMap hardwareMap) {

        intake1 = hardwareMap.get(Servo.class, INTAKE1_SERVO_NAME);
        intake2 = hardwareMap.get(Servo.class, INTAKE2_SERVO_NAME);
    }
    public void intakeIn(){
        intake1.setDirection(Servo.Direction.FORWARD);
        intake1.setPosition(1.0);
        intake2.setDirection(Servo.Direction.FORWARD);
        intake2.setPosition(1.0);
    }
    public void intakeOut(){
        intake1.setDirection(Servo.Direction.REVERSE);
        intake1.setPosition(-1.0);
        intake2.setDirection(Servo.Direction.REVERSE);
        intake2.setPosition(-1.0);
    }


}
