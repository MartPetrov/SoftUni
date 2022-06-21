package P02Articles20;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articlesParts = scanner.nextLine().split(", ");


        String title = articlesParts[0];
        String content = articlesParts[1];
        String author = articlesParts[2];

        P02Articles.Article article = new P02Articles.Article(title,content,author);

        int commandsCount =  Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= commandsCount; i++) {
            String command = scanner.nextLine();
            String commandName = command.split(": ")[0];
            String newValue = command.split(": ")[1];

            switch (commandName){
                case "Edit":
                    article.setContent(newValue);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(newValue);
                    break;
                case "Rename":
                    article.setTitle(newValue);
                    break;
            }
        }
        System.out.println(article);
    }
}
