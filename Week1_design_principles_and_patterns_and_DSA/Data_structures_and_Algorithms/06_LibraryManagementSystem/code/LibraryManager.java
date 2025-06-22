public class LibraryManager{
    Books[] books;
    public LibraryManager(Books[] books){
        this.books = books;
    }
    public void linear_search(int book_id){
        for(int i = 0; i < books.length; i++){
            if(books[i].book_id == book_id){
                System.out.println("Book found:");
                books[i].display();
                return;
            }
        }
        System.out.println("Book not found.");
    }
    public void binary_search(int book_id){
        int left = 0;
        int right = books.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(books[mid].book_id == book_id){
                System.out.println("Book found:");
                books[mid].display();
                return;
            }
            if(books[mid].book_id < book_id){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }
    public void sort_books(){
        for(int i = 0; i < books.length - 1; i++){
            for(int j = 0; j < books.length - i - 1; j++){
                if(books[j].book_id > books[j + 1].book_id){
                    Books temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
        System.out.println("Books sorted by ID.");
    }
    public void display_books(){
        for(Books book : books){
            book.display();
        }
    }
}