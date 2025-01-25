package com.example.simplewidget.data;

import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import com.example.simplewidget.data.type.BetterPIDControllerType;

import java.util.Map;
import java.util.Objects;

public final class BetterPIDControllerData extends ComplexData<BetterPIDControllerData> {

  private final double p;
  private final double i;
  private final double d;
  private final double tol;
  private final double setpoint;
  private final double output;

  /**
   * Creates a new BetterPIDController data object.
   *
   * @param p        the proportional constant
   * @param i        the integral constant
   * @param d        the derivative constant
   * @param setpoint the controller setpoint
   */
  public BetterPIDControllerData(double p, double i, double d, double tol, double setpoint, double output) {
    this.p = p;
    this.i = i;
    this.d = d;
    this.tol = tol;
    this.setpoint = setpoint;
    this.output = output;
  }

  /**
   * Creates a new data object from a map. The map should contain values for all the properties of the data object. If
   * a value is missing, the default value of {@code 0} (for numbers) is used.
   */
  public BetterPIDControllerData(Map<String, Object> map) {
    this((double) map.getOrDefault("p", 0.0),
        (double) map.getOrDefault("i", 0.0),
        (double) map.getOrDefault("d", 0.0),
        (double) map.getOrDefault("tol", 0.0),
        (double) map.getOrDefault("setpoint", 0.0),
        (double) map.getOrDefault("output", 0.0));
  }

  public double getP() {
    return p;
  }

  public double getI() {
    return i;
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


  public BetterPIDControllerData withP(double p) {
    return new BetterPIDControllerData(p, i, d, tol, setpoint, output);
  }

  public BetterPIDControllerData withI(double i) {
    return new BetterPIDControllerData(p, i, d, tol, setpoint, output);
  }

  public BetterPIDControllerData withD(double d) {
    return new BetterPIDControllerData(p, i, d, tol, setpoint, output);
  }

  public BetterPIDControllerData withTol(double tol) {
    return new BetterPIDControllerData(p, i, d, tol, setpoint, output);
  }

  public BetterPIDControllerData withSetpoint(double setpoint) {
    return new BetterPIDControllerData(p, i, d, tol, setpoint, output);
  }

  @Override
  public Map<String, Object> asMap() {
    return ImmutableMap.<String, Object>builder()
        .put("p", p)
        .put("i", i)
        .put("d", d)
        .put("tol", tol)
        .put("setpoint", setpoint)
        .put("output", output)
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
        && this.d == that.d
        && this.tol == that.tol
        && this.setpoint == that.setpoint
        && this.output == that.output;
  }

  @Override
  public int hashCode() {
    return Objects.hash(p, i, d, tol, setpoint, output);
  }

  @Override
  public String toString() {
    return String.format("BetterPIDControllerData(p=%s, i=%s, d=%s, tol=%s, setpoint=%s, output=%s)",
        p, i, d, tol, setpoint, output);
  }

  @Override
  public String toHumanReadableString() {
    return String.format("p=%.3f, i=%.3f, d=%.3f, tol=%.3f, setpoint=%.3f, output=%.3f", p, i, d, tol, setpoint, output);
  }
}
