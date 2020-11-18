package seb.xmpl.micro.spellbook;

import org.mapstruct.factory.Mappers;
import seb.xmpl.micro.spellbook.api.ISpellbookService;
import seb.xmpl.micro.spellbook.api.Incantation;
import seb.xmpl.micro.spellbook.api.Spell;
import seb.xmpl.micro.spellbook.db.DSpell;
import seb.xmpl.micro.spellbook.db.query.QDSpell;
import seb.xmpl.micro.spellbook.mappers.SpellMapper;

import java.util.Collections;

public class SpellbookService implements ISpellbookService {

    SpellMapper spellMapper = Mappers.getMapper(SpellMapper.class);

    @Override
    public void addSpell(Spell spell) {
        DSpell dSpell = spellMapper.toDSpell(spell);
        dSpell.save();
    }

    private DSpell mapSpell(Spell spell) {
        return new DSpell().setName(spell.getName());
    }

    @Override
    public Spell getSpell(String name) {
        DSpell dSpell = new QDSpell().name.eq(name).findOne();
        return mapDSpell(dSpell);
    }

    private Spell mapDSpell(DSpell dSpell) {
        if (dSpell == null) {
            return null;
        }
        return new Spell(dSpell.getName(), Collections.emptyList());
    }

    @Override
    public void addIncantation(Incantation incantation) {
    }

    @Override
    public Incantation getIncantation(String name) {
        return null;
    }
}
