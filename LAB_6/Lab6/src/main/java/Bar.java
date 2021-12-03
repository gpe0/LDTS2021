import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Bar {

    protected boolean happyHour;

    protected List<BarObserver> observers;

    public Bar() {
        observers = new ArrayList<>();
    }

    public Bar(List<BarObserver> observers) {
        this.observers = observers;
    }



    public boolean isHappyHour() {return happyHour;};
    public void startHappyHour() {};
    public void endHappyHour() {};

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }
    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }

}
