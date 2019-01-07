package root.android.workspaceit.com.ebangla.Model.Preferance;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import root.android.workspaceit.com.ebangla.Model.Books;
import root.android.workspaceit.com.ebangla.View.IPreferenceView;

public class PreferanceEBangla implements IPreferance{

    public static final String PREFS_NAME = "Ebangla_preferance_wishList";
    public static final String FAVORITES = "Book_Favorite";
    IPreferenceView iPreferenceView;

    Context context;

    public PreferanceEBangla(Context context) {
        super();
        this.context=context;
        this.iPreferenceView=iPreferenceView;
    }

    public void saveFavorites(Context context, List<Books> favorites) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }


    public ArrayList<Books> getFavorites(Context context) {
        SharedPreferences settings;
        List<Books> favorites;

        settings = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            Books[] favoriteItems = gson.fromJson(jsonFavorites,
                    Books[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<>(favorites);
        } else
            return new ArrayList<>();

        return (ArrayList<Books>) favorites;
    }



    @Override
    public void addBook(Context context, Books product) {
        List<Books> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<>();
        favorites.add(product);
        this.context=context;
        saveFavorites(context,favorites);
    }

    @Override
    public void removeBook(Context context, int  position) {
        List<Books> favorites = getFavorites(context);
        favorites.remove(position);

        saveFavorites(context, favorites);
    }
}
