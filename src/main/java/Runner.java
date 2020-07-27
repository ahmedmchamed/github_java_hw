import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Welcome to GitHubClan!\n");
        System.out.println("You can use '-h' to see a list of all the available options.\n");

        for (int i = 0; i < args.length; i++)
        switch (args[i].charAt(0)) {
            case '-':
                String option = args[i].toLowerCase().toString();
                if (option.equals("-h")) {
                    System.out.println("Here are some options that you can use.\n");
                    System.out.println("\t-createaccount to create an account on GitHubClan");
                    System.out.println("\t-createrepo to create a new repository");
                    System.out.println("\t-commit to detail an new commit");
                    System.out.println("\t-revert [COMMIT] to revert to a previous commit\n");
                }

                if (option.equals("-createaccount")) {
                    System.out.println("Please enter your full name:");
                    Scanner readFullName = new Scanner(System.in);
                    String fullName = readFullName.nextLine();

                    System.out.println("Please enter a preferred username:");
                    Scanner readUserName = new Scanner(System.in);
                    String userName = readUserName.nextLine();

                    GitHubAccount newAccount = new GitHubAccount(userName, fullName);
                    newAccount.setAccountType();
                    System.out.println("Thanks for creating an account.\n");
                    String welcome = String.format("Your details are:\n" +
                            "Name: %s\n" +
                            "Username: %s\n" +
                            "Account type: %s\n",
                            newAccount.getMemberName(),
                            newAccount.getUsername(),
                            newAccount.getAccountType().toString());
                    System.out.println(welcome);
                }

                if (option.equals("-createrepo")) {
                    System.out.println("Enter your new repo name:");
                    Scanner readRepoName = new Scanner(System.in);
                    String repoName = readRepoName.next();

                    System.out.println("Enter a short (please, not a novel) description:");
                    Scanner readRepoDescription = new Scanner(System.in);
                    String repoDescription = readRepoDescription.nextLine();

                    Repository newRepo = new Repository(repoName, repoDescription, RepositoryType.PUBLIC);
                    System.out.println(newRepo.getRepoType());

                    newRepo.setRepoAccess();
                    System.out.println("Congrats. You've created an account.\n");
                }

                if (option.equals("-commit")) {
                    System.out.println("Enter your commit description.\n");
                    String commitDescription;
                    Scanner readDescription = new Scanner(System.in);
                    commitDescription = readDescription.nextLine();

                    Commit newCommit = new Commit(commitDescription, CommitUniqueId.UNIQUEID.createUniqueId());
                    System.out.println(String.format("Your commit id is %s.", newCommit.returnUniqueId()));
                }
        }
    }

}
