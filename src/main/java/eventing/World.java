package eventing;

import eventing.action.ActionType;
import eventing.action.Actor;
import eventing.core.Record;

public class World extends Actor {
    public World(Record record) {
        super(record);
    }
    @Override
    public void setup() {
        onAction(ActionType.USE, e ->  {

        });
        onReceive();

    }
}
