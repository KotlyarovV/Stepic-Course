package ASCII;

public abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();
    protected abstract Label getLabel();
    public Label processText (String str) {
        boolean ok = true;
        for ( String word : this.getKeywords())
            ok = (!str.contains(word));
        return (ok) ? Label.OK : getLabel();
    }
}
