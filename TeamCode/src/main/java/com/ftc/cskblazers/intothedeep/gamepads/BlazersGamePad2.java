package com.ftc.cskblazers.intothedeep.gamepads;

import com.qualcomm.robotcore.hardware.Gamepad;

import com.ftc.cskblazers.intothedeep.BlazersRobot;

public  class BlazersGamePad2 implements BlazersGamePad{

    private  Gamepad gamepad;
    private boolean shootOn=false;

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

        if(gamepad.right_trigger>0) {

        } else if (gamepad.right_trigger<=0) {

        }
        if(gamepad.left_trigger>0){
            robot.shootBackward();
        } else if(gamepad.left_trigger<=0){
            robot.stopShoot();
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
            shootOn=true;
        }
        if(shootOn) {
            robot.shoot();

        }

    }

    @Override
    public void buttonBPress(BlazersRobot robot) {
        if(gamepad.b) {
            shootOn=false;
        }
        if(!shootOn) {
            robot.stopShoot();

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
