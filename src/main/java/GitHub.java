import java.util.ArrayList;
import java.util.Collections;

public class GitHub {

    private ArrayList<GitHubAccount> gitAccountsList;

    public GitHub () {
        this.gitAccountsList = new ArrayList<GitHubAccount>();
    }

    public int getGitAccountsSize() {
        return this.gitAccountsList.size();
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

    public void sortAccountsList() {
        Collections.sort(this.gitAccountsList);
    }


}
