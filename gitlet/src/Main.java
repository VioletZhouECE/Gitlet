public class Main {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Please enter a command");
            return;
        }
        Gitlet.execute(args);
    }
}