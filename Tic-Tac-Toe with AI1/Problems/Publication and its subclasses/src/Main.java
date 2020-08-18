//import java.util.Scanner;

class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        // write your code here
        return  getType()  + getDetails();
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return ": " + title;
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    // write your code here
    @Override
    public String getType() { return "Newspaper"; }

    @Override
    public String getDetails() {
        return " (source - " + source + ")" + super.getDetails();
    }
}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    // write your code here
    @Override
    public String getType() { return "Article"; }

    @Override
    public String getDetails() {
        return " (author - " + author + ")"  + super.getDetails();
    }
}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    // write your code here
    @Override
    public String getType() { return "Announcement"; }

    @Override
    public String getDetails() {
        return " (days to expire - " + daysToExpire + ")" + super.getDetails();
    }
}

/*
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] parts = line.split("; ");
        String type = parts[0];
        Publication publication;
        switch (type) {
            case "Publication":
                //System.out.println("Publication" + " " + parts[1]);
                publication = new Publication(parts[1]);
                break;
            case "Newspaper":
                //ystem.out.println("Newspaper" + " " + parts[1]);
                publication = new Newspaper(parts[1], parts[2]);
                break;
            case "Article":
                //System.out.println("Article" + " " + parts[1]);
                publication = new Article(parts[1], parts[2]);
                break;
            case "Announcement":
                //System.out.println("Announcement" + parts[1]);
                int days = Integer.parseInt(parts[2]);
                publication = new Announcement(parts[1], days);
                break;
            default:
                publication = new Publication("unknown");
                break;
        }
        System.out.println(publication.getInfo());
    }
}
*/
