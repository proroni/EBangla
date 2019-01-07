package root.android.workspaceit.com.ebangla.Model;

import java.io.Serializable;

public class Books implements Serializable,IBooks {


    String name;
    String writer;
    String publication;
    String category;
    int price;
    String releaseDate;
    String edition;
    int imaId;


    public Books(String name, String writer, String publication, String category, int price, String releaseDate, String edition,int imgId) {
        this.name = name;
        this.writer = writer;
        this.publication = publication;
        this.category = category;
        this.price = price;
        this.releaseDate = releaseDate;
        this.edition = edition;
        this.imaId=imgId;
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
        return imaId;
    }
}
