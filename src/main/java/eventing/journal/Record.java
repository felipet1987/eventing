package eventing.journal;

import com.google.common.eventbus.EventBus;
import eventing.action.Entry;
import eventing.core.Handler;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Record {

    private EventBus eventBus;

    public void send(Entry event) {
        eventBus.post(event);
    }

    public void register(Handler handler) {
        eventBus.register((SubscribeHandler) handler::handle);
    }

}
