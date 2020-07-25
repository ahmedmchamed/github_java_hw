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

}
