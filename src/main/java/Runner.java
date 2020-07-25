public class Runner {

    public static void main(String[] args) {
        System.out.println("Welcome to GitClan!\n");
        System.out.println("You can use '-h' to see a list of all the options.");

        for (int i = 0; i < args.length; i++)
        switch (args[i].charAt(0)) {
            case '-':
                String option = args[i].toLowerCase().toString();
                if (option.equals("-commit")) {
                    System.out.println("Enter your commit description.\n");

                }
        }
    }

}
