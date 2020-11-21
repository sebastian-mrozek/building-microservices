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
public class DWorkspace extends Model {
    @Id
    private UUID id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "workspaceId")
    private List<DTaskList> lists;
}
