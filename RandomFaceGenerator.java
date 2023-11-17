import miniproject.About;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.*;

class SameColourException extends Exception
{
  SameColourException(String str)
   {
      super(str);
   } 
}

public class RandomFaceGenerator extends Application {
    public static void main(String[] args) {

        About thread1= new About("Start Thread");
        thread1.start();
       try{
        thread1.join();}
       catch(InterruptedException e)
{}

        launch(args);
    }

    private String selectedFaceShape = "Rectangle";
    private String selectedEyeShape = "Rectangle";
    private String selectedMouthShape = "Rectangle";

    private Color faceColor = Color.RED;
    private Color eyeColor = Color.BLUE;
    private Color mouthColor = Color.BLACK;

  @Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Custom Face Generator");

    Pane root = new Pane();

    Scene scene = new Scene(root, 600, 600);

    ComboBox<String> faceShapeComboBox = new ComboBox<>();
    faceShapeComboBox.getItems().addAll("Rectangle", "Circle");
    faceShapeComboBox.setValue("Rectangle");

    ComboBox<String> eyeShapeComboBox = new ComboBox<>();
    eyeShapeComboBox.getItems().addAll("Rectangle", "Circle");
    eyeShapeComboBox.setValue("Rectangle");

    ComboBox<String> mouthShapeComboBox = new ComboBox<>();
    mouthShapeComboBox.getItems().addAll("Rectangle", "Circle");
    mouthShapeComboBox.setValue("Rectangle");

    ColorPicker faceColorPicker = new ColorPicker(faceColor);
    ColorPicker eyeColorPicker = new ColorPicker(eyeColor);
    ColorPicker mouthColorPicker = new ColorPicker(mouthColor);

    Button drawButton = new Button("Draw Face");
    

    drawButton.setOnAction(new EventHandler<ActionEvent>(){
     public void handle(ActionEvent ae)
      {
         try{
              if(faceColor.equals(eyeColor)||faceColor.equals(mouthColor))
              throw new SameColourException("FEATURES CANNOT HAVE SAME COLOUR AS FACE");
            }
         catch(SameColourException e)
            {
              System.out.println(e);
              faceColor = Color.RED;
              eyeColor = Color.BLUE;
              mouthColor = Color.BLACK;

            }
              
         drawFace(root, selectedFaceShape, selectedEyeShape, selectedMouthShape, faceColor, eyeColor, mouthColor);}});    

    VBox controls = new VBox(10);
    controls.getChildren().addAll(
            new Text("Face Shape"), faceShapeComboBox,
            new Text("Eye Shape"), eyeShapeComboBox,
            new Text("Mouth Shape"), mouthShapeComboBox,
            new Text("Face Color"), faceColorPicker,
            new Text("Eye Color"), eyeColorPicker,
            new Text("Mouth Color"), mouthColorPicker,
            drawButton
    );
    controls.setLayoutX(10);
    controls.setLayoutY(10);

    root.getChildren().addAll(controls);

    primaryStage.setScene(scene);
    primaryStage.show();

    faceShapeComboBox.setOnAction(event -> selectedFaceShape = faceShapeComboBox.getValue());
    eyeShapeComboBox.setOnAction(event -> selectedEyeShape = eyeShapeComboBox.getValue());
    mouthShapeComboBox.setOnAction(event -> selectedMouthShape = mouthShapeComboBox.getValue());
    faceColorPicker.setOnAction(event -> faceColor = faceColorPicker.getValue());
    eyeColorPicker.setOnAction(event -> eyeColor = eyeColorPicker.getValue());
    mouthColorPicker.setOnAction(event -> mouthColor = mouthColorPicker.getValue());
}

    private void drawFace(Pane root, String faceShape, String eyeShape, String mouthShape, Color faceColor, Color eyeColor, Color mouthColor) {
       

              root.getChildren().clear();
              if (faceShape.equals("Rectangle")) {
            Rectangle face = new Rectangle(50, 50, 200, 200);
            face.setFill(faceColor);
            root.getChildren().add(face);
        } else if (faceShape.equals("Circle")) {
            Circle face = new Circle(150, 150, 100);
            face.setFill(faceColor);
            root.getChildren().add(face);
        }

        if (eyeShape.equals("Rectangle")) {
            Rectangle leftEye = new Rectangle(100, 100, 35, 35);
            leftEye.setFill(eyeColor);
            root.getChildren().add(leftEye);

            Rectangle rightEye = new Rectangle(165, 100, 35, 35);
            rightEye.setFill(eyeColor);
            root.getChildren().add(rightEye);
        } else if (eyeShape.equals("Circle")) {
            Circle leftEye = new Circle(117.5, 117.5, 17.5);
            leftEye.setFill(eyeColor);
            root.getChildren().add(leftEye);

            Circle rightEye = new Circle(182.5, 117.5, 17.5);
            rightEye.setFill(eyeColor);
            root.getChildren().add(rightEye);
        }

        if (mouthShape.equals("Rectangle")) {
            Rectangle mouth = new Rectangle(110, 160, 80, 20);
            mouth.setFill(mouthColor);
            root.getChildren().add(mouth);
        } else if (mouthShape.equals("Circle")) {
            Circle mouth = new Circle(150, 170, 40);
            mouth.setFill(mouthColor);
            root.getChildren().add(mouth);
        }
        
    }
}
