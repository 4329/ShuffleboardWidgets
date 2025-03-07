package com.example.simplewidget.data;

import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import com.example.simplewidget.data.type.BetterPIDControllerType;

import java.util.Map;
import java.util.Objects;

public final class BetterPIDControllerData extends ComplexData<BetterPIDControllerData> {

  private final double p;
  private final double i;
  private final double iZone;
  private final double d;
  private final double tol;
  private final double setpoint;
  private final double output;
  private final double speed;
  private final double accel;

  /**
   * Creates a new BetterPIDController data object.
   *
   * @param p        the proportional constant
   * @param i        the integral constant
   * @param d        the derivative constant
   * @param setpoint the controller setpoint
   */
  public BetterPIDControllerData(double p, double i, double iZone, double d, double tol, double setpoint, double output, double speed, double accel) {
    this.p = p;
    this.i = i;
    this.iZone = iZone;
    this.d = d;
    this.tol = tol;
    this.setpoint = setpoint;
    this.output = output;
	this.speed = speed;
	this.accel = accel;
  }

  /**
   * Creates a new data object from a map. The map should contain values for all the properties of the data object. If
   * a value is missing, the default value of {@code 0} (for numbers) is used.
   */
  public BetterPIDControllerData(Map<String, Object> map) {
    this((double) map.getOrDefault("p", 0.0),
        (double) map.getOrDefault("i", 0.0),
        (double) map.getOrDefault("iZone", 0.0),
        (double) map.getOrDefault("d", 0.0),
        (double) map.getOrDefault("tol", 0.0),
        (double) map.getOrDefault("setpoint", 0.0),
        (double) map.getOrDefault("output", 0.0),
        (double) map.getOrDefault("speed", 0.0),
        (double) map.getOrDefault("accel", 0.0));
  }

  public double getP() {
    return p;
  }

  public double getI() {
    return i;
  }

  public double getIZone() {
    return iZone;
  }

  public double getD() {
    return d;
  }
  
  public double getTol() {
    return tol;
  }

  public double getSetpoint() {
    return setpoint;
  }

  public double getOutput() {
    return output;
  }

  public double getSpeed() {
	  return speed;
  }

  public double getAccel() {
	  return accel;
  }

  public BetterPIDControllerData withP(double p) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withI(double i) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withIZone(double iZone) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withD(double d) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withTol(double tol) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withSetpoint(double setpoint) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withSpeed(double speed) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  public BetterPIDControllerData withAccel(double accel) {
    return new BetterPIDControllerData(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  @Override
  public Map<String, Object> asMap() {
    return ImmutableMap.<String, Object>builder()
        .put("p", p)
        .put("i", i)
        .put("iZone", iZone)
        .put("d", d)
        .put("tol", tol)
        .put("setpoint", setpoint)
        .put("output", output)
		.put("speed", speed)
		.put("accel", accel)
        .build();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    BetterPIDControllerData that = (BetterPIDControllerData) obj;
    return this.p == that.p
        && this.i == that.i
        && this.iZone == that.iZone
        && this.d == that.d
        && this.tol == that.tol
        && this.setpoint == that.setpoint
        && this.output == that.output
        && this.speed == that.speed
        && this.accel == that.accel;
  }

  @Override
  public int hashCode() {
    return Objects.hash(p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  @Override
  public String toString() {
    return String.format("BetterPIDControllerData(p=%s, i=%s, iZone=%s, d=%s, tol=%s, setpoint=%s, output=%s, speed=%s, accel=%s)",
        p, i, iZone, d, tol, setpoint, output, speed, accel);
  }

  @Override
  public String toHumanReadableString() {
    return String.format("p=%.3f, i=%.3f, iZone=%.3f, d=%.3f, tol=%.3f, setpoint=%.3f, output=%.3f, speed=%.3f, accel=%.3f", p, i, iZone, d, tol, setpoint, output, speed, accel);
  }
}
