package eventing.action;


import eventing.core.Action;
import eventing.core.Handler;
import eventing.core.Reaction;
import eventing.journal.Record;


public class Actor {



    private final Record record;
    private final String name;

    public Actor(String name, Record record) {
        this.name = name;
        this.record = record;
    }

    public void react(Handler handler) {
        record.register(handler);
    }

    public void act(Action action, String content) {
        action.execute(record, content);
    }
}
