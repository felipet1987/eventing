package eventing.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.function.Consumer;

@AllArgsConstructor
@Data
@ToString
public class XYPosition {
    private Direction direction;
    private int x;
    private int y;

    public void move(Direction direction,int steps) {

        HashMap<Direction, Consumer<Integer>> moves = new HashMap<>();
        moves.put(Direction.LEFT, (s) -> x = x + s);
        moves.put(Direction.RIGHT,(s) -> x = x - s);
        moves.put(Direction.NORTH,(s) -> y = y + s);
        moves.put(Direction.SOUTH,(s) -> y = y - s);

        moves.get(direction).accept(steps);
    }
}
