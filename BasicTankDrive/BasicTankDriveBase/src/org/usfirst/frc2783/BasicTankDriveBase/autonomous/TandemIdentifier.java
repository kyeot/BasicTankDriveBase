package org.usfirst.frc2783.BasicTankDriveBase.autonomous;

import org.usfirst.frc2783.BasicTankDriveBase.robot.Robot;

public class TandemIdentifier extends Action{

	public TandemIdentifier() {
		super("TandemIdentifier");
	}

	@Override
	public void start() {
		Robot.tandemAction.runTandem();
	}
	
	@Override
	public boolean done(){
		return true;
	}
}
