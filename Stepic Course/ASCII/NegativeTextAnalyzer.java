package ASCII;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private String[] keywords;
    public NegativeTextAnalyzer () {keywords = new String[] { ":(", "=(", ":|"};}

    @Override
    protected Label getLabel() {return Label.NEGATIVE_TEXT;}

    @Override
    public String[] getKeywords() {return keywords;}
}
