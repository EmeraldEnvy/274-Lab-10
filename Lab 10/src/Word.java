public class Word {
    /**
     * Initialize word
     */
    private String word;
    /**
     * Initialize frequency
     */
    private int frequency;

    /**
     * Word constructor
     * @param d string
     */
    public Word( String d ){
        word = d;
        frequency = 0;
    }

    /**
     * Turns word into string
     * @return
     */
    @Override
    public String toString(){
        return word + " → " + frequency;
    }

    /**
     * Compare to words
     * @param w word
     * @return compare value
     */
    public int compareTo ( Word w ){
        return this.word.compareTo( w.word );
    }

    /**
     * Increments frequency
     */
    public void incFrequency(){
        frequency = frequency + 1;
    }


}
