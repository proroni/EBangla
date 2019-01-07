package root.android.workspaceit.com.ebangla.View.UI.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.TopListedBooks;
import root.android.workspaceit.com.ebangla.Presenter.BooksPresenter;
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.IAdapterBookView;
import root.android.workspaceit.com.ebangla.View.IBooksView;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterBookList;

public class ActivityCategoryBookList extends AppCompatActivity implements IAdapterBookView,IBooksView {
    RecyclerView recyclerView;
    AdapterBookList adapterBookList;
    List<Books> books=new ArrayList<>();
    BooksPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caterory);


        recyclerView=findViewById(R.id.rc_category_book_list);
        presenter=new BooksPresenter(this);
        setBookAdapter();

    }

    @Override
    public void setBookAdapter() {
        adapterBookList= new AdapterBookList(ActivityCategoryBookList.this,books);//
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ActivityCategoryBookList.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapterBookList);
    }

    @Override
    public void setTopBookAdapter() {

    }

    @Override
    public void setBookCategory() {

    }

    @Override
    public void getBooksList(List<Books> books) {
        this.books=books;
    }

    @Override
    public void getTopBooksList(List<TopListedBooks> books) {

    }

    @Override
    public void getBookCategory(List<String> category) {

    }
}
