import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GitHubAccount {

    private String username;
    private String memberName;
    private HashMap<String, Repository> repositories;
    private GitHubAccountType accountType;

    public GitHubAccount(String username, String memberName) {
        this.username = username;
        this.memberName = memberName;
        this.repositories = new HashMap<String, Repository>();
        this.accountType = GitHubAccountType.FREE;
    }

    public String getUsername() {
        return this.username;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public Repository getRepoByName(String repoName) {
        return this.repositories.get(repoName);
    }

    public GitHubAccountType getAccountType() {
        return this.accountType;
    }

    public void uploadRepoToAccount(String repoName) {
        Repository repo = this.getRepoByName(repoName);
        this.repositories.put(repoName, repo);
    }

    public void setAccountType() {
        System.out.println("What type of account would you like? (Free/Pro)");
        String querySelector = "";
        Scanner readInput = new Scanner(System.in);

        querySelector = readInput.nextLine().toLowerCase();

        if (querySelector.toLowerCase().equals("free")) {
            System.out.println("Freaking cheapo. Fine, take your free " +
                    "account and get outta here.");
            this.accountType = GitHubAccountType.FREE;
        }
        else if (querySelector.toLowerCase().equals("pro")) {
            System.out.println("Aw yeah, nice. That'll be 5 percent" +
                    "of your life expectancy please. Too late now, nerd.");
            this.accountType = GitHubAccountType.PRO;
        }
        else {
            System.out.println("Invalid input. Try again? (y/n)");
            char confirmTryAgain = ' ';
            Scanner readConfirmation = new Scanner(System.in);
            confirmTryAgain = readConfirmation.next().charAt(0);

            switch (confirmTryAgain) {
                case 'y': this.setAccountType();
                case 'n': return;
                default: break;
            }
        }
    }

}
