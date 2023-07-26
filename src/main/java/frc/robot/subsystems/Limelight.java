package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Limelight extends SubsystemBase{
    private static final Limelight instance = new Limelight();
    
    private final NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    double x, y, area;

    public Limelight() {

    }

    @Override
    public void periodic(){
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0);
        area = ta.getDouble(0.0);

        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getA(){
        return area;
    }

    public void enableLEDs(){
        instance.table.getEntry("ledMode").setNumber(0); // on
    }
    public void disableLEDs(){
        instance.table.getEntry("ledMode").setNumber(1); // on
    }
    public void blinkLEDs(){
        instance.table.getEntry("ledMode").setNumber(2); // on
    }
}
