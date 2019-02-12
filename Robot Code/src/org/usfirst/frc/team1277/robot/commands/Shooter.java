/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.Robot;

/**
 * An example command. You can replace me with your own command.
 */
public class Shooter extends Command {

	// ADD port number & tweak speeds
	double SHOOTER_SPEED = 0.5, PULL_SPEED = 0.5;

	public Shooter() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_subsystem);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (OI.getShooterLimit().get()) {
			OI.getShooterMotor().set(SHOOTER_SPEED);
			SmartDashboard.putString("Shooter", "Push");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		OI.getShooterMotor().set(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		OI.getShooterMotor().set(0.0);
	}
}
