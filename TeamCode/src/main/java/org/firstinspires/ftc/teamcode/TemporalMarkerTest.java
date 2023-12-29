//The following program is a template for RoadRunner programs in autonomous.
//This package and the following imports are required.
package org.firstinspires.ftc.teamcode;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
//Replace "Template" with your new program's file name.
public final class TemporalMarkerTest extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        //The Pose2d function sets where your robot is going to start its trajectory from in X, Y, and heading (in radians or use "Math.toRadians" and input degrees).
        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        waitForStart();
        Pose2d startPose = new Pose2d(0,0,0);

        drive.setPoseEstimate(startPose);

        TrajectorySequence trajSeq = drive.trajectorySequenceBuilder(startPose)
                .strafeTo(0, 20)
                .addTemporalMarker(() drive.Claw1.setPosition(0))
                .waitSeconds(3)
                .addTemporalMarker(() drive.Claw2.setPosition(0))
                .waitSeconds(3)
                .addTemporalMarker(() drive.Claw1.setPosition(1), drive.Claw2.setPosition(1))
                .waitSeconds(3)
                .strafeTo(0, 0);
    }
}