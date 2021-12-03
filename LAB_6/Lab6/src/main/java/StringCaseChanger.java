public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String newString = "";
        for (int i = 0; i < drink.getText().length(); i++) {

            char c = drink.getText().charAt(i);
            if (Character.isLowerCase(c)) {
                newString += Character.toUpperCase(c);
            } else {
                newString += Character.toLowerCase(c);
            }
        }
        drink.setText(newString);
    }
}
