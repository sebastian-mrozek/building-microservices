package seb.xmpl.micro.tasklist.db;

import io.ebean.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DTaskList extends Model {
    @Id
    private final UUID id;
    private final String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "listId")
    private final List<DTask> tasks;
}
