import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

    private Commit initialCommit;
    private Commit developCommit;
    private Commit finalCommit;
    private Repository repo1;
    private Repository repo2;
    private Repository repo3;

    @Before
    public void before() {
        initialCommit = new Commit("Initial commit", CommitUniqueId.UNIQUEID.createUniqueId());
        developCommit = new Commit("Develop commit", CommitUniqueId.UNIQUEID.createUniqueId());
        finalCommit = new Commit("Final commit", CommitUniqueId.UNIQUEID.createUniqueId());
        repo1 = new Repository("GitHub repo", "CodeClan version of GitHub", RepositoryType.PUBLIC);
        repo2 = new Repository("Someone's repo", "What's happening", RepositoryType.PRIVATE);
        repo3 = new Repository("Other repo", "Let's all commit together", RepositoryType.PUBLIC);

        repo1.addCommitToRepo(initialCommit);
        repo1.addCommitToRepo(developCommit);
        repo1.addCommitToRepo(finalCommit);

        repo2.addCommitToRepo(initialCommit);
        repo2.addCommitToRepo(developCommit);

        repo3.addCommitToRepo(initialCommit);
    }

    @Test
    public void canGetRepoName() {
       assertEquals("GitHub repo", repo1.getRepoName());
    }

    @Test
    public void canGetRepoType() {
        assertEquals(RepositoryType.PUBLIC, repo1.getRepoType());
    }

    @Test
    public void canAddCommitToRepo() {
        assertEquals(3, repo1.getCommitsSize());
    }

    @Test
    public void canGetCommitById() {
        Commit result = repo1.getCommitById(finalCommit.returnUniqueId());
        assertEquals("Final commit", result.returnDescription());
    }

    @Test
    public void canRevertToCommit() {
        repo1.commitRevert(developCommit);
        assertEquals(2, repo1.getCommitsSize());
        assertEquals("Initial commit", repo1.getAllCommits().get(0).returnDescription());
        assertEquals("Develop commit", repo1.getAllCommits().get(1).returnDescription());
        repo1.commitRevert(initialCommit);
        assertEquals(1, repo1.getCommitsSize());
        assertEquals("Initial commit", repo1.getAllCommits().get(0).returnDescription());
    }

}
