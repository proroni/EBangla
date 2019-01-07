package root.android.workspaceit.com.ebangla.View.UI.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.TopListedBooks;
import root.android.workspaceit.com.ebangla.Presenter.BooksPresenter;
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.IAdapterBookView;
import root.android.workspaceit.com.ebangla.View.IBooksView;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterBookList;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterCategoryList;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterTopBookList;

public class Fragmenthome extends Fragment implements IBooksView,IAdapterBookView {

    RecyclerView rcTopratedlist;
    RecyclerView rcBookList;
    RecyclerView rcBookCategory;
    AdapterBookList adapterBookList;
    AdapterTopBookList adapterTopBookList;
    AdapterCategoryList adapterCategoryList;
    BooksPresenter presenter;
    List<Books> books=new ArrayList<>();
    List<TopListedBooks> topListedBooksList=new ArrayList<>();
    List<String> bookCategory=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcTopratedlist= view.findViewById(R.id.rc_top_rated);
        rcBookList=view.findViewById(R.id.rc_book_list);
        rcBookCategory=view.findViewById(R.id.rc_category);

        presenter= new BooksPresenter(this);

        setBookAdapter();
        setTopBookAdapter();
        setBookCategory();

        return view;
        }

    @Override
    public void getBooksList(List<Books> books) {
        this.books=books;
    }

    @Override
    public void getTopBooksList(List<TopListedBooks> Topbooks) {
        this.topListedBooksList=Topbooks;

    }

    @Override
    public void getBookCategory(List<String> category) {
        this.bookCategory=category;

    }

    @Override
    public void setBookAdapter() {
        adapterBookList= new AdapterBookList(getContext(),books);//
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        rcBookList.setLayoutManager(linearLayoutManager);
        rcBookList.setHasFixedSize(true);
        rcBookList.setNestedScrollingEnabled(false);
        rcBookList.setAdapter(adapterBookList);
    }

    @Override
    public void setTopBookAdapter() {
        adapterTopBookList= new AdapterTopBookList(getContext(),topListedBooksList);//
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayout.HORIZONTAL,false);
        rcTopratedlist.setLayoutManager(linearLayoutManager);
        rcTopratedlist.setHasFixedSize(true);
        rcTopratedlist.setAdapter(adapterTopBookList);
    }

    @Override
    public void setBookCategory() {
        adapterCategoryList= new AdapterCategoryList(getContext(),bookCategory);//
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayout.HORIZONTAL,false);
        rcBookCategory.setLayoutManager(linearLayoutManager);
        rcBookCategory.setHasFixedSize(true);
        rcBookCategory.setAdapter(adapterCategoryList);
    }
}
