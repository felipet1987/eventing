package eventing.journal;

import eventing.command.event.BaseEvent;

@FunctionalInterface
public interface Handler {
    void handle(BaseEvent payload);
}
