package ASCII;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;
    public TooLongTextAnalyzer(int a) {this.maxLength = a;}
    @Override
    public Label processText(String text) {
        return (text.length() > this.maxLength) ? Label.TOO_LONG : Label.OK;
    }
}
