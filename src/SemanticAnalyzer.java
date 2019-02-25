//    =========================================================================
//                              Production Rules
//    =========================================================================
//    <start> -> <program>
//    <program> -> <header><namespacing><function>
//    <header> -> <include>
//    <namespacing> -> <using><namespace><std><semicolon>
//    <function> -> <datatype><identifier><left-parenthesis><parameter><right-parenthesis><left-curly><statement><right-curly>
//    <statement> -> <statement><statement> | <expression><semicolon> | <call><semicolon>
//    <expression> -> <identifier><operator><identifier> | <datatype><identifier><operator><expression> | <identifier>
//    <call> -> <identifier><left-parenthesis><parameter><right-parenthesis> | <keyword><operator><identifier> | <keyword><identifier>
//    <parameter> -> <datatype><identifier> | <parameter><comma><parameter> | E
//    <identifier> -> <constant> | <identifier><operator><identifier>
//    <constant> -> <constant><operator><constant>
//
//    <semicolon> -> ;
//    <left-parenthesis> -> (
//    <right-parenthesis> -> )
//    <left-curly> -> {
//    <right-curly> -> }
//    <using> -> using
//    <namespace> -> namespace
//    <std> -> std
//    <include> -> #include <<constant>>
//    <datatype> -> "int" | "char" | "float" | "double" | "bool" | "void"
//    <operator> -> "+" | "-" | "*" | "/" | "=" | "<<"
//    <constant> -> "1" | "2" | "3" | ... | "999" | "a" | "ab" | ... | "abcdef"
//    <keyword> -> "cout" | "return"
//
//    #######        ##       ######
//    ##   ##        ##       ##   ##
//    #######        ##       ######
//    ##  ##         ##       ##
//    ##   ##        ##       ##
//    ##    ##   #   ##   #   ##
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SemanticAnalyzer
{
//    private static final Map<String, String[]> map = new HashMap();
    private static final Map<String, String> map = new HashMap();
    private static final List<Pair> list = new ArrayList();
    private static final String[] nonterminal = {"<start>", "<program>", "<header>", "<namespacing>", "<function>", "<statement>", "<expression>", "<call>","<parameter>", "<identifier>", "<constant>"};
    
    static {
//        map.put("<start>", new String[]{"<program>"});
//        map.put("<program>", new String[]{"<header><namespacing><function>"});
//        map.put("<header>", new String[]{"<include>"});
//        map.put("<namespacing>", new String[]{"<using><namespace><std><semicolon>"});
//        map.put("<function>", new String[]{"<datatype><identifier><left-parenthesis><parameter><right-parenthesis><left-curly><statement><right-curly>"});
//        map.put("<statement>", new String[]{"<statement><statement>", "<expression><semicolon>", "<call><semicolon>"});
//        map.put("<expression>", new String[]{"<identifier><operator><identifier>", "<datatype><identifier><operator><expression>", "<identifier>"});
//        map.put("<call>", new String[]{"<identifier><left-parenthesis><parameter><right-parenthesis>", "<keyword><operator><identifier>", "<keyword><identifier>"});
//        map.put("<parameter>", new String[]{"<datatype><identifier>", "<parameter><comma><parameter>", ""});
//        map.put("<identifier>", new String[]{"<constant>", "<identifier><operator><identifier>"});
//        map.put("<constant>", new String[]{"<constant><operator><constant>"});
        
//        list.add(new Pair("<constant><operator><constant>", "<constant>"));
//        list.add(new Pair("<identifier><operator><identifier>", "<identifier>"));
//        list.add(new Pair("<constant>", "<identifier>"));
//        list.add(new Pair("<parameter><comma><parameter>", "<parameter>"));
//        list.add(new Pair("<datatype><identifier>", "<parameter>"));
//        list.add(new Pair("<keyword><identifier>", "<call>"));
//        list.add(new Pair("<keyword><operator><identifier>", "<call>"));
//        list.add(new Pair("<identifier><left-parenthesis><parameter><right-parenthesis>", "<call>"));
//        list.add(new Pair("<identifier>", "<expression>"));
//        list.add(new Pair("<datatype><identifier><operator><expression>", "<expression>"));
//        list.add(new Pair("<identifier><operator><identifier>", "<expression>"));
//        list.add(new Pair("<call><semicolon>", "<statement>"));
//        list.add(new Pair("<expression><semicolon>", "<statement>"));
//        list.add(new Pair("<statement><statement>", "<statement>"));
//        list.add(new Pair("<datatype><identifier><left-parenthesis><parameter><right-parenthesis><left-curly><statement><right-curly>", "<function>"));
//        list.add(new Pair("<using><namespace><std><semicolon>", "<namespacing>"));
//        list.add(new Pair("<include>", "<header>"));
//        list.add(new Pair("<header><namespacing><function>", "<program>"));
//        list.add(new Pair("<program>", "<start>"));
        
        
    }
    
    public static boolean check(String source)
    {
        if (source.equals("<start>"))
        {
            System.out.println("---------------END----------------");
            return true;
        }
        
        for (Pair pair : list)
        {
            if (source.contains(pair.key))
            {
                System.out.println(source);
                if (check(source.replaceFirst(pair.key, pair.value)))
                {
                    return true;
                }
            }
        }
        
//        Iterator iterator = map.keySet().iterator();
//        
//        while (iterator.hasNext())
//        {
//            String next = (String) iterator.next();
//            if (source.contains(next))
//            {
//                System.out.println(source);
//                if (check(source.replaceFirst(next, map.get(next))))
//                {
//                    return true;
//                }
//            }
//        }
        
        return false;
    }
    
    
//    public static boolean test(String source)
//    {
//        return check(source, "<start>");
//    }
//    
//    private static boolean check(String source, String reference)
//    {
//        if (source.equals(reference))
//        {
//            return true;
//        }
//        
//        for (String s : nonterminal)
//        {
//            String[] productions = (String[]) map.get(s);
//            
//            for (String t : productions)
//            {
//                if (check(source, reference.replaceFirst(s, t)))
//                {
//                    return true;
//                }
//            }
//        }
//        
//        return false;
//    }
}
