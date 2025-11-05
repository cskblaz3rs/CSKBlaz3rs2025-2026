package com.ftc.cskblazers.intothedeep.components;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Launch {
    private DcMotor launch = null;
    public static final double NO_POWER = 0.0;

    private static String LAUNCH_MOTOR_NAME = "launcher";


    public Launch(HardwareMap hardwareMap) {
        launch = hardwareMap.get(DcMotor.class, LAUNCH_MOTOR_NAME);
    }

    public void shootForward (){
        launch.setDirection(DcMotorSimple.Direction.REVERSE);
        launch.setPower(0.7);

    }
    public void shootStop(){
        launch.setPower(0.0);

    }
    public void shootBackward(){
        launch.setDirection(DcMotorSimple.Direction.FORWARD);
        launch.setPower(1.0);
    }

}
