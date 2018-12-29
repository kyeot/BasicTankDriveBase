package org.usfirst.frc2783.BasicTankDriveBase.loops;

/**
 * 
 * Simple interface for defining a Loop
 *
 */

public interface Loop {
	
	public void onStart();
	
	public void onLoop();
	
	public void onStop();

	public void onLoop(double timestamp);

}
