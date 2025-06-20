//It extends DOcumentfactory and implements creteDocument()
public class PdfFactory extends DocumentFactory{
    public Document createDocument(){
        return new PdfDocument();
    }
}