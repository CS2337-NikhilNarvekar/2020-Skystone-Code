package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import java.util.Locale;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

@Autonomous(group="Park", name="ParkBridgeRFBS_DELAY")

public class ParkBridgeRFBSDelay extends AutoSystem implements AutoValues {

  /** Orient the front of the robot towards the parking line.
    * Works for Red Foundation and Blue Stone Sides
    */

  public ParkBridgeRFBSDelay()
  {
    super("Off","Blue","Off");
  }

  public void runOpMode() throws InterruptedException {

    super.runOpMode();

    /* Main Loop */
    while(opModeIsActive()) {
      
      // delay for 22 seconds then move 
      sleep(22000);

      // Move to parallel with bridge
      strafeRight(26, SIDEWAYS_SPEED_MAX, 1);
      sleep(DEFAULT_SERVO_DELAY);

      // Move to Park
      moveForward(20, LINEAR_SPEED_MAX, 1);
      break;
    }
  }

}