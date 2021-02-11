package eventing.record;

import com.google.common.eventbus.Subscribe;
import eventing.action.Entry;


public interface Reaction {
    @Subscribe
    public void consume(Entry event);
}
