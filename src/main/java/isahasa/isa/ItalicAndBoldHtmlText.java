package isahasa.isa;

public class ItalicAndBoldHtmlText extends BoldHtmlText {

    public ItalicAndBoldHtmlText(String plainText) {
        super(plainText);
    }

    @Override
    public String getPlainText() {
        return "<i>" + super.getPlainText() + "</i>";
    }
}
