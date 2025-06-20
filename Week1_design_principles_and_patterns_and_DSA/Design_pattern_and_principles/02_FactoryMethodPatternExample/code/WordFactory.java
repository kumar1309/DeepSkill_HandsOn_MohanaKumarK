//It extends DOcumentfactory and implements creteDocument()
public class WordFactory extends DocumentFactory{
    public Document createDocument(){
        return new WordDocument();
    }
}