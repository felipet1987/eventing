package eventing;

import com.google.gson.Gson;
import eventing.action.ActionType;
import eventing.action.Actor;
import eventing.action.Entry;
import eventing.core.Action;
import eventing.core.Direction;
import eventing.core.Handler;
import eventing.core.XYPosition;
import eventing.journal.Record;

import java.time.Instant;

public class Turtle extends Actor {
    private final XYPosition position;

    public Turtle(String name, Record record) {
        super(name,record);
        position = new XYPosition(Direction.LEFT, 0, 0);

        react(entry -> {
            Move move = fromJson(entry);
            position.move(move.getDirection(), move.getSteps());
        });
        react(entry -> {
            System.out.println(position.toString());
        });

    }




    public void move(Move move) {

        Action action = (journal, content) -> {
            journal.send(Entry.builder()
                    .when(Instant.now())
                    .actionType(ActionType.MOVE)
                    .content(content).build());
        };
        act(action, toJson(move));
    }

    private String toJson(Move move) {
        return new Gson().toJson(move);
    }
    public Move fromJson(Entry entry) {
        return new Gson().fromJson(entry.getContent(), Move.class);
    }
}
