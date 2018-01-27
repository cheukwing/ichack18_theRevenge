package sample.IngredientList;

import java.util.ArrayList;
import java.util.List;

public class BasicIngredientList implements IngredientList {
  private final List<String> ingredients = new ArrayList<>();
  private int displayIdx = -1;

  @Override
  public String getCurrentDisplayed() {
    if (displayIdx < 0 || ingredients.isEmpty()) {
      return "";
    }
    return ingredients.get(displayIdx);
  }

  @Override
  public void incrementDisplay() {
    displayIdx = displayIdx + 1 > ingredients.size() - 1 ? 0 : displayIdx + 1;
  }

  @Override
  public void removeDisplayed() {
    ingredients.remove(displayIdx);
    displayIdx--;
  }

  @Override
  public void addToList(String ingredient) {
    ingredients.add(ingredient);
    displayIdx++;
  }
}
