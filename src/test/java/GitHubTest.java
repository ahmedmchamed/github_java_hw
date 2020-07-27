import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GitHubTest {

    private GitHubAccount account1;
    private GitHubAccount account2;
    private GitHubAccount account3;
    private GitHubAccount account4;
    private GitHubAccount account5;

    private GitHub github;

    @Before
    public void before() {
        account1 = new GitHubAccount("zoomoverthere", "Astro Rocket");
        account2 = new GitHubAccount("spacepilot", "Hikaru Sulu");
        account3 = new GitHubAccount("captain", "James Kirk");
        account4 = new GitHubAccount("superking", "Mufasa McPride");
        account5 = new GitHubAccount("professionalbum", "Patrick Crown");

        github = new GitHub();
        github.addGitAccountToList(account5);
        github.addGitAccountToList(account2);
        github.addGitAccountToList(account1);
        github.addGitAccountToList(account3);
        github.addGitAccountToList(account4);
    }

    @Test
    public void githubHasAccounts() {
        assertEquals(5, github.getGitAccountsSize());
    }

    @Test
    public void githubCanSortAccountsList() {
        github.sortAccountsList();
        assertEquals("Astro Rocket", github.getGitAccountsList().get(0).getMemberName());
    }


}
