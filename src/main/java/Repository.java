import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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

    public void setRepoAccess() {
        System.out.println("Your repo is set to public visibility by default. " +
                "Do you want to set to private instead? (y/n)");
        char readConfirmation;
        Scanner readInput = new Scanner(System.in);
        readConfirmation = readInput.next().charAt(0);

        switch (readConfirmation) {
            case 'y':
                System.out.println("Private access confirmed.\n");
                this.repoType = RepositoryType.PRIVATE;
                break;
            case 'n':
                System.out.println("Default public access confirmed.\n");
                break;
            default:
                System.out.println("Invalid input. Please try again. (y/n)");
                this.setRepoAccess();
        }
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
