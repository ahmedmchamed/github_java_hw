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

    public RepositoryType getRepoType() {
        return this.repoType;
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

}
