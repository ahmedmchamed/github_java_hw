import org.junit.Before;
import org.junit.Test;

public class RepositoryTest {

    private Commit commit;
    private Repository repo;

    @Before
    public void before() {
        commit = new Commit("Initial commit", CommitUniqueId.UNIQUEID.createUniqueId());
        repo = new Repository("GitHub repo", "CodeClan version of GitHub", RepositoryType.PUBLIC);
    }

//    @Test
//    public void

}
