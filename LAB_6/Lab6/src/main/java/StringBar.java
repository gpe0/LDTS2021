import java.util.List;

public class StringBar extends Bar {

    public boolean isHappyHour() {return happyHour;}
    public void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }
    public void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}
