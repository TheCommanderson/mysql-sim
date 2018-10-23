package database;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.*;

public class Main{
    public static final String INPUT_FILE = "test_commands.txt";

    public static void main(String[] args){
        try {

            FileInputStream fs = new FileInputStream(INPUT_FILE);
            CharStream cs = CharStreams.fromStream(fs);
            gramLexer lex = new gramLexer(cs);
            BufferedTokenStream tokens = new BufferedTokenStream(lex);
            tokens.fill();
            gramParser parser = new gramParser(tokens);
            ParseTree tree = parser.program();
            gramListener listen = new gramDatabaseListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listen, tree);
            System.out.println("Number of syntax errors: " + parser.getNumberOfSyntaxErrors());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            System.err.println("exception: " + e);
            e.printStackTrace();
        }

    }
}
