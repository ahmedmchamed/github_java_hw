import java.util.ArrayList;

public class GitHubAccount {

    private String username;
    private String memberName;
    private ArrayList<Repository> repositories;
    private GitHubAccountType accountType;

    public GitHubAccount(String username, String memberName, GitHubAccountType accountType) {
        this.username = username;
        this.memberName = memberName;
        this.repositories = new ArrayList<Repository>();
        this.accountType = accountType;
    }

}
