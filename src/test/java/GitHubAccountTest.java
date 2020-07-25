import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    private Commit initialCommit;
    private Commit finalCommit;
    private Repository repo;
    private GitHubAccount gitAccount;

    @Before
    public void before() {
        initialCommit = new Commit("Testing methods", CommitUniqueId.UNIQUEID.createUniqueId());
        finalCommit = new Commit("Fixing methods", CommitUniqueId.UNIQUEID.createUniqueId());
        repo = new Repository("GitHub repo", "CodeClan version of GitHub", RepositoryType.PUBLIC);
        repo.addCommitToRepo(initialCommit);
        repo.addCommitToRepo(finalCommit);

        gitAccount = new GitHubAccount("ahmedmchamed", "ahmedhamed");
        gitAccount.uploadRepoToAccount(repo.getRepoName());
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

}
