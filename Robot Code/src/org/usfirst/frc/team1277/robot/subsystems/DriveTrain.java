package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.OI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain {
	public static void drive(double move, double rotate)
	{
		double greatestControl, greatestSpeed;
		double right,left;
		// Preliminary calculations
		greatestControl = Math.max(Math.abs(move), Math.abs(rotate));
		greatestSpeed = Math.max(Math.abs(-move - rotate), Math.abs(move - rotate));
		// if(greatestSpeed == 0) greatestSpeed = 0.1;
		
		// Drive the motors
		right=(move + rotate) * greatestControl / greatestSpeed;
		left=(-move + rotate) * greatestControl / greatestSpeed;
		OI.getTalonRight().set(right);
		OI.getTalonLeft().set(left);
		
		SmartDashboard.putNumber("Right", right);
		SmartDashboard.putNumber("Left", left);
		
	}
}
