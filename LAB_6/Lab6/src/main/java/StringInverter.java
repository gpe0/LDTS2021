public class StringInverter implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder newString = new StringBuilder(drink.getText());
        drink.setText(newString.reverse().toString());
    }
}
