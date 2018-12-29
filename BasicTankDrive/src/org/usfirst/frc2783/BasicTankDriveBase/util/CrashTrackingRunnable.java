package org.usfirst.frc2783.BasicTankDriveBase.util;

public abstract class CrashTrackingRunnable implements Runnable {
	
	@Override
	public void run() {
		try {
			runCrashTracked();
		} catch(Throwable t) {
			throw(t);
		}
	}
	
	public abstract void runCrashTracked();

	public abstract void logCrash();

}