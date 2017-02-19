package ASCII;

public class Main {
    public static void main (String [] args) {
        System.out.print(new AsciiCharSequence(new byte [] {33,34,35}).subSequence(0,2));
        System.out.print(new AsciiCharSequence(new byte [] {33,34,35}).length());
        System.out.print(new AsciiCharSequence(new byte [] {33,34,35}).charAt(2));
        System.out.print(new AsciiCharSequence(new byte [] {33,34,35}).toString());
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer an : analyzers)
            if (an.processText(text) != Label.OK)
                return an.processText(text);
        return Label.OK;
    }


}
