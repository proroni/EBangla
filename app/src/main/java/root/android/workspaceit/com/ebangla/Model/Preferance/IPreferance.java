package root.android.workspaceit.com.ebangla.Model.Preferance;

import android.content.Context;

import root.android.workspaceit.com.ebangla.Model.Books;

public interface IPreferance {
    void addBook(Context context, Books product);
    void removeBook(Context context, int  position);
}

