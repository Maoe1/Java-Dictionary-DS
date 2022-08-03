public class WordInfo {
    public String word;
    public String meaning;
    public WordInfo left;
    public WordInfo right;


    public WordInfo(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
        left = right = null;
    }

    
    
}
