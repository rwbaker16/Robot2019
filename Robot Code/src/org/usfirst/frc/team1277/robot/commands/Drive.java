package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive {
	double DEAD_ZONE_TURN = 0.25, DEAD_ZONE_STRAIGHT = 0.15, SPEED_MULT_TURN = 0.8, SPEED_MULT_STRAIGHT = 2, EXP = 3,
			MIN_SPEED = .1;
	private static double MOVE_SPEED = 1.0f, ROTATE_SPEED = 1.0f, CONTROL_EXPONENT_MOVE = 1.0f,
			CONTROL_EXPONENT_ROTATE = 1.5f;
	private static double MOVE_DEADZONE = 0.025f, ROTATE_DEADZONE = 0.1f;
	private static double HATCH_MOTOR_SPEED = 0.5;
	ShooterAim aim = new ShooterAim();

	public double speedCap() {
		double speed;
		speed = (-OI.getJoystick().getRawAxis(3) + 1) / 2 * (1 - MIN_SPEED) + MIN_SPEED;
		SmartDashboard.putNumber("Speed Cap", speed);
		return speed;
	}

	public void tele() {

//		MY CODE (Delete later if other code is better)

		// turn stick/robot
//		   if (Math.abs(OI.getJoystick().getRawAxis(2)) >
//		  DEAD_ZONE_TURN) { 
//		  if (Math.abs(OI.getJoystick().getRawAxis(2)) < speedCap())
//		 { 
//		 OI.getTalonLeft().set(Math.pow(OI.getJoystick().getRawAxis(2), EXP) *
//		  SPEED_MULT_TURN);
//		  OI.getTalonRight().set(Math.pow(OI.getJoystick().getRawAxis(2), EXP) *
//		  SPEED_MULT_TURN); } else { OI.getTalonLeft().set(speedCap());
//		  OI.getTalonRight().set(speedCap()); 
//		  } 
//		  } 
//		  // Stick forward & backward 
//		  else if (Math.abs(OI.getJoystick().getRawAxis(1)) > DEAD_ZONE_STRAIGHT) {
//		   if(Math.abs(OI.getJoystick().getRawAxis(1)) < speedCap()) {
//		  OI.getTalonLeft().set(-Math.pow(OI.getJoystick().getRawAxis(1), EXP) *
//		  SPEED_MULT_STRAIGHT);
//		  OI.getTalonRight().set(Math.pow(OI.getJoystick().getRawAxis(1), EXP) *
//		  SPEED_MULT_STRAIGHT); } else { OI.getTalonLeft().set(-speedCap());
//		  OI.getTalonRight().set(speedCap()); 
//		  } 
//		  }
//		   // stop 
//		  else {
//		  OI.getTalonLeft().set(0.0);
//		   OI.getTalonRight().set(0.0);
//		    } 
//		    if(OI.getJoystick().getPOV() == 0) { 
//		    aim.up(); 
//		    } 
//		    if (OI.getJoystick().getPOV()== 4)
//		    { aim.down(); }

		double move = -OI.getJoystick().getRawAxis(1), rotate = OI.getJoystick().getRawAxis(2);

		// Adjust for Move Deadzone
		if (move >= MOVE_DEADZONE)
			move -= MOVE_DEADZONE;
		else if (move <= -MOVE_DEADZONE)
			move += MOVE_DEADZONE;
		else
			move = 0.0f;
		move /= 1.0f - MOVE_DEADZONE;

		// Adjust for Rotate Deadzone
		if (rotate >= ROTATE_DEADZONE)
			rotate -= ROTATE_DEADZONE;
		else if (rotate <= -ROTATE_DEADZONE)
			rotate += ROTATE_DEADZONE;
		else
			rotate = 0.0f;
		rotate /= 1.0f - ROTATE_DEADZONE;

		// Exponential Adjustment
		move *= Math.pow(Math.abs(move), CONTROL_EXPONENT_MOVE - 1.0f);
		rotate *= Math.pow(Math.abs(rotate), CONTROL_EXPONENT_ROTATE - 1.0f);

		// Linear Adjustment for Maximum Speed
		move *= MOVE_SPEED;
		rotate *= ROTATE_SPEED;

		// Throttle for limiting speed
		move *= speedCap();
		rotate *= speedCap();

		DriveTrain.drive(move, rotate);

		if (OI.getJoystick().getPOV() == 0) {
			aim.up();
		}
		if (OI.getJoystick().getPOV() == 180) {
			aim.down();
		}

		if (OI.getJoystick().getPOV() == 90) {
			OI.gethatchMotor().set(HATCH_MOTOR_SPEED);
		}
		if (OI.getJoystick().getPOV() == 270) {
			OI.gethatchMotor().set(HATCH_MOTOR_SPEED);
		}
		if (OI.getJoystick().getPOV() == -1) {
			aim.stop();
		}
	}
}
