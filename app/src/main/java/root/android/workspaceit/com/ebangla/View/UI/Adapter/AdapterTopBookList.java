package root.android.workspaceit.com.ebangla.View.UI.Adapter;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.Model.TopListedBooks;
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.UI.Activity.ActivityBookDetails;


public class AdapterTopBookList extends RecyclerView.Adapter<AdapterTopBookList.BookViewHolder> {

    private Context context;
    private List<TopListedBooks> bookList;
    TopListedBooks book;
    Intent intent;


    public AdapterTopBookList(Context context, List<TopListedBooks> bookList) {
        this.context = context;
        this.bookList = bookList;


    }


    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, null);
        BookViewHolder viewHolder = new BookViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        book = bookList.get(position);

        //get Book Image
        holder.bookImg.setImageResource(book.imageId());

        holder.writer.setText(book.getBooksWriter());
        holder.bookName.setText(book.getBooksName());
        holder.category.setText(book.getBooksCategory());
        holder.price.setText(Integer.toString(book.getBooksPrice()));


    }


    @Override
    public int getItemCount() {
        return (bookList != null ? bookList.size() : 0);
    }


    class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView bookImg;
        TextView writer;
        TextView bookName;
        TextView category;
        TextView price;
        LinearLayout linearLayout;


        BookViewHolder(View itemView) {

            super(itemView);

            bookImg = itemView.findViewById(R.id.book_img);
            writer = itemView.findViewById(R.id.writer);
            bookName = itemView.findViewById(R.id.name);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
            linearLayout = itemView.findViewById(R.id.item_layout);


            linearLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            intent = new Intent(context, ActivityBookDetails.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("topBookData",bookList.get(getAdapterPosition()));
            context.startActivity(intent);





        }


    }
}







