package eventing.command.request;

import eventing.core.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoveRequest {
    private int steps;
    private Direction direction;
}
