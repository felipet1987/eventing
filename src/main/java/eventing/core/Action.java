package eventing.core;

import eventing.journal.Record;

public interface Action {
    void execute(Record record, String content);
}
