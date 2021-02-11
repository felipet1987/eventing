package eventing.record;

import com.google.common.eventbus.EventBus;
import eventing.action.ActionType;
import eventing.action.Entry;
import eventing.core.Record;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventRecord  implements Record {

    private EventBus eventBus;

    public void send(ActionType actionType, String content) {
        eventBus.post(Entry.builder().actionType(actionType).content(content).build());
    }

    public void register(Reaction reaction) {
        eventBus.register(reaction);
    }

}
