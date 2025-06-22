public class Books{
    int book_id;
    String book_name;
    String author_name;
    public Books(int book_id, String book_name, String author_name){
        this.book_id = book_id;
        this.book_name = book_name;
        this.author_name = author_name;
    }
    public void display(){
        System.out.println("Book ID: " + book_id);
        System.out.println("Book Name: " + book_name);
        System.out.println("Author Name: " + author_name);
    }
}