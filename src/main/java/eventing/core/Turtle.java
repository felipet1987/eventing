package eventing.core;

import com.google.gson.Gson;
import eventing.command.Action;
import eventing.command.Actor;
import eventing.command.event.BaseEvent;
import eventing.command.request.MoveRequest;
import eventing.journal.Journal;

import java.time.Instant;


public class Turtle extends Actor {


    private  XYPosition position;

    public Turtle(Journal journal) {
        super(journal);
        position = new XYPosition(Direction.LEFT,0,0);

        handlers.put(Action.MOVE,(e) -> {
            final MoveRequest request = new Gson().fromJson(e.getPayload(), MoveRequest.class);
            position.move(request);
        });
        handlers.put(Action.SHOW,(e) -> System.out.println(position.toString()));
    }

    public void move(int steps,Direction direction) {
        final String payload = new Gson().toJson(new MoveRequest(steps, direction));
        publish(Action.MOVE,payload);
    }



}
