
package com.ftc.cskblazers.intothedeep.components;

//import android.util.Log;

        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.HardwareMap;
        import com.qualcomm.robotcore.hardware.Servo;

        import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Hanger {


    private DcMotor viperSlides    = null;
    //private  Container container = null;
    public  static final double NO_POWER   =  0.0;

    private static String VIPERSLLIDES_MOTOR_NAME="hang motor";
    //private static String CONTAINER_SERVO_NAME="dropServo";


    public Hanger(HardwareMap hardwareMap){
        viperSlides   = hardwareMap.get(DcMotor.class, VIPERSLLIDES_MOTOR_NAME);


        viperSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //viperSlides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //viperSlides.setDirection(DcMotor.Direction.REVERSE);
        viperSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //container.close();
        //Configure Drop Servo

    }

    private void move(int position, DcMotorSimple.Direction direction, double power){
        viperSlides.setTargetPosition(position);
        viperSlides.setDirection(direction);
        viperSlides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        viperSlides.setPower(power);
    }
    public void reset(){
        if(Math.abs(viperSlides.getCurrentPosition())>50){
            move(-20, DcMotorSimple.Direction.REVERSE, 1.0);
        }
    }
    public void stop(){
        if(!viperSlides.isBusy() ) {
            viperSlides.setPower(NO_POWER);
        }
    }

    public void moveUp(){
        if(viperSlides.getCurrentPosition()<7950) {
            move(viperSlides.getCurrentPosition()+150, DcMotorSimple.Direction.REVERSE,1.0);
        }
        System.out.println("Hanger Position:"+viperSlides.getCurrentPosition());
    }
    public void lift(){
        //viperSlides.setPower(NO_POWER);
        move(50, DcMotorSimple.Direction.REVERSE, 2.0);
      /*if(Math.abs(viperSlides.getCurrentPosition())>100) {
            move(-(Math.abs(viperSlides.getCurrentPosition())-50), DcMotorSimple.Direction.REVERSE, 1.0);
            System.out.println("Vipes Position:"+viperSlides.getCurrentPosition());
       }*/
    }

    public void forwardLift(){
        //viperSlides.setPower(NO_POWER);
        move(50, DcMotorSimple.Direction.FORWARD, 2.0);
      /*if(Math.abs(viperSlides.getCurrentPosition())>100) {
            move(-(Math.abs(viperSlides.getCurrentPosition())-50), DcMotorSimple.Direction.REVERSE, 1.0);
            System.out.println("Vipes Position:"+viperSlides.getCurrentPosition());
       }*/
    }
    public void moveDown(){
        if(Math.abs(viperSlides.getCurrentPosition())>150) {
            move(viperSlides.getCurrentPosition()-150, DcMotorSimple.Direction.REVERSE,1.0);
        }
        System.out.println("Hanger Position:"+viperSlides.getCurrentPosition());
    }
    public void printTelemetry(Telemetry telemetry, String context){
        telemetry.addData(viperSlides.getDeviceName(), " - Position: %2d, Power:%.2f",  + viperSlides.getCurrentPosition() , viperSlides.getPower() );
        telemetry.update();
        // Log.i("Viper Slides State", "when " + context + " - Position:"+viperSlides.getCurrentPosition()+" Power:" +viperSlides.getPower());
        //Log.i("Drop Servo State " +container.getLever().getPortNumber(), "when " + context + " - Position:" + container.getLever().getPosition());
    }
    public void reInitialize() {
        viperSlides.setPower(0.0);
        viperSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void transferOutSystem(){
        move(7950, DcMotorSimple.Direction.REVERSE,2.0);
        System.out.println("Transfer Hanger Position:"+viperSlides.getCurrentPosition());
    }
    public void hangSetPosition(int position){
        move(position,DcMotorSimple.Direction.REVERSE,1.0);
        System.out.println("Specimen Hanger Position:"+viperSlides.getCurrentPosition());
    }
    public void specimenHangPosition(){
        move(3300,DcMotorSimple.Direction.REVERSE,1.0);
        System.out.println("Specimen Hanger Position:"+viperSlides.getCurrentPosition());
    }
    public void initialPosition(){
        move(1000,DcMotorSimple.Direction.REVERSE,1.0);
        System.out.println("Initial Hanger Position:"+viperSlides.getCurrentPosition());
    }

}

