package P02Articles;

public class Article {
    //полета
    private String title;
    private String content;
    private String author;


    //конструктор -> създаваме обект (инстанция) от този клас
    public Article(String title, String content, String author) {
            // създава се нов празен обект
        this.title = title;
        this.content = content;
        this.author = author;

        //методи
    }

    public void setContent(String newContent) {
        this.content = newContent;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }
}
