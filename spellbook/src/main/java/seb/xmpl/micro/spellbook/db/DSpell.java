package seb.xmpl.micro.spellbook.db;

import io.ebean.Model;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DSpell extends Model {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<DIncantation> incantations;
}
