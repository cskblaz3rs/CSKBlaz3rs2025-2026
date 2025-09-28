/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.ftc.cskblazers.intothedeep.BlazersRobot;
import com.ftc.cskblazers.intothedeep.gamepads.BlazersGamePad1;
import com.ftc.cskblazers.intothedeep.gamepads.BlazersGamePad2;


@TeleOp(name="IntoTheDeep:Teleop", group="Robot")
public class IntotheDeepTeleOp extends LinearOpMode {

    BlazersRobot robot;
    BlazersGamePad1 blazersGamePad1;
    BlazersGamePad2 blazersGamePad2;


    public void initialize(){
        robot=new BlazersRobot(hardwareMap);
        robot.setTelemetry(telemetry);
        telemetry.addData(">", "Robot Ready.  Press Play.");    //
        telemetry.update();
        blazersGamePad1 =new BlazersGamePad1(gamepad1);
        blazersGamePad2 =new BlazersGamePad2(gamepad2);

    }

    @Override
    public void runOpMode() {
        initialize();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            blazersGamePad1.stickOperation(robot);
            blazersGamePad1.triggerOperation(robot);
            blazersGamePad1.bumperOperation(robot);
            blazersGamePad1.buttonAPress(robot);
            blazersGamePad1.buttonYPress(robot);
            blazersGamePad1.buttonBPress(robot);
            blazersGamePad1.buttonXPress(robot);

            blazersGamePad2.stickOperation(robot);
            blazersGamePad2.triggerOperation(robot);
            blazersGamePad2.bumperOperation(robot);
            blazersGamePad2.buttonYPress(robot);
            blazersGamePad2.buttonAPress(robot);
            blazersGamePad2.buttonXPress(robot);
            blazersGamePad2.buttonBPress(robot);


        }
    }
}
