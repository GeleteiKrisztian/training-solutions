package isahasa.hasa;

import isahasa.TextSource;

public class Bold extends TextDecorator {

    public Bold(TextSource textSource) {
        super.textSource = textSource;
    }

    @Override
    public String getPlainText() {
        return "<b>" + textSource.getPlainText() + "</b>";
    }
}
