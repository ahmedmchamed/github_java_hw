import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Repository implements Comparable<Repository> {

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

    public int compareTo(Repository repo) {
        if (this.commits.size() > repo.getCommitsSize()) {
            return 1;
        }
        else if (this.commits.size() < repo.getCommitsSize()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public static Comparator<Repository> NUMBER_OF_COMMITS = new Comparator<Repository>() {
        public int compare(Repository repo1, Repository repo2) {
            Integer repo1size = repo1.getCommitsSize();
            Integer repo2size = repo2.getCommitsSize();
            return repo1size.compareTo(repo2size);
        }
    };

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
            }
        }
    }

}
