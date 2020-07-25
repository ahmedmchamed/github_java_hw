import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

    private Commit initialCommit;
    private Commit finalCommit;
    private Repository repo;

    @Before
    public void before() {
        initialCommit = new Commit("Initial commit", CommitUniqueId.UNIQUEID.createUniqueId());
        finalCommit = new Commit("Final commit", CommitUniqueId.UNIQUEID.createUniqueId());
        repo = new Repository("GitHub repo", "CodeClan version of GitHub", RepositoryType.PUBLIC);
        repo.addCommitToRepo(initialCommit);
        repo.addCommitToRepo(finalCommit);
    }

    @Test
    public void canGetRepoName() {
       assertEquals("GitHub repo", repo.getRepoName());
    }

    @Test
    public void canGetCommitById() {
        Commit result = repo.getCommitById(finalCommit.returnUniqueId());
        assertEquals("Final commit", result.returnDescription());
    }

}
