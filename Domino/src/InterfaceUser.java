import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterfaceUser {

    private String s;
    private InputStreamReader i = new InputStreamReader (System.in);
    private BufferedReader d = new BufferedReader(i);

    public String leString(String msg)
    {   s = "";
        System.out.println(msg);
        try
        {
            s = d.readLine();
        }
        catch (IOException e)
        {
            System.out.println ("Erro de I/O: " + e);
        }
        return (s);
    }
}
