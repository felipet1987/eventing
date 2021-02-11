package eventing.core;

import com.google.gson.Gson;
import eventing.core.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Move {
    private final Direction direction;
    private final int steps;


}
