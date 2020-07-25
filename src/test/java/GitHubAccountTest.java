import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    private Commit initialCommit;
    private Commit finalCommit;
    private Repository repo1;
    private Repository repo2;
    private GitHubAccount gitAccount;

    @Before
    public void before() {
        initialCommit = new Commit("Testing methods", CommitUniqueId.UNIQUEID.createUniqueId());
        finalCommit = new Commit("Fixing methods", CommitUniqueId.UNIQUEID.createUniqueId());
        repo1 = new Repository("GitHub repo", "CodeClan version of GitHub", RepositoryType.PUBLIC);
        repo1.addCommitToRepo(initialCommit);
        repo1.addCommitToRepo(finalCommit);

        repo2 = new Repository("Testing repo", "Testing new features", RepositoryType.PRIVATE);

        gitAccount = new GitHubAccount("ahmedmchamed", "ahmedhamed");
        gitAccount.uploadRepoToAccount(repo1);
        gitAccount.uploadRepoToAccount(repo2);
    }

    @Test
    public void canGetMemberNameAndUsername() {
        assertEquals("ahmedmchamed", gitAccount.getUsername());
        assertEquals("ahmedhamed", gitAccount.getMemberName());
    }

    @Test
    public void canGetDefaultAccountType() {
        assertEquals(GitHubAccountType.FREE, gitAccount.getAccountType());
    }

    @Test
    public void canGetRepositoryByName() {
        assertEquals("Testing repo", gitAccount.getRepoByName("Testing repo").getRepoName());
    }

//    @Test
//    public void canSetAccountType() {
//        gitAccount.setAccountType();
//        assertEquals(GitHubAccountType.PRO, gitAccount.getAccountType());
//    }

}
