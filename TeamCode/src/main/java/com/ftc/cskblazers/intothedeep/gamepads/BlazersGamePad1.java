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
            //System.out.println("Left Trigger");
            robot.extendInbound();
        }else if(gamepad.right_trigger>0){
            //System.out.println("Right Trigger");
            robot.compressInbound();
        }

    }

    @Override
    public void bumperOperation(BlazersRobot robot) {
        if(gamepad.right_bumper) {
            robot.inboundRotateClock();
            //System.out.println("Right Bumper Pressed");
        }else if(gamepad.left_bumper){
            robot.inboundRotateCounterclock();
            //System.out.println("Left Bumper Pressed");
        }
    }

    @Override
    public void buttonAPress(BlazersRobot robot) {
        if(gamepad.a) {
            robot.startPositions();
        }
    }

    @Override
    public void buttonBPress(BlazersRobot robot) {
        if(gamepad.b) {
            robot.openInboundClaw();
        }
    }

    @Override
    public void buttonXPress(BlazersRobot robot) {
        if(gamepad.x) {
            robot.closeInboundClaw();
        }
    }

    @Override
    public void buttonYPress(BlazersRobot robot) {
        if(gamepad.y) {
            robot.transfer();
        }
    }
}
