package easy;


public class MergeStringAlternately {

    String merge(String word1, String word2, String mergedWord) {
        if (word1.length() <= 0 && word2.length() <= 0) return mergedWord;
        else {
            if (word1.length() <=0 && word2.length() > 0)
                return merge(word1, word2.substring(1), mergedWord + word2.charAt(0));
            else if (word2.length() <=0 && word1.length() > 0)
                return merge(word1.substring(1), word2, mergedWord + word1.charAt(0));
            else return merge(word1.substring(1), word2.substring(1),
                        mergedWord + word1.charAt(0) + word2.charAt(0));
        }
    }

    public String mergeAlternately(String word1, String word2) {
        return merge(word1, word2, "");
    }
}
