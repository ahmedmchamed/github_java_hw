import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Welcome to GitClan!\n");
        System.out.println("You can use '-h' to see a list of all the available options.");

        for (int i = 0; i < args.length; i++)
        switch (args[i].charAt(0)) {
            case '-':
                String option = args[i].toLowerCase().toString();
                if (option.equals("-h")) {
//                    System.out.println(i);
                    System.out.println("Here are some options that you can use.\n");
                    System.out.println("\t-commit to detail an new commit");
                    System.out.println("\t-repocreate [NAME] [\"DESCRIPTION\"] to detail an new commit");
                    System.out.println("\t-revert [COMMIT] to revert to a previous commit\n");
                }

                if (option.equals(("-repocreate"))) {
                    System.out.println("Enter your new repo name:\n");
                    Scanner readRepoName = new Scanner(System.in);
                    String repoName = readRepoName.next();
                    System.out.println("Enter a short description (between quotes please):\n");
                    Scanner readRepoDescription = new Scanner(System.in);
                    String repoDescription = readRepoDescription.nextLine();
                    Repository newRepo = new Repository(repoName, repoDescription, RepositoryType.PUBLIC);
                    System.out.println(newRepo.getRepoType());
                    newRepo.setRepoAccess();
                    System.out.println(newRepo.getRepoType());
//                    System.out.println(repoName);
//                    System.out.println(repoDescription);

                }

                if (option.equals(("-commit"))) {
                    String commitDescription = args[i+1].toString();
                    Commit newCommit = new Commit(commitDescription, CommitUniqueId.UNIQUEID.createUniqueId());
                }
        }
    }

}
