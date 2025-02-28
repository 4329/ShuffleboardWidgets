package com.example.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.components.NumberField;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import com.example.simplewidget.data.OctagonData;

import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

@Description(name = "Octagon", dataTypes = OctagonData.class)
@ParametrizedController("Octagon.fxml")
public class OctagonWidget extends SimpleAnnotatedWidget<OctagonData> {

  @FXML
  private Pane root;

  @FXML
  private ImageView background;

  private Circle[] reef;
  private Circle[] levels;

  private Paint on = Paint.valueOf("#ff8800");
  private Paint off = Paint.valueOf("#000000");

  @FXML
  private void initialize() {
	background.setImage(new Image(getClass().getResource("octagon/oct.png").toExternalForm(), 384, 256, false, false));

    reef = new Circle[12];
    levels = new Circle[4];

    for (int i = 0; i < 16; i++) {
      Circle circle = (Circle)root.getChildren().get(i + 1);
      int index = Integer.parseInt(circle.getId());
      if (index < 12) reef[index] = circle;
      else levels[index - 12] = circle;
    }

    dataProperty().addListener((__, oldData, newData) -> {
      if (oldData != null) {
		  if (oldData.getButton() - 1 >= 0) reef[oldData.getButton() - 1].setFill(off);
		  if (oldData.getLevel() - 1 >= 0) levels[oldData.getLevel() - 1].setFill(off);
      }
      if (newData != null) {
		  if (newData.getButton() - 1 >= 0) reef[newData.getButton() - 1].setFill(on);
		  if (newData.getLevel() - 1 >= 0) levels[newData.getLevel() - 1].setFill(on);
      }
    });
  }

  @Override
  public Pane getView() {
    return root;
  }
}
