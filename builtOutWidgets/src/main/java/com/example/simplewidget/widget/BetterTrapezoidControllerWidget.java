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
@Description(name = "BetterTrapezoidController", dataTypes = BetterPIDControllerData.class)
@ParametrizedController("BetterTrapezoidControllerWidget.fxml")
public class BetterTrapezoidControllerWidget extends SimpleAnnotatedWidget<BetterPIDControllerData> {

  @FXML
  private Pane root;

  @FXML
  private NumberField pField;
  @FXML
  private NumberField iField;
  @FXML
  private NumberField dField;
  @FXML 
  private NumberField tolField;
  
  @FXML
  private NumberField setpointField;
  @FXML 
  private NumberField outputField;

  @FXML
  private NumberField speedField;
  @FXML
  private NumberField accelField;

  @FXML
  private void initialize() {
    root.setStyle("-fx-font-size: 10pt;");
    dataProperty().addListener((__, old, newData) -> {
      pField.setNumber(newData.getP());
      iField.setNumber(newData.getI());
      dField.setNumber(newData.getD());
      tolField.setNumber(newData.getTol());
      setpointField.setNumber(newData.getSetpoint());
      outputField.setNumber(newData.getOutput());
	  speedField.setNumber(newData.getSpeed());
	  accelField.setNumber(newData.getAccel());
    });

    actOnFocusLost(pField);
    actOnFocusLost(iField);
    actOnFocusLost(dField);
    actOnFocusLost(tolField);
    actOnFocusLost(setpointField);
    actOnFocusLost(outputField);
    actOnFocusLost(speedField);
    actOnFocusLost(accelField);
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

  @FXML
  private void setSpeed() {
    setData(getData().withSpeed(speedField.getNumber()));
  }

  @FXML
  private void setAccel() {
    setData(getData().withAccel(accelField.getNumber()));
  }

}
