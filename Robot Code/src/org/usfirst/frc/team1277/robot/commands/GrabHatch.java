package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabHatch extends Command {
	double COUNT = 16800, MOTOR_SPEED = 0.5;

    public GrabHatch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	OI.getHatchEncoder().reset();
    	while(OI.getHatchEncoder().get()<=COUNT)
    	{
    		OI.gethatchMotor().set(MOTOR_SPEED);
    	}
    	OI.gethatchMotor().set(0.0);
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
    	OI.gethatchMotor().set(0.0);
    }
}
