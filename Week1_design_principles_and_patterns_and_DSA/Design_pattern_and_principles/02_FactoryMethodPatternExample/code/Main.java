//It interacts with the Documentfactory 
public class Main{
    public static void main(String[] args){
        DocumentFactory word_factory=new WordFactory();
        Document word=word_factory.createDocument();
        word.open();
        DocumentFactory excel_factory=new ExcelFactory();
        Document excel=excel_factory.createDocument();
        excel.open();
        DocumentFactory pdf_factory=new PdfFactory();
        Document pdf=pdf_factory.createDocument();
        pdf.open();
    }
}