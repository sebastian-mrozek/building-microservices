package seb.xmpl.micro.spellbook.db;

import io.ebean.Model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DIncantation extends Model {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    private String name;
}
