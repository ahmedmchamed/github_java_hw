import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitTest {

    private Commit commitTest;

    @Before
    public void before() {
        commitTest = new Commit("Initial commit", CommitUniqueId.UNIQUEID.createUniqueId());
    }

    @Test
    public void hasCommitDescription() {
        assertEquals("Initial commit", commitTest.returnDescription());
    }

}
