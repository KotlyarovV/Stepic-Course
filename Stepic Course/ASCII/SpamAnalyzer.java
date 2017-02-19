package ASCII;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private  String[] keywords;
    public SpamAnalyzer (String[] str) {this.keywords = str;}
    public String[] getKeywords() {return keywords;}
    @Override
    protected Label getLabel() {return Label.SPAM;}
}
