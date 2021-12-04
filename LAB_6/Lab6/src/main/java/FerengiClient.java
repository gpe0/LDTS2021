public class FerengiClient extends AlienClient{

    @Override
    protected OrderingStrategy createOrderingStrategy() {
        SmartStrategy ss = new SmartStrategy();
        return ss;
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        super.wants(drink, recipe, bar);
    }

    @Override
    public void happyHourStarted(Bar bar) {
        super.happyHourStarted(bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        super.happyHourEnded(bar);
    }


}
