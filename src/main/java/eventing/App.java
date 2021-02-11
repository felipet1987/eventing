
package eventing;

import com.google.common.eventbus.EventBus;
import eventing.core.Direction;
import eventing.core.Move;
import eventing.core.Turtle;
import eventing.record.EventRecord;
import eventing.core.Record;


public class App {




    public static void main(String[] args) {

        Record record = new EventRecord(new EventBus());

        Turtle turtle = new Turtle("jorge",record);
        World world = new World(record);

        turtle.setup();



        turtle.move(new Move(Direction.NORTH,5));
        turtle.showPosition();
        turtle.move(new Move(Direction.LEFT,5));
        turtle.showPosition();

        























    }


}
