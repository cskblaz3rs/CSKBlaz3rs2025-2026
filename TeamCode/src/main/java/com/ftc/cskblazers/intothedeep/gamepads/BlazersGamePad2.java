package com.ftc.cskblazers.intothedeep.gamepads;

import com.qualcomm.robotcore.hardware.Gamepad;

import com.ftc.cskblazers.intothedeep.BlazersRobot;

public  class BlazersGamePad2 implements BlazersGamePad{

    private  Gamepad gamepad;

    public BlazersGamePad2(Gamepad gamepad){
        init(gamepad);
    }
    @Override
    public void init(Gamepad gamepad) {
        this.gamepad=gamepad;
    }

    @Override
    public void stickOperation(BlazersRobot robot) {
        if (gamepad.dpad_up){

        }
        if (gamepad.dpad_down){

        }
        if (gamepad.dpad_left){
        }
        if (gamepad.dpad_right){

        }


    }

    @Override
    public void triggerOperation(BlazersRobot robot) {

        if(gamepad.right_trigger>0){
            robot.shootBackward();
           // robot.printOutboundTelemetry("Left Trigger");
        }else if(gamepad.left_trigger>0){
            robot.intakeBackward();
            //robot.printOutboundTelemetry("Right Trigger");
        }else{
            if(!gamepad.a) {
               // robot.stopViperSlides();
            }
        }
    }

    @Override
    public void bumperOperation(BlazersRobot robot) {


        if(gamepad.right_bumper) {

            //System.out.println("Right Bumper Pressed");
        }else if(gamepad.left_bumper){
            //System.out.println("Left Bumper Pressed");

        }
    }
    //change
    @Override
    public void buttonAPress(BlazersRobot robot) {
        if(gamepad.a) {

        }

    }

    @Override
    public void buttonBPress(BlazersRobot robot) {
        if(gamepad.b) {

        }
    }

    @Override
    public void buttonXPress(BlazersRobot robot) {
        if (gamepad.x){

        }
    }

    @Override
    public void buttonYPress(BlazersRobot robot) {
        if(gamepad.y) {

        }
    }
}
