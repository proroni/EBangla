package root.android.workspaceit.com.ebangla.View.UI.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.Preferance.IPreferance;
import root.android.workspaceit.com.ebangla.Model.Preferance.PreferanceEBangla;
import root.android.workspaceit.com.ebangla.Model.TopListedBooks;
import root.android.workspaceit.com.ebangla.Presenter.BooksPresenter;
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.IAdapterBookView;
import root.android.workspaceit.com.ebangla.View.IBooksView;
import root.android.workspaceit.com.ebangla.View.IPreferenceView;
import root.android.workspaceit.com.ebangla.View.UI.Adapter.AdapterTopBookList;

public class ActivityBookDetails extends AppCompatActivity implements IAdapterBookView,IBooksView {
    Intent intent;
    Books book;
    TopListedBooks topBook;
    Button btnLike;
    Button btnCart;
    TextView name,writer,category,price;
    ImageView bookImg;
    RecyclerView rc_suggestBook;
    AdapterTopBookList adapterTopBookList;
    List<TopListedBooks> topListedBooksList;
    BooksPresenter presenter;
    PreferanceEBangla preferanceEBangla;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        presenter=new BooksPresenter(this);
        preferanceEBangla=new PreferanceEBangla(getApplicationContext());
        resoursesSetup();
        setTopBookAdapter();
        setBookList();
        intent = getIntent();

         book = (Books) intent.getSerializableExtra("bookData");

         if(intent.getSerializableExtra("bookData")!=null){
             book = (Books) intent.getSerializableExtra("bookData");

             showBookData(book);
         }
         else if(intent.getSerializableExtra("topBookData")!=null){
             topBook = (TopListedBooks) intent.getSerializableExtra("topBookData");

             showBookData(topBook);
         }
         btnCart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 preferanceEBangla.addBook(getApplicationContext(),book);
             }
         });







    }

    private void setBookList() {
    }

    void resoursesSetup(){

        name=findViewById(R.id.name);
        writer=findViewById(R.id.writer);
        category=findViewById(R.id.category);
        price=findViewById(R.id.price);
        bookImg=findViewById(R.id.img);
        rc_suggestBook=findViewById(R.id.new_book);
        btnCart=findViewById(R.id.btn_cart);

    }


    private void showBookData(Books book) {
     name.setText(book.getBooksName());
     writer.setText(book.getBooksWriter());
     category.setText(book.getBooksCategory());
     price.setText(Integer.toString(book.getBooksPrice()));
     bookImg.setImageResource(book.imageId());

    }

    private void showBookData(TopListedBooks book) {
        name.setText(book.getBooksName());
        writer.setText(book.getBooksWriter());
        category.setText(book.getBooksCategory());
        price.setText(Integer.toString(book.getBooksPrice()));
        bookImg.setImageResource(book.imageId());

    }

    @Override
    public void setBookAdapter() {

    }

    @Override
    public void setTopBookAdapter() {
        adapterTopBookList= new AdapterTopBookList(getApplicationContext(),topListedBooksList);//
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayout.HORIZONTAL,false);
        rc_suggestBook.setLayoutManager(linearLayoutManager);
        rc_suggestBook.setHasFixedSize(true);
        rc_suggestBook.setAdapter(adapterTopBookList);
    }

    @Override
    public void setBookCategory() {

    }

    @Override
    public void getBooksList(List<Books> books) {

    }

    @Override
    public void getTopBooksList(List<TopListedBooks> books) {
        this.topListedBooksList=books;

    }

    @Override
    public void getBookCategory(List<String> category) {

    }

}
