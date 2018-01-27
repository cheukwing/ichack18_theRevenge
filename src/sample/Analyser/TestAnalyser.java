package sample.Analyser;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TestAnalyser implements Analyser {
  private int curr = 0;
  private final List<String> ingredients = new ArrayList<>();

  public TestAnalyser() {
    ingredients.add("pasta");
    ingredients.add("tomato");
    ingredients.add("mushroom");
  }

  @Override
  public String extractIngredient(BufferedImage image) {
    return ingredients.get(curr++);
  }
}
