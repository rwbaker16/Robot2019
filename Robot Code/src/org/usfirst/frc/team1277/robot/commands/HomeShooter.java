package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HomeShooter extends Command {
	double MOTOR_SPEED = 0.5;

    public HomeShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(OI.getShooterEncoder().get()>0)
    	{
    		OI.getShooterAim().set(MOTOR_SPEED);
    	}
    	OI.getShooterMotor().set(0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	OI.getShooterAim().set(0.0);
    }
}
