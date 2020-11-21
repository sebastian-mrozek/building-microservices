package seb.xmpl.micro.tasklist.db;

import io.ebean.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import seb.xmpl.micro.tasklist.api.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DTask extends Model {
    @Id
    private UUID id;
    private String name;
    private TaskStatus status;
    private String description;
}
