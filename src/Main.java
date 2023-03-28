import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        TicTacToe game = new TicTacToe();
        String inp;
        while ((inp = rdr.readLine()) != null) {
            String[] com = inp.split(" ");
            if (com.length == 0)
                continue;
            if ((com[0].equals("place") || com[0].equals("p")) && com.length == 3)
                game.place(Integer.parseInt(com[1]), Integer.parseInt(com[2]));
            else if ((com[0].equals("status") || com[0].equals("s")) && com.length == 1)
                System.out.println(game.getStatus());
            else if ((com[0].equals("reset") || com[0].equals("r"))  && com.length == 1)
                game.reset();
            else if ((com[0].equals("exit") || com[0].equals("e"))  && com.length == 1)
                break;
            else System.out.println("Available commands are:\nplace r c\nstatus\nreset\nexit");
        }
    }
}