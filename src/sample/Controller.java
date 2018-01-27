package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import sample.Analyser.Analyser;
import sample.Analyser.TestAnalyser;
import sample.IngredientList.BasicIngredientList;
import sample.IngredientList.IngredientList;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Controller {
  public Label displayIngredient;
  private final Analyser analyser = new TestAnalyser();
  private final IngredientList ingredientList = new BasicIngredientList();

  public void uploadImage(ActionEvent actionEvent) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choose an image");
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
    try {
      BufferedImage image = ImageIO.read(fileChooser.showOpenDialog(Main.getPrimaryStage()));
      ingredientList.addToList(analyser.extractIngredient(image));
    } catch (IOException e) {
      e.printStackTrace();
    }
    updateDisplayIngredient();
  }

  public void nextDisplay(ActionEvent actionEvent) {
    ingredientList.incrementDisplay();
    updateDisplayIngredient();
  }

  private void updateDisplayIngredient() {
    displayIngredient.setText(ingredientList.getCurrentDisplayed());
  }

  public void removeIngredient(ActionEvent actionEvent) {
    ingredientList.removeDisplayed();
    updateDisplayIngredient();
  }
}
