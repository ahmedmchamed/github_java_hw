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

    public GitHubAccountType getAccountType() {
        return this.accountType;
    }

}
