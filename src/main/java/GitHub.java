import java.util.ArrayList;

public class GitHub {

    private ArrayList<GitHubAccount> gitAccountsList;

    public GitHub () {
        this.gitAccountsList = new ArrayList<GitHubAccount>();
    }

    public void addGitAccountToList(GitHubAccount gitAccount) {
        this.gitAccountsList.add(gitAccount);
    }

    public ArrayList<GitHubAccount> getGitAccountsList() {
        return this.gitAccountsList;
    }

    public GitHubAccount getGitAccountByUsername(String username) {
        for (GitHubAccount accountToFind : this.gitAccountsList) {
            if (accountToFind.getUsername().equals(username)) {
                return accountToFind;
            }
        }
        return null;
    }

}
