package seb.xmpl.micro.todo.db;

import io.ebean.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import seb.xmpl.micro.todo.api.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DTask extends Model {
    @Id
    private final UUID id;
    private final String name;
    private final TaskStatus status;
    private final String description;
}
