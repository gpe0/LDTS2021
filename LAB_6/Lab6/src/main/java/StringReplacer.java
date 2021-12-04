public class StringReplacer implements StringTransformer {

    private char cOld;
    private char cNew;

    public StringReplacer(char cOld, char cNew) {
        this.cOld = cOld;
        this.cNew = cNew;
    }

    @Override
    public void execute(StringDrink drink) {
        String newString = drink.getText();
        newString = newString.replace(cOld, cNew);
        drink.setText(newString);
    }

    @Override
    public void undo(StringDrink drink) {
        String newString = drink.getText();
        newString = newString.replace(cNew, cOld);
        drink.setText(newString);
    }
}
