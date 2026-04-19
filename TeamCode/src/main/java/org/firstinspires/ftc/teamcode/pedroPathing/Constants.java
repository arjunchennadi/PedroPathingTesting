package org.firstinspires.ftc.teamcode.pedroPathing;


import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.control.PIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(12.7)
            .headingPIDFCoefficients(new PIDFCoefficients(0.8,0,0.05,0.02))
            .forwardZeroPowerAcceleration(-38.030596703133206)
            .lateralZeroPowerAcceleration(-76.12389055116962)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.07,0,0.006,0.02))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.02,0,0.0001,0.06,0.025))
            .centripetalScaling(0.0001);


    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);


    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .threeWheelLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .build();
    }


    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("rl_drive")
            .rightRearMotorName("fl_drive")
            .leftFrontMotorName("rr_drive")
            .leftRearMotorName("fr_drive")
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .xVelocity(57.90576593039992)
            .yVelocity(42.069869933080916);


    public static ThreeWheelConstants localizerConstants = new ThreeWheelConstants()
            .forwardTicksToInches(.002997455782137968)
            .strafeTicksToInches(.0029857211782443964)
            .turnTicksToInches(-0.0027440255649993197)
            .leftPodY(-6.5)
            .rightPodY(6.5)
            .strafePodX(1.5)
            .leftEncoder_HardwareMapName("fr_drive")
            .rightEncoder_HardwareMapName("rl_drive")
            .strafeEncoder_HardwareMapName("fl_drive")
            .leftEncoderDirection(Encoder.FORWARD)
            .rightEncoderDirection(Encoder.REVERSE)
            .strafeEncoderDirection(Encoder.REVERSE);
}

