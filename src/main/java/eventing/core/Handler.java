package eventing.core;

import eventing.action.Entry;

@FunctionalInterface
public interface Handler {
    void handle(Entry metadata);
}
