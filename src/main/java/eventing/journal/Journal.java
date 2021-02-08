package eventing.journal;

import com.google.common.eventbus.EventBus;
import eventing.command.event.BaseEvent;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Journal {

    private EventBus eventBus;

    public void send(BaseEvent event) {
        eventBus.post(event);
    }

    public void register(Handler handler) {
        eventBus.register((SubscribeHandler) handler::handle);
    }

}
