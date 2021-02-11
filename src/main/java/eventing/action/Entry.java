package eventing.action;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@Builder
@ToString
@AllArgsConstructor
public class Entry {
    private Instant when;
    private ActionType actionType;
    private String content;
}
