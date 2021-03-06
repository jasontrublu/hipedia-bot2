package de.c_peper.hipedia.bot2.Processor;

import de.c_peper.hipedia.bot2.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by trublu on 20/11/15.
 */
public class SamtgemeindeProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SamtgemeindeProcessor.class);

    /**
     * Process input string.
     *
     * @param page the input page.
     * @return the processed string.
     */
    public static Page process(Page page) {
        // remove everything after first paragraph
        String input = "{{Wikipedia-Logo}}\n" + page.getText();
        input = input.replaceAll("(?s)==.*", "");
        // replace Gemeinde template
        input = input.replaceAll("Infobox Gemeindeverband in Deutschland", "Infobox Gemeinde");
        // remove empty lines
        input = input.replaceAll("(?s)\n\n", "");
        input += "\n\n<br/><small>Inhalt abgerufen von [" + page.getSourceURLAsLink() + " Wikipedia:" + page.getName() + "] </small>";
        input += "\n[[Kategorie:Gemeinde]]\n";
        page.setText(input);
        return page;
    }

}
