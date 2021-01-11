import commands.AddCommand;

import java.io.IOException;
import java.io.Serializable;

//verify that the input format is valid and "route" commands to their corresponding "handler"
public class Gitlet {
    public static void execute(String[] args){
        if (args.length > 2){
            System.out.println("Incorrect operands");
            return;
        }

        String arg1 = args[0];
        String arg2 = args.length == 1? null:args[1];

        //add
        if (arg1.equals("add")){
            if (arg2 == null){
                System.out.println("Incorrect operands");
                return;
            }
            AddCommand.execute(arg1, arg2);
            return;
        }

        System.out.println("Incorrect operands");
        return;
    }
}
