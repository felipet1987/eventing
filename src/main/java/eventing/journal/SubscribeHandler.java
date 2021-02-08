package eventing.journal;

import com.google.common.eventbus.Subscribe;
import eventing.command.event.BaseEvent;


public interface SubscribeHandler {
    @Subscribe
    public void subscribe(BaseEvent event);
}
