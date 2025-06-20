//It extends DOcumentfactory and implements creteDocument()
public class ExcelFactory extends DocumentFactory{
    public Document createDocument(){
        return new ExcelDocument();
    }
}