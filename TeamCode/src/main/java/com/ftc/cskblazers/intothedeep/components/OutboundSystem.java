package com.ftc.cskblazers.intothedeep.components;

//import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OutboundSystem {


    private DcMotor viperSlides    = null;
    //private  Container container = null;
   public  static final double NO_POWER   =  0.0;

    private static String VIPERSLLIDES_MOTOR_NAME="right slide";
    //private static String CONTAINER_SERVO_NAME="dropServo";


    public OutboundSystem(HardwareMap hardwareMap){
        viperSlides   = hardwareMap.get(DcMotor.class, VIPERSLLIDES_MOTOR_NAME);


        viperSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //viperSlides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //viperSlides.setDirection(DcMotor.Direction.REVERSE);
        viperSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //container.close();
        //Configure Drop Servo

    }

    public void move(int position, DcMotorSimple.Direction direction, double power){
        viperSlides.setTargetPosition(position);
        viperSlides.setDirection(direction);
        viperSlides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperSlides.setPower(power);
    }
    public void reset(){
        if(Math.abs(viperSlides.getCurrentPosition())>0){
            move(-20, DcMotorSimple.Direction.REVERSE, 0.3);
        }
    }
    public void stop(){
        if(!viperSlides.isBusy() ) {
            viperSlides.setPower(NO_POWER);
        }
    }

    public void lift(){
        if(Math.abs(viperSlides.getCurrentPosition())<4800) {
            move(viperSlides.getCurrentPosition()+200, DcMotorSimple.Direction.FORWARD,1.0);
        }
        System.out.println("Vipes Position Forward:"+viperSlides.getCurrentPosition());
    }
    public void drop(){
      if(Math.abs(viperSlides.getCurrentPosition())>199) {
            move(viperSlides.getCurrentPosition()-200, DcMotorSimple.Direction.FORWARD, 1.0);
       }
        System.out.println("Vipes Position Back:"+viperSlides.getCurrentPosition());

    }
    public void printTelemetry(Telemetry telemetry, String context){
        telemetry.addData(viperSlides.getDeviceName(), " - Position: %2d, Power:%.2f",  + viperSlides.getCurrentPosition() , viperSlides.getPower() );
        telemetry.update();
       // Log.i("Viper Slides State", "when " + context + " - Position:"+viperSlides.getCurrentPosition()+" Power:" +viperSlides.getPower());
        //Log.i("Drop Servo State " +container.getLever().getPortNumber(), "when " + context + " - Position:" + container.getLever().getPosition());
    }
    public void transferInPosition(){
        move(2800, DcMotorSimple.Direction.FORWARD,1.0);
    }
    public void resetInbound(){
        move(0, DcMotorSimple.Direction.FORWARD,1.0);
    }
    public void autoPickPosition(){
        move(2800, DcMotorSimple.Direction.FORWARD,1.0);
    }
//2950
    public void reInitialize() {
        viperSlides.setPower(0.0);
        viperSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

}
