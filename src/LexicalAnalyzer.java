
import java.util.Scanner;

public class LexicalAnalyzer
{
    public static String scan(String source)
    {
        source = source.replaceAll("\\+|\\-|\\*|\\/|\\=|\\<\\<", " <operator> ");
        source = source.replaceAll(";", " <semicolon> ");
        source = source.replaceAll("\\(", " <left-parenthesis> ");
        source = source.replaceAll("\\)", " <right-parenthesis> ");
        source = source.replaceAll("\\{", " <left-curly> ");
        source = source.replaceAll("\\}", " <right-curly> ");
        source = source.replaceAll("using", " <using> ");
        source = source.replaceAll("namespace", " <namespace> ");
        source = source.replaceAll("std", " <std> ");
        source = source.replaceAll("#include <.*>", " <include> ");
        source = source.replaceAll("int|char|float|double|bool|void", " <datatype> ");
        source = source.replaceAll("[0-9]+|\\\".+\"", " <constant> ");
        source = source.replaceAll("return|cout", " <keyword> ");
        String feed = source;
        
        Scanner scanner = new Scanner(feed);
        
        while (scanner.hasNext())
        {
            String next = scanner.next();
            
            if (!(next.charAt(0) == '<' && next.charAt(next.length() - 1) == '>'))
            {
                source = source.replaceFirst("[ ]" + next + "[ ]", "<identifier>");
            }
        }
        
        return source.replaceAll("[ ]|\n", "");
    }
}



//    =========================================================================
//                              Supposed Output
//    =========================================================================
//    <include>
//    <using><namespace><std><semicolon>
//
//    <datatype><identifier><left-parenthesis><right-parenthesis><left-curly>
//    <datatype><identifier><operator><constant><semicolon>
//    <identifier><operator><identifier><operator><constant><semicolon>
//    <keyword><operator><constant><operator><identifier><semicolon>
//    <keyword><constant><semicolon>
//    <right-curly>
