package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.ftc.cskblazers.intothedeep.BlazersRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="IntoTheDeep:Autonomomous Blue", group="Robot")
public class IntotheDeepBlue extends LinearOpMode {
    BlazersRobot robot;


    public void initialize() {
        robot = new BlazersRobot(hardwareMap);
        robot.setTelemetry(telemetry);
        telemetry.addData(">", "Robot Ready.  Press Play.");    //
        telemetry.update();


    }

    @Override
    public void runOpMode() throws InterruptedException {
        initialize();
        Pose2d initialPose = new Pose2d(-5, 61.7, Math.toRadians(-90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        // vision here that outputs position
        int visionOutputPosition = 1;
        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .stopAndAdd(specimenHoldPosition())
                .waitSeconds(1)
                .strafeTo(new Vector2d(10, 24.5))
                .waitSeconds(0.5)
                .stopAndAdd(specimenHangPosition())
                .waitSeconds(0.8)
                .stopAndAdd(openOutboundClaw())
                .waitSeconds(0.2)
                .stopAndAdd(resetPositions())
                .strafeTo(new Vector2d(-40, 25))
                .stopAndAdd(resetOutboundSlides())
                .strafeTo(new Vector2d(-53, 0))
                .strafeTo(new Vector2d(-47, 45))
                //push first one
                .strafeTo(new Vector2d(-65, 0))
                .strafeTo(new Vector2d(-65, 45))
                .strafeTo(new Vector2d(-50, 52))
                //push second one
                //pick up second one position
                .strafeTo(new Vector2d(-52, 53.3))
                .waitSeconds(0.2)
                .stopAndAdd(outboundCloseLoose())
                .waitSeconds(0.2)
                .stopAndAdd(specimenHoldPosition())
                .waitSeconds(1.7)
                .strafeTo(new Vector2d(10, 20.3))
                .waitSeconds(0.5)
                .stopAndAdd(specimenHangPosition())
                .waitSeconds(0.9)
                .stopAndAdd(openOutboundClaw())
                //hang second one
                .waitSeconds(0.2)
                .stopAndAdd(resetPositions())
                .strafeTo(new Vector2d(-50, 49.5))
                //pick up third one position
                .strafeTo(new Vector2d(-52, 51.5))
                .waitSeconds(0.2)
                .stopAndAdd(outboundCloseLoose())
                .waitSeconds(0.2)
                .stopAndAdd(specimenHoldPosition())
                .waitSeconds(1)
                .strafeTo(new Vector2d(10, 20.9))
                .waitSeconds(0.5)
                .stopAndAdd(specimenHangPosition())
                .waitSeconds(0.9)
                .stopAndAdd(openOutboundClaw())
                //hang third one
                .waitSeconds(0.2)
                .stopAndAdd(resetPositions())
                .stopAndAdd(endPosition())
                .strafeTo(new Vector2d(-50, 52))



                /*.strafeTo(new Vector2d(-43, 30))
                .turn(Math.toRadians(-43))
                .stopAndAdd(inboundSetPosition(0.45))
                .stopAndAdd(openInboundClaw())
                .waitSeconds(0.5)
                .stopAndAdd(fullInboundClawClose())
                .waitSeconds(0.7)
                .stopAndAdd(flipClawUp())
                .waitSeconds(0.3)
                .turn(Math.toRadians(-130))
                .stopAndAdd(inboundSetPosition(0.25))
                .waitSeconds(0.5)
                .stopAndAdd(flipClawDown())
                .waitSeconds(0.5)
                .stopAndAdd(openInboundClaw())
                .waitSeconds(0.5)
                .stopAndAdd(inboundSetPosition(0.39))
                .turn(Math.toRadians(120))
                .waitSeconds(0.5)
                .stopAndAdd(fullInboundClawClose())
                .waitSeconds(0.7)
                .stopAndAdd(flipClawUp())
                .waitSeconds(0.3)
                .turn(Math.toRadians(-130))
                .stopAndAdd(inboundSetPosition(0.25))
                .waitSeconds(0.5)
                .stopAndAdd(flipClawDown())
                .waitSeconds(0.5)
                .stopAndAdd(openInboundClaw())
                .turn(Math.toRadians(180))
                .stopAndAdd(resetPositions())
                .strafeTo(new Vector2d(-34, 45))
                .lineToY(50)*/







                /*.stopAndAdd(specimenHangPosition())
                .waitSeconds(1.5)
                .strafeTo(new Vector2d(10, 29))
                .stopAndAdd(openOutboundClaw())
                //put first one on
                .strafeTo(new Vector2d(-50, 25))
                .stopAndAdd(resetOutboundSlides())
                .strafeTo(new Vector2d(-60, -10))
                .strafeTo(new Vector2d(-60, 50))
                //push first one
                .strafeTo(new Vector2d(-75, -10))
                .stopAndAdd(specimenPick())
                .strafeTo(new Vector2d(-75, 56))
                //push second one
                .waitSeconds(0.7)
                .stopAndAdd(closeOutboundClaw())
                //pick up second one
                .waitSeconds(0.3)
                .lineToY(58)
                .stopAndAdd(specimenOutboundHook())
                .strafeTo(new Vector2d(5, 30))
                .strafeTo(new Vector2d(5, 22))
                .stopAndAdd(specimenHangPosition())
                .waitSeconds(1.2)
                .strafeTo(new Vector2d(5, 29))
                .stopAndAdd(openOutboundClaw())
                //drop second one
                .stopAndAdd(resetOutboundSlides())
                .stopAndAdd(specimenPick())
                .strafeTo(new Vector2d(-50, 59))
                .waitSeconds(0.7)
                .stopAndAdd(closeOutboundClaw())
                //pick third  one
                .waitSeconds(0.3)
                .lineToY(60)
                .stopAndAdd(specimenOutboundHook())
                .strafeTo(new Vector2d(0, 30))
                .strafeTo(new Vector2d(0, 22))
                .stopAndAdd(specimenHangPosition())
                .waitSeconds(1.2)
                .strafeTo(new Vector2d(0, 29))
                .stopAndAdd(openOutboundClaw())
                //drop third one
                .stopAndAdd(resetOutboundSlides())
                .strafeTo(new Vector2d(-70, 56))*/



                //push second one
                //.strafeTo(new Vector2d(-60, 57))
                //.stopAndAdd(closeOutboundClaw())






                .waitSeconds(20);
        //.waitSeconds(0.1);
        //.setTangent(Math.toRadians())
        //.lineToXSplineHeading(0, Math.toRadians(0))
        //.waitSeconds(0.1)
        //.setTangent(Math.toRadians(-90))
        //.lineToY(67)
        //.setTangent(Math.toRadians(0))
        //.lineToX(32)
        //.strafeTo(new Vector2d(44.5, 30))
        //.turn(Math.toRadians(180))
        //lineToX(47.5)
        //.waitSeconds(0.1);
        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
                /*.lineToY(37)
                .setTangent(Math.toRadians(0))
                .lineToX(18)
                .waitSeconds(3)
                .setTangent(Math.toRadians(0))
                .lineToXSplineHeading(46, Math.toRadians(180))*/
                .waitSeconds(3);
        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
                /*.lineToYSplineHeading(33, Math.toRadians(180))
                .waitSeconds(2)
                .strafeTo(new Vector2d(46, 30))*/
                .waitSeconds(3);
        Action trajectoryActionCloseOut = tab1.endTrajectory().fresh()
                //.strafeTo(new Vector2d(48, 12))
                .build();

        while (!isStopRequested() && !opModeIsActive()) {
            int position = visionOutputPosition;
            telemetry.addData("Position during Init", position);
            telemetry.update();
        }

        int startPosition = visionOutputPosition;
        telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Action trajectoryActionChosen;
        if (startPosition == 1) {
            trajectoryActionChosen = tab1.build();
        } else if (startPosition == 2) {
            trajectoryActionChosen = tab2.build();
        } else {
            trajectoryActionChosen = tab3.build();
        }

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                        trajectoryActionCloseOut
                )
        );

    }

    public Action openOutboundClaw() {
        return new InstantAction(() -> {
            robot.openOutboundClaw();
        });}
    public Action closeOutboundClaw() {
        return new InstantAction(() -> {
            robot.closeOutboundClaw();
        });}
    public Action specimenHoldPosition() {
        return new InstantAction(() -> {
            robot.specimenPauseHang();
            robot.adjustedStartPositions();
            robot.looseOutboundClawGrip();
            robot.hangInitial();
        });}
    public Action endPosition() {
        return new InstantAction(() -> {
            robot.specimenPauseHang();
        });}
    public Action specimenHangPosition() {
        return new InstantAction(() -> {
            robot.specimenHangPosition();
        });}

    public Action resetOutboundSlides() {
        return new InstantAction(() -> {
            robot.liftMe();
        });}
    public Action closeInboundClaw() {
        return new InstantAction(() -> {
            robot.closeInboundClaw();
        });}
    public Action flipClawUp() {
        return new InstantAction(() -> {
            robot.inboundClawUp();
        });}
    public Action flipClawDown() {
        return new InstantAction(() -> {
            robot.inboundClawDown();
        });}
    public Action openInboundClaw() {
        return new InstantAction(() -> {
            robot.openInboundClaw();
        });}
    public Action turnClockInboundClaw() {
        return new InstantAction(() -> {
            robot.inboundRotateClock();
        });}
    public Action transfer() {
        return new InstantAction(() -> {
            robot.openInboundClaw();
            robot.transfer();
        });}
    public Action resetPositions() {
        return new InstantAction(() -> {
            robot.startPositions();
        });}

    public Action inboundSetPosition(double position) {
        return new InstantAction(() -> {
            robot.inboundSetPosition(position);
        });}

    public Action outboundSetPosition(int position) {
        return new InstantAction(() -> {
            robot.setHangPosition(position);
        });}
    public Action outboundCloseLoose(){
        return new InstantAction(() -> {
            robot.looseOutboundClawGrip();
        });}
    public Action specimenPick() {
        return new InstantAction(() -> {
           robot.specimenPick();
           robot.openOutboundClaw();
        });}
    public Action fullInboundClawClose() {
        return new InstantAction(() -> {
            robot.inboundFullClose();
        });}

}
