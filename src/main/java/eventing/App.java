
package eventing;

import com.google.common.eventbus.EventBus;
import eventing.command.Action;
import eventing.core.Direction;
import eventing.core.Turtle;
import eventing.journal.Journal;


public class App {


    public static void main(String[] args) {

        Journal journal = new Journal(new EventBus());

        Turtle turtle = new Turtle(journal);



        turtle.move(4, Direction.LEFT);
        turtle.move(8, Direction.NORTH);
        turtle.move(8, Direction.SOUTH);

        turtle.show();

//        turtle.move(10, Direction.NORTH);
//        turtle.move(5, Direction.SOUTH);








    }
}
