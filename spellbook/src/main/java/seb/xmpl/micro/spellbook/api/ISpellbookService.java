package seb.xmpl.micro.spellbook.api;

import seb.xmpl.micro.spellbook.api.Incantation;
import seb.xmpl.micro.spellbook.api.Spell;

public interface ISpellbookService {

    void addSpell(Spell spell);

    Spell getSpell(String name);

    void addIncantation(Incantation incantation);

    Incantation getIncantation(String name);
}
