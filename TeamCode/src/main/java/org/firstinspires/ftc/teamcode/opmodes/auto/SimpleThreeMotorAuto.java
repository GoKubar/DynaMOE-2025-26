package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "3 Motor Test")
public class SimpleThreeMotorAuto extends LinearOpMode {

    @Override
    public void runOpMode() {

        // make the names of the motors
        DcMotor leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor leftBack   = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightBack  = hardwareMap.get(DcMotor.class, "rightBack");

        // reverse to go foward
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        // already works
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        leftBack.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        // power test


        double rightPower = 0.2;
        //missing the wheel so cut inhalf
        double leftPower = rightPower / 2.0;

        // driivng
        telemetry.addData("status", "driving");
        telemetry.addData("right", rightPower);
        telemetry.addData("left", leftPower);
        telemetry.update();

        leftFront.setPower(leftPower);
        leftBack.setPower(leftPower);
        rightBack.setPower(rightPower);

        // driving for 2 secs
        sleep(2000);

        // stop
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

        telemetry.addData("status", "complete");
        telemetry.update();
    }
}