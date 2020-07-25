import java.util.ArrayList;
import java.util.HashMap;

public class GitHubAccount {

    private String username;
    private String memberName;
    private HashMap<String, Repository> repositories;
    private GitHubAccountType accountType;

    public GitHubAccount(String username, String memberName, GitHubAccountType accountType) {
        this.username = username;
        this.memberName = memberName;
        this.repositories = new HashMap<String, Repository>();
        this.accountType = accountType;
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

    public void setAccountType(String querySelector) {
        System.out.println("What type of account would you like?");
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
    }

}
