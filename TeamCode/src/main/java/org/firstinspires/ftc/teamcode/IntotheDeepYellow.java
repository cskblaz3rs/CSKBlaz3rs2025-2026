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

@Autonomous(name="IntoTheDeep:Autonomomous Yellow", group="Robot")
public class IntotheDeepYellow extends LinearOpMode {
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
        Pose2d initialPose = new Pose2d(20, 65, Math.toRadians(-90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        // vision here that outputs position
        int visionOutputPosition = 1;
        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .stopAndAdd(startPositions())
                .strafeTo(new Vector2d(62, 50))
                //.turn(Math.toRadians(-40))
                .waitSeconds(1.9)
                .strafeTo(new Vector2d(62, 55))
                .stopAndAdd(openOutboundClaw())
                .waitSeconds(0.3)
                //drops first one
                .stopAndAdd(closeOutboundClaw())
                //.turn(Math.toRadians(40))
                .strafeTo(new Vector2d(33, 35))
                .stopAndAdd(resetOutboundSlides())
                .stopAndAdd(extendInboundSlides())
                .waitSeconds(1.5)
                //grabs second one
                .stopAndAdd(transfer())
                .strafeTo(new Vector2d(62, 50))
                .waitSeconds(1.6)
                .strafeTo(new Vector2d(62, 55))
                .waitSeconds(0.2)
                .stopAndAdd(openOutboundClaw())
                .waitSeconds(0.3)
                .stopAndAdd(closeOutboundClaw())
                //drops second one
                .strafeTo(new Vector2d(43, 35))
                .stopAndAdd(resetOutboundSlides())
                .stopAndAdd(extendInboundSlides())
                .waitSeconds(1.5)
                //grabs third one
                .stopAndAdd(lowerTransfer())
                .strafeTo(new Vector2d(60, 50))
                .waitSeconds(0.5)
                .strafeTo(new Vector2d(60, 55))
                .waitSeconds(0.2)
                .stopAndAdd(openOutboundClaw())
                .waitSeconds(0.3)
                .stopAndAdd(closeOutboundClaw())
                .stopAndAdd(resetOutboundSlides())
                .strafeTo(new Vector2d(20, 0));
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
    public Action resetOutboundSlides() {
        return new InstantAction(() -> {
            robot.liftMe();
        });}
    public Action extendInboundSlides() {
        return new InstantAction(() -> {
            robot.clawInboundPositionStart();
            robot.closeInboundClaw();
            robot.inboundAutoPickPosition();
        });}
    public Action transfer() {
        return new InstantAction(() -> {
            robot.openInboundClaw();
            robot.transfer();
        });}
    public Action startPositions() {
        return new InstantAction(() -> {
            robot.adjustedStartPositions();
            robot.dropPosition();
        });}
    public Action lowerTransfer() {
        return new InstantAction(() -> {
            robot.openInboundClaw();
            robot.lowerTransfer();
        });}
}
