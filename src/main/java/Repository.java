import java.lang.reflect.Array;
import java.util.ArrayList;

public class Repository {

    private String repoName;
    private String repoDescription;
    private RepositoryType repoType;
    private ArrayList<Commit> commits;

    public Repository(String repoName, String repoDescription, RepositoryType repoType) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
        this.repoType = repoType;
        this.commits = new ArrayList<Commit>();
    }

    public String getRepoName() {
        return this.repoName;
    }

    public RepositoryType getRepoType() {
        return this.repoType;
    }

    public int getCommitsSize() {
        return this.commits.size();
    }

    public ArrayList<Commit> getAllCommits() {
        return this.commits;
    }

    public void addCommitToRepo(Commit commit) {
        this.commits.add(commit);
    }

    public Commit getCommitById(String id) {
        for (Commit commit : this.commits) {
            if (id.equals(commit.returnUniqueId())) {
                return commit;
            }
        }
        return null;
    }

    public void commitRevert(Commit commit) {
        String commitId = commit.returnUniqueId();
        for (Commit commitToFind : this.commits) {
            if (commitToFind.returnUniqueId().equals(commitId)) {
                int commitIndex = this.commits.indexOf((commitToFind));
                ArrayList<Commit> updatedCommits = new ArrayList<Commit>();
                for (int i = 0; i <= commitIndex; i++) {
                    updatedCommits.add(this.commits.get(i));
                }
                this.commits = updatedCommits;
////              int lastIndex = this.commits.size() - 1;
//                ArrayList<Commit> updatedCommits = new ArrayList<Commit>();
//                this.commits = new ArrayList<Commit>(this.commits.subList(0, commitIndex));
            }
        }
    }

}
