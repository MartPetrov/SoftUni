package P33ExamPrepare;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "TakeOdd":
                    StringBuilder oddPass = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        oddPass.append(password.charAt(i));
                    }
                    System.out.println(oddPass);
                    password = oddPass.toString();
                    break;
                case "Cut":
                    StringBuilder newSb = new StringBuilder(password);
                    int index = Integer.parseInt(commandArr[1]);
                    int length = Integer.parseInt(commandArr[2]);
                    newSb.delete(index,index+length);
                    System.out.println(newSb);
                    password = newSb.toString();
                    break;
                case "Substitute":
                    String toReplace = commandArr[1];
                    String substitute = commandArr[2];

                    StringBuilder sb = new StringBuilder(password);
                    int toReplaceLength = toReplace.length();
                    int indexToRemove = sb.indexOf(toReplace);
                    if (password.contains(toReplace)) {
                        while (password.contains(toReplace)){
                            sb.delete(indexToRemove,indexToRemove + toReplaceLength);
                            sb.insert(indexToRemove,substitute);
                            indexToRemove = sb.indexOf(toReplace);
                            if (indexToRemove == -1){
                                break;
                            }
                        }
                        System.out.println(sb);
                        password = sb.toString();
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: "+ password);
    }
}
