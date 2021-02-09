package eventing.core;

public interface Reaction {
    void subscribe(Handler handler);
}
