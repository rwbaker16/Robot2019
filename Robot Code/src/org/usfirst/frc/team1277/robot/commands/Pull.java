package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pull extends Command {
	double PULL_SPEED = 0.5;

	public Pull() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		OI.getShooterMotor().set(PULL_SPEED);
		SmartDashboard.putString("Shooter", "Pull");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		OI.getShooterMotor().set(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		OI.getShooterMotor().set(0.0);
	}
}
