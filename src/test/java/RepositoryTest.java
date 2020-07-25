import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

    private Commit initialCommit;
    private Commit developCommit;
    private Commit ongoingCommit;
    private Commit finalCommit;
    private Repository repo1;
    private Repository repo2;
    private Repository repo3;
    private Repository repo4;
    private ArrayList<Repository> repoList = new ArrayList<Repository>();

    @Before
    public void before() {
        initialCommit = new Commit("Initial commit", CommitUniqueId.UNIQUEID.createUniqueId());
        developCommit = new Commit("Develop commit", CommitUniqueId.UNIQUEID.createUniqueId());
        ongoingCommit = new Commit("Ongoing commit", CommitUniqueId.UNIQUEID.createUniqueId());
        finalCommit = new Commit("Final commit", CommitUniqueId.UNIQUEID.createUniqueId());
        repo1 = new Repository("Jack's repo", "new features", RepositoryType.PUBLIC);
        repo2 = new Repository("Fred's repo", "bug fixes", RepositoryType.PRIVATE);
        repo3 = new Repository("Mickey's repo", "typos", RepositoryType.PUBLIC);
        repo4 = new Repository("Karl's repo", "feature branch", RepositoryType.PRIVATE);

        repo4.addCommitToRepo(initialCommit);
        repo4.addCommitToRepo(developCommit);
        repo4.addCommitToRepo(ongoingCommit);
        repo4.addCommitToRepo(finalCommit);

        repo1.addCommitToRepo(initialCommit);
        repo1.addCommitToRepo(developCommit);
        repo1.addCommitToRepo(ongoingCommit);

        repo2.addCommitToRepo(initialCommit);
        repo2.addCommitToRepo(developCommit);

        repo3.addCommitToRepo(initialCommit);

        repoList.add(repo3);
        repoList.add(repo4);
        repoList.add(repo1);
        repoList.add(repo2);
    }

    @Test
    public void canGetRepoName() {
       assertEquals("Jack's repo", repo1.getRepoName());
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
        Commit result = repo1.getCommitById(developCommit.returnUniqueId());
        assertEquals("Develop commit", result.returnDescription());
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

    @Test
    public void canSortReposAccordingToCommits() {
        assertEquals("Fred's repo", this.repoList.get(3).getRepoName());
        Collections.sort(this.repoList, Repository.NUMBER_OF_COMMITS);
        assertEquals("Karl's repo", this.repoList.get(3).getRepoName());
    }

}
