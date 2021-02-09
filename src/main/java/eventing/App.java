
package eventing;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import eventing.action.ActionType;
import eventing.action.Entry;
import eventing.core.Action;
import eventing.core.Direction;
import eventing.core.Handler;
import eventing.journal.Record;

import java.time.Instant;


public class App {




    public static void main(String[] args) {

        Record record = new Record(new EventBus());

        Turtle turtle = new Turtle("jorge",record);

        turtle.move(new Move(Direction.NORTH,5));
        turtle.move(new Move(Direction.LEFT,5));


















    }


}
