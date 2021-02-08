package eventing.command.event;

import eventing.command.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@Builder
@ToString
@AllArgsConstructor
public class BaseEvent {
    private Instant sent;
    private Action action;
    private String payload;
}
