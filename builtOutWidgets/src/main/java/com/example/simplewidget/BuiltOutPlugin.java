package com.example.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import com.example.simplewidget.data.type.GyroType;
import com.example.simplewidget.data.type.BetterPIDControllerType;
import com.example.simplewidget.data.type.OctagonType;

import com.example.simplewidget.widget.BetterPIDControllerWidget;
import com.example.simplewidget.widget.BetterTrapezoidControllerWidget;
import com.example.simplewidget.widget.GyroWidget;
import com.example.simplewidget.widget.LoadingBarringWidget;
import com.example.simplewidget.widget.SometimesTextWidget;
import com.example.simplewidget.widget.OctagonWidget;

import java.util.List;
import java.util.Map;

@Description(
    group = "com.example",
    name = "BuiltOut Plugin",
    version = "2019.1.1",
    summary="More Widgets"
)
public final class BuiltOutPlugin extends Plugin {

  @Override
  public List<DataType> getDataTypes() {
    return List.of(
        GyroType.Instance,
        BetterPIDControllerType.Instance,
        OctagonType.Instance
    );
  }

  @Override
  public List<ComponentType> getComponents() {
    return List.of(
        WidgetType.forAnnotatedWidget(GyroWidget.class),
        WidgetType.forAnnotatedWidget(LoadingBarringWidget.class),
        WidgetType.forAnnotatedWidget(SometimesTextWidget.class),
        WidgetType.forAnnotatedWidget(BetterPIDControllerWidget.class),
        WidgetType.forAnnotatedWidget(OctagonWidget.class),
        WidgetType.forAnnotatedWidget(BetterTrapezoidControllerWidget.class)
    );
  }

  @Override
  public Map<DataType, ComponentType> getDefaultComponents() {
    return Map.of(
        GyroType.Instance, WidgetType.forAnnotatedWidget(GyroWidget.class),
        BetterPIDControllerType.Instance, WidgetType.forAnnotatedWidget(BetterTrapezoidControllerWidget.class),
        OctagonType.Instance, WidgetType.forAnnotatedWidget(OctagonWidget.class)
    );
  }
}
