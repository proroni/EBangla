package root.android.workspaceit.com.ebangla.View;

import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.TopListedBooks;

public interface IBooksView  {

    void getBooksList( List<Books> books);
    void getTopBooksList(List<TopListedBooks> books);
    void getBookCategory(List<String> category);
}
