package seb.xmpl.micro.spellbook.db;

import io.ebean.Model;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class DSpell extends Model {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<DIncantation> incantations;
}
