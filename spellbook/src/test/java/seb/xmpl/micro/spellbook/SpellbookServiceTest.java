package seb.xmpl.micro.spellbook;

import io.ebean.DB;
import org.junit.jupiter.api.Test;
import seb.xmpl.micro.spellbook.api.Spell;
import seb.xmpl.micro.spellbook.db.DIncantation;
import seb.xmpl.micro.spellbook.db.DSpell;
import seb.xmpl.micro.spellbook.db.query.QDSpell;

import java.util.Collections;

public class SpellbookServiceTest {

    SpellbookService service = new SpellbookService();

    @Test
    public void testAdd() {
        service.addSpell(new Spell("some", Collections.emptyList()));
    }

    @Test
    public void shouldAnswerWithTrue() {

        DSpell myFirstSpell = generateSpell("make some beer", "abeercadabra");
        DB.save(myFirstSpell);

        DSpell mySecondSpell = generateSpell("turn target into a fish", "magicos pescos");
        DB.save(mySecondSpell);

        new QDSpell().findList().forEach(System.out::println);


    }

    private DSpell generateSpell(String spellName, String incantationName) {
        DIncantation incantation = new DIncantation();
        incantation.setName(incantationName);
        return DSpell.builder()
                .name(spellName)
                .incantations(Collections.singletonList(incantation))
                .build();
    }
}
