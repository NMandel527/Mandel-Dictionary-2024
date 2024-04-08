package mandel.dictionary;

public class Main {
    public static void main(String[] args) {
        EnglishDictionaryFrame edf;
        try {
            edf = new EnglishDictionaryFrame();
            edf.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}