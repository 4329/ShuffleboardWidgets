package com.example.simplewidget.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import com.example.simplewidget.data.BetterPIDControllerData;

import java.util.Map;
import java.util.function.Function;

public final class BetterPIDControllerType extends ComplexDataType<BetterPIDControllerData> {

  public static final BetterPIDControllerType Instance = new BetterPIDControllerType();

  private BetterPIDControllerType() {
    super("BetterPIDController", BetterPIDControllerData.class);
  }

  @Override
  public Function<Map<String, Object>, BetterPIDControllerData> fromMap() {
    return BetterPIDControllerData::new;
  }

  @Override
  public BetterPIDControllerData getDefaultValue() {
    return new BetterPIDControllerData(0, 0, 0, 0, 0, 0, 0, 0);
  }

}
