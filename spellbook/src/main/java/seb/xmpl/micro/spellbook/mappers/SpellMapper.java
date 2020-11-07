package seb.xmpl.micro.spellbook.mappers;

import org.mapstruct.Mapper;
import seb.xmpl.micro.spellbook.api.Spell;
import seb.xmpl.micro.spellbook.db.DSpell;

@Mapper
public abstract class SpellMapper {
    public abstract DSpell toDSpell(Spell spell);
}
