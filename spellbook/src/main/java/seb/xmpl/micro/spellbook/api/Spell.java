package seb.xmpl.micro.spellbook.api;


import lombok.Data;

import java.util.List;

@Data
public class Spell {
    private final String name;
    private final List<Incantation> incantations;
}
