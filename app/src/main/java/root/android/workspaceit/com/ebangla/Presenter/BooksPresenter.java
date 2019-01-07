package root.android.workspaceit.com.ebangla.Presenter;


import java.util.ArrayList;
import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.TopListedBooks;
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.IBooksView;

public class BooksPresenter implements IBookPresenter {


    IBooksView booksView;
    List<Books> booklist=new ArrayList<>();
    List<TopListedBooks> topListedBooksList=new ArrayList<>();
    List<String> bookCategory=new ArrayList<>();

    public BooksPresenter(IBooksView booksView) {
        this.booksView=booksView;
        setBooksList();
        setTopListedBooks();
        setBookCategory();
        getData();
    }
    public BooksPresenter() {
        setBooksList();
        setTopListedBooks();
    }

    private void getData() {
        booksView.getBooksList(booklist);
        booksView.getTopBooksList(topListedBooksList);
        booksView.getBookCategory(bookCategory);
    }


    @Override
    public void setBooksList() {
        booklist.add(new Books("দ্বিতীয় বিশ্বযুদ্ধ", "মেজর মোঃ দেলোয়ার হোসেন ", "নালন্দা ", "অনুবাদ: জীবনী, স্মৃতিচারণ ও সাক্ষাৎকার ", 298, "2018", "1st Published, 2018", R.drawable.book1));
        booklist.add(new Books("গণতন্ত্র ও মানুষের মানবাধিকার", "বিচারপতি মুহাম্মদ হাবিবুর রহমান ", " মহাকাল  ", " গণতন্ত্র ", 126, "2018", "2nd Published, 2018",R.drawable.book2));
        booklist.add(new Books("ঘুঁটের দহন (হার্ডকভার)", "শ্যামল সেন ", "বেহুলাবাংলা  ", " সমকালীন উপন্যাস ", 154, "2018", "1st Published, 2018",R.drawable.book3));
        booklist.add(new Books("অর্পিত অন্ধকারে সানাই কিংবা বিষ (হার্ডকভার)", "সরকার অরুণ কুমার  ", " বেহুলাবাংলা  ", " বাংলা কবিতা ", 116, "2018", "1st Published, 2018",R.drawable.book4));
        booklist.add(new Books("সূর্যশিকারি (হার্ডকভার)", "রণজিৎ সরকার ", "নালন্দা ", " মুক্তিযুদ্ধের উপন্যাস ", 116, "2018", "1st Published, 2018",R.drawable.book5));
        booklist.add(new Books("ভুবনেশ্বরের ডাক (হার্ডকভার)", "সুজন তাজওয়ার  ", " বেহুলাবাংলা  ", " সমকালীন গল্প ", 116, "2018", "1st Published, 2018",R.drawable.book6));
        booklist.add(new Books("বারোটি উপন্যাস (হার্ডকভার)", "সুনীল গঙ্গোপাধ্যায়  ", "পত্র ভারতী (ভারত)  ", " পশ্চিমবঙ্গের উপন্যাস  ", 720, "2017", "5th Printed, 2017",R.drawable.book7));
        booklist.add(new Books("3Rd Alternative (Paperback)", "মStephen R. Covey  ", " Simon & Schuster  ", " meditation and self-help  ", 1075, "2012", " 2nd Edition, 2012",R.drawable.book8));
        booklist.add(new Books("Classic Starts:The Wind in the Willows (Hardcover)", "Kenneth Grahame  ", " Sterling Publishers  ", " Novel ", 535, "2007", " 1st Published, 2007",R.drawable.book9));
        booklist.add(new Books("ভাবা সমগ্র ২ (হার্ডকভার)", "দীনেশচন্দ্র চট্টোপাধ্যায় ", "পত্র ভারতী (ভারত)  ", " পশ্চিমবঙ্গের রচনাসমগ্র/সংকলন  ", 216, "2013", " 3rd Printing, 2013",R.drawable.book10));



    }

    @Override
    public void setTopListedBooks() {
        topListedBooksList.add(new TopListedBooks("অধ্যায় (হার্ডকভার)", "মতকিব তৌফিক", "নালন্দা ", " বইমেলা ২০১৯ ", 213 , "2019", " 1st Published, 2019",true,R.drawable.book11));
        topListedBooksList.add(new TopListedBooks("তুমি আমার নীল ঝিনুকের গল্প", "ফারজানা মিতু", " নালন্দা  ", "   রোমান্টিক উপন্যাস   ", 140, "2018", "2nd Published, 2018",true,R.drawable.book12));
        topListedBooksList.add(new TopListedBooks("অলৌকিক বাঁশি (হার্ডকভার)", "তৌহিদুর রহমান", "বেহুলাবাংলা  ", "  রোমান্টিক উপন্যাস ", 154, "2018", "1st Published, 2018",true,R.drawable.book16));
        topListedBooksList.add(new TopListedBooks("নিরাপদ দেশলাই (হার্ডকভার)", "অরূপ কিষাণ ", " বেহুলাবাংলা  ", " সমকালীন গল্প  ", 116, "2018", "1st Published, 2018",true,R.drawable.book13));
        topListedBooksList.add(new TopListedBooks("প্যারিস রোড (হার্ডকভার)", " লাবাংলা  ", "নালন্দা ", "চিরায়ত উপন্যাস ", 116, "2018", "1st Published, 2018",true,R.drawable.book14));
        topListedBooksList.add(new TopListedBooks("ভুবনেশ্বরের ডাক (হার্ডকভার)", "সুজন তাজওয়ার  ", " বেহুলাবাংলা  ", " সমকালীন গল্প ", 116, "2018", "1st Published, 2018",true,R.drawable.book15));


    }

    @Override
    public void setBookCategory() {
        bookCategory.add("Story Books");
        bookCategory.add("Novel");
        bookCategory.add("Design");
        bookCategory.add("Art");
        bookCategory.add("Horror");
        bookCategory.add("Poem");
        bookCategory.add("Essay");
        bookCategory.add("Fantasy");
        }

    }
