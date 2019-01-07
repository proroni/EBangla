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
import root.android.workspaceit.com.ebangla.R;
import root.android.workspaceit.com.ebangla.View.UI.Activity.ActivityBookDetails;
import root.android.workspaceit.com.ebangla.View.UI.Activity.ActivityCategoryBookList;


public class AdapterCategoryList extends RecyclerView.Adapter<AdapterCategoryList.CategoryViewHolder> {

    private Context context;
    private List<String> categoryList;
    String category;
    Intent intent;
    Drawable drawable;

    public AdapterCategoryList(Context context, List<String> categoryList) {
        this.context = context;
        this.categoryList = categoryList;


    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, null);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        category = categoryList.get(position);

        holder.category.setText(category);
    }


    @Override
    public int getItemCount() {
        return (categoryList != null ? categoryList.size() : 0);
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        TextView category;
        CardView cardViewCategory;


        CategoryViewHolder(View itemView) {

            super(itemView);

            cardViewCategory = itemView.findViewById(R.id.cd_category);
            category = itemView.findViewById(R.id.txt_category);

            cardViewCategory.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            intent = new Intent(context, ActivityCategoryBookList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            }


    }
}







