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
	  if (old.getP() != newData.getP()) pField.setNumber(newData.getP());
      if (old.getI() != newData.getI()) iField.setNumber(newData.getI());
      if (old.getIZone() != newData.getIZone()) iZoneField.setNumber(newData.getIZone());
      if (old.getD() != newData.getD()) dField.setNumber(newData.getD());
      if (old.getTol() != newData.getTol()) tolField.setNumber(newData.getTol());
      if (old.getSetpoint() != newData.getSetpoint()) setpointField.setNumber(newData.getSetpoint());
      if (old.getOutput() != newData.getOutput()) outputField.setNumber(newData.getOutput());
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
