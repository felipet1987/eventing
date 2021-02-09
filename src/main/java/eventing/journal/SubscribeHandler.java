package eventing.journal;

import com.google.common.eventbus.Subscribe;
import eventing.action.Entry;


public interface SubscribeHandler {
    @Subscribe
    public void subscribe(Entry event);
}
