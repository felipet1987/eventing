package eventing.command;


import eventing.command.event.BaseEvent;
import eventing.journal.Handler;
import eventing.journal.Journal;

import java.time.Instant;
import java.util.HashMap;
import java.util.function.Consumer;


public class Actor {

    private final Journal journal;
    protected  HashMap<Action, Consumer<BaseEvent>> handlers;

    public Actor(Journal journal) {
        this.journal = journal;
        handlers  = new HashMap<>();
        subscribe((event) -> handlers.get(event.getAction()).accept(event));
    }

    public void publish(Action action,String payload) {
        journal.send(BaseEvent.builder()
                .sent(Instant.now())
                .action(action)
                .payload(payload)
                .build());
    }
    public void subscribe(Handler handler) {
        journal.register(handler);
    }

    public void show() {
        publish(Action.SHOW,"");
    }
}
