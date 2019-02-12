/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot;

import org.usfirst.frc.team1277.robot.commands.GrabHatch;
import org.usfirst.frc.team1277.robot.commands.HomeShooter;
import org.usfirst.frc.team1277.robot.commands.Pull;
import org.usfirst.frc.team1277.robot.commands.Shooter;
import org.usfirst.frc.team1277.robot.commands.SolenoidOff;
import org.usfirst.frc.team1277.robot.commands.SolenoidOn;
import org.usfirst.frc.team1277.robot.commands.ZeroEncoders;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public static Joystick joystick = new Joystick(0);
	static Talon talonRight = new Talon(2);
	static Talon talonLeft = new Talon(3);
	static Relay solenoid = new Relay(0);
	static Talon shooterAim = new Talon(8);
	static Talon shooterMotor = new Talon(0);
	static Talon hatchMotor = new Talon(9);
	static Encoder hatchEncoder = new Encoder(0,1);
	static Encoder shooterEncoder = new Encoder(2,3);
	static DigitalInput shooterLimit = new DigitalInput(0);
	Button button0 = new JoystickButton(joystick,0);
	Button button1 = new JoystickButton(joystick,1);
	Button button2 = new JoystickButton(joystick,2);
	static Button button3 = new JoystickButton(joystick,3);
	Button button4 = new JoystickButton(joystick,4);
	Button button5 = new JoystickButton(joystick,5);
	Button button6 = new JoystickButton(joystick,6);
	Button button7 = new JoystickButton(joystick,7);
	Button button8 = new JoystickButton(joystick,8);
	Button button9 = new JoystickButton(joystick,9);
	Button button10 = new JoystickButton(joystick,10);
	Button button11 = new JoystickButton(joystick,11);
	Button button12 = new JoystickButton(joystick,12);
	
	public OI()
	{
		button1.whileHeld(new Shooter());
		button2.whileHeld(new Pull());
		button3.whenPressed(new SolenoidOn());
		button3.whenReleased(new SolenoidOff());
		button4.whenPressed(new GrabHatch());
		button11.whenPressed(new HomeShooter());
		button12.whenPressed(new ZeroEncoders());
		
		
	}
	
	public static Joystick getJoystick() {
		return joystick;
	}
	public static Relay getSolenoid()
	{
		return solenoid;
	}
	public static Talon getTalonRight()
	{
		return talonRight;
	}
	public static Talon getTalonLeft()
	{
		return talonLeft;
	}
	public static Talon getShooterAim()
	{
		return shooterAim;
	}
	public static Talon getShooterMotor()
	{
		return shooterMotor;
	}
	public static Talon gethatchMotor()
	{
		return hatchMotor;
	}
	public static Encoder getHatchEncoder()
	{
		return hatchEncoder;
	}
	public static Encoder getShooterEncoder()
	{
		return shooterEncoder;
	}
	public static DigitalInput getShooterLimit()
	{
		return shooterLimit;
	}
}
