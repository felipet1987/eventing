package eventing.action;


import com.google.gson.Gson;
import eventing.core.Record;

import java.util.HashMap;
import java.util.function.Consumer;


public class Actor {

    private Record record;
    protected HashMap<ActionType, Consumer<Entry>> consumers;

    public Actor(Record record) {
        this.record = record;
        consumers = new HashMap<>();
    }

    public void onAction(ActionType actionType,Consumer<Entry> entryConsumer) {
        consumers.put(actionType, entryConsumer);
    }

    public void setup() {

    }

    public void onReceive() {
        record.register((e) -> {
            try {
                consumers.get(e.getActionType()).accept(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public void tell(ActionType actionType,String content) {
        record.send(actionType,content);
    }

    public String content(Object o) {
        return new Gson().toJson(o,o.getClass());
    }

    public Object EntryTo(Entry e, Class classOfT) {
        return new Gson().fromJson(e.getContent(), classOfT);
    }



}
