package com.ftc.cskblazers.intothedeep.gamepads;

import com.qualcomm.robotcore.hardware.Gamepad;

import com.ftc.cskblazers.intothedeep.BlazersRobot;

public class BlazersGamePad1 implements BlazersGamePad{
    private Gamepad gamepad;
    //change
    public BlazersGamePad1(Gamepad gamepad){
        init(gamepad);
    }
    @Override
    public void init(Gamepad gamepad) {
        this.gamepad=gamepad;
    }

    @Override
    public void stickOperation(BlazersRobot robot) {
        //robot.drive(gamepad.left_stick_y,gamepad.left_stick_x, gamepad.right_stick_x);

        // Check the motor connections properly. The above line should work, I inverse these parameters for now to work.
        robot.drive(gamepad.left_stick_y,gamepad.left_stick_x, gamepad.right_stick_x);
    }

    @Override
    public void triggerOperation(BlazersRobot robot) {
        if(gamepad.left_trigger>0){
            robot.intakeForward();
            //System.out.println("Left Trigger");
        }else if(gamepad.right_trigger>0){
            robot.shoot();
            //System.out.println("Right Trigger");
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
        if(gamepad.x) {

        }
    }

    @Override
    public void buttonYPress(BlazersRobot robot) {
        if(gamepad.y) {

        }
    }
}
