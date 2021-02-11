package eventing.core;

import eventing.Tool;
import eventing.action.ActionType;
import eventing.action.Actor;
import eventing.action.Entry;


public class Turtle extends Actor {
    public static final String NO_CONTENT = "noContent";
    private final XYPosition position;
    private Tool tool;
    private String name;

    public Turtle(String name, Record record) {
        super(record);
        this.name = name;
        this.position = new XYPosition(Direction.LEFT,0,0);
    }


    @Override
    public void setup() {
        onAction(ActionType.MOVE, this::react);
        onAction(ActionType.SHOW, e ->  System.out.println(position));

        onReceive();

    }
    public void react(Entry e) {
        Move move = (Move) EntryTo(e,Move.class);
        position.move(move.getDirection(),move.getSteps());
    }



    public void move(Move move) {
        tell(ActionType.MOVE, content(move));
    }

    public void showPosition() {
        tell(ActionType.SHOW,NO_CONTENT);
    }



}
