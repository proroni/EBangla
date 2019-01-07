package root.android.workspaceit.com.ebangla.Model;

import java.io.Serializable;

public class TopListedBooks implements IBooks,Serializable {

    String name;
    String writer;
    String publication;
    String category;
    int price;
    String releaseDate;
    String edition;
    Boolean toplist;
    int imgId;



    public TopListedBooks(String name, String writer, String publication, String category, int price, String releaseDate, String edition, Boolean toplist,int imgId) {
        this.name = name;
        this.writer = writer;
        this.publication = publication;
        this.category = category;
        this.price = price;
        this.releaseDate = releaseDate;
        this.edition = edition;
        this.toplist = toplist;
        this.imgId=imgId;
    }

    @Override
    public String getBooksName() {
        return name;
    }

    @Override
    public String getBooksWriter() {
        return writer;

    }

    @Override
    public String getBooksPublications() {
        return publication;
    }

    @Override
    public String getBooksCategory() {
        return category;
    }

    @Override
    public int getBooksPrice() {
        return price;
    }

    @Override
    public String getBooksReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getBooksEdition() {
        return edition;
    }

    @Override
    public int imageId() {
        return imgId;
    }

    public Boolean getToplist() {
        return toplist;
    }
}
