package org.usfirst.frc2783.BasicTankDriveBase.PIDClasses;

import org.usfirst.frc2783.BasicTankDriveBase.subsystems.TankDriveBase;

import edu.wpi.first.wpilibj.PIDOutput;

public class TankPositionOutput implements PIDOutput {
	@Override
	public void pidWrite(double output) {
		TankDriveBase.rotation = -output;
	}
}
