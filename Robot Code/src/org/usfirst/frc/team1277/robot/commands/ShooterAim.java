package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterAim {
	double TILT_SPEED = 1;

	public void up() {
		OI.getShooterAim().set(TILT_SPEED);
		SmartDashboard.putString("Shooter Aim", "UP");
	}

	public void down() {
		OI.getShooterAim().set(-TILT_SPEED);
		SmartDashboard.putString("Shooter Aim", "Down");
	}

	public void stop() {
		OI.getShooterAim().set(0.0);
		SmartDashboard.putString("Shooter Aim", "Stop");
	}
}
