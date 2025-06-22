public class Main{
    public static void main(String[] args) {
    Books[] books = {
        new Books(1, "Physis ", "Mohan"),
        new Books(2, "DSA using Python", "Kumar"),
        new Books(3, "Maths", "Thirisha"),
        new Books(4, "Java", "Raj"),
        new Books(5, "Spring", "Ram")
    };

    LibraryManager library_Manager = new LibraryManager(books);
    System.out.println("Welcome to the Library Management System!");
    System.out.println("Available books:");
    library_Manager.display_books();
    System.out.println("searching  for book using linear search ,  the book ID is '3'");
    int book_id = 3;
    library_Manager.linear_search(book_id);
    System.out.println("searching  for book using binary search ,  the book ID is '2'");
    library_Manager.sort_books();
    book_id = 2; 
    library_Manager.binary_search(book_id);
    }
    
}