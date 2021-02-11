package eventing.core;

import eventing.action.ActionType;
import eventing.record.Reaction;

public interface Record {
    void send(ActionType actionType, String content);
    void register(Reaction reaction);
}
