package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.util.Range;
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


@Autonomous(group="Stone", name="BlueStone2")

public class BlueStone2 extends AutoSystem implements AutoValues {

  public BlueStone2() {
    super("VuforiaOn","blue","WebCam");
  }

  public void runOpMode() throws InterruptedException {

    super.runOpMode();

    /* Main Loop */
    while(opModeIsActive()) {

      // Move Clamp Servo Out Beforehand
      blockServoClamp.setPosition(0.3);

      // Strafe right to detect
      strafeRight(12, SIDEWAYS_SPEED_MAX, 1);

      // Allow Time for robot to stabilize and detect skblockServoClampPosstone
      sleep(DETECTION_DELAY);
      String stoneLocation = scanner();
      telemetry.addLine(stoneLocation);
      telemetry.update();

      // Move to Skystone
      if(stoneLocation.equals("BLUE_LEFT")) {
        //
      } else if(stoneLocation.equals("BLUE_CENTER")) {
        moveBackward(7, LINEAR_SPEED_MIN, 1);
      } else {
        moveBackward(14, LINEAR_SPEED_MIN, 1);
      }
      sleep(DEFAULT_METHOD_DELAY);

      // Shutdown Vuforia Engine
      TFODShutDown();

      // Move to pickup first skystone
      strafeRight(13, SIDEWAYS_SPEED_MAX, 1);
      sleep(DEFAULT_METHOD_DELAY);

      // Grab Skystone
      clampBlock();

      // Strafe Outwards
      strafeLeft(6, SIDEWAYS_SPEED_MAX, 1);

      // Deposit first skystone
      if(stoneLocation.equals("BLUE_LEFT"))
        moveForward(30, LINEAR_SPEED_MAX, 1);
      else if(stoneLocation.equals("BLUE_CENTER"))
        moveForward(38, LINEAR_SPEED_MAX, 1);
      else
        moveForward(45, LINEAR_SPEED_MAX, 1);
      sleep(DEFAULT_METHOD_DELAY);

      // Release Skystone
      releaseBlock();
      sleep(DEFAULT_SERVO_DELAY);

      // Move to Second Skystone
      if(stoneLocation.equals("BLUE_LEFT"))
        moveBackward(50, LINEAR_SPEED_MAX, 1);
      else if(stoneLocation.equals("BLUE_CENTER"))
        moveBackward(58, LINEAR_SPEED_MAX, 1);
      else
        moveBackward(56, LINEAR_SPEED_MAX, 1);
      sleep(DEFAULT_METHOD_DELAY);

      // Move to pickup second skystone
      strafeRight(6, SIDEWAYS_SPEED_MAX, 1);
      sleep(DEFAULT_METHOD_DELAY);

      // Grab Second Skystone
      clampBlock();

      // Move Outwards
      strafeLeft(6, SIDEWAYS_SPEED_MAX, 1);

      // Deposit Second Skystone
      if(stoneLocation.equals("BLUE_LEFT"))
        moveForward(55, LINEAR_SPEED_MAX, 1);
      else if(stoneLocation.equals("BLUE_CENTER"))
        moveForward(63, LINEAR_SPEED_MAX, 1);
      else
        moveForward(71, LINEAR_SPEED_MAX, 1);
      sleep(DEFAULT_METHOD_DELAY);

      // Release Second Skystone
      releaseBlock();
      sleep(DEFAULT_SERVO_DELAY);

      // Move to Park
      moveBackward(9, LINEAR_SPEED_MAX, 1);
      break;
    }
  }

}
