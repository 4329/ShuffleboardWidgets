package com.example.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.components.NumberField;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import com.example.simplewidget.data.BetterPIDControllerData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * A widget for controlling BetterPID controllers. This gives control over the four BetterPIDF constants, the controller
 * setpoint, and whether or not the controller is enabled.
 */
@Description(name = "BetterPIDController", dataTypes = BetterPIDControllerData.class)
@ParametrizedController("BetterPIDControllerWidget.fxml")
public class BetterPIDControllerWidget extends SimpleAnnotatedWidget<BetterPIDControllerData> {

  @FXML
  private Pane root;

  @FXML
  private NumberField pField;
  @FXML
  private NumberField iField;
  @FXML
  private NumberField iZoneField;
  @FXML
  private NumberField dField;
  @FXML 
  private NumberField tolField;
  
  @FXML
  private NumberField setpointField;
  @FXML 
  private NumberField outputField;

  @FXML
  private void initialize() {
    root.setStyle("-fx-font-size: 10pt;");
    dataProperty().addListener((__, old, newData) -> {
      pField.setNumber(newData.getP());
      iField.setNumber(newData.getI());
      iZoneField.setNumber(newData.getIZone());
      dField.setNumber(newData.getD());
      tolField.setNumber(newData.getTol());
      setpointField.setNumber(newData.getSetpoint());
      outputField.setNumber(newData.getOutput());
    });

    actOnFocusLost(pField);
    actOnFocusLost(iField);
    actOnFocusLost(iZoneField);
    actOnFocusLost(dField);
    actOnFocusLost(tolField);
    actOnFocusLost(setpointField);
    actOnFocusLost(outputField);
  }

  private void actOnFocusLost(TextField field) {
    field.focusedProperty().addListener((__, was, is) -> {
      if (!is) {
        field.getOnAction().handle(new ActionEvent(this, field));
      }
    });
  }

  @Override
  public Pane getView() {
    return root;
  }

  @FXML
  private void setP() {
    setData(getData().withP(pField.getNumber()));
  }

  @FXML
  private void setI() {
    setData(getData().withI(iField.getNumber()));
  }

  @FXML
  private void setIZone() {
    setData(getData().withIZone(iZoneField.getNumber()));
  }

  @FXML
  private void setD() {
    setData(getData().withD(dField.getNumber()));
  }

  @FXML
  private void setTol() {
    setData(getData().withTol(tolField.getNumber()));
  }

  @FXML
  private void setSetpoint() {
    setData(getData().withSetpoint(setpointField.getNumber()));
  }

}
