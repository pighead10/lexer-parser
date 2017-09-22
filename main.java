import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to tokenize:");
        String input = sc.nextLine();
        Lexer lexer = new Lexer(input);

        ArrayList<HashMap<String, TableEntry>> actionTable = new ArrayList<HashMap<String, TableEntry>>();
        HashMap<String, TableEntry> row0 = new HashMap<>();
        row0.put("+", new TableEntry(TypeEnum.NONE, 0, "", null));
        row0.put("-", new TableEntry(TypeEnum.SHIFT, 4, "", null));
        row0.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row0.put("cos", new TableEntry(TypeEnum.SHIFT, 7, "", null));
        row0.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row0.put("float", new TableEntry(TypeEnum.SHIFT, 9, "", null));
        row0.put("$", new TableEntry(TypeEnum.NONE, 0, "", null));

        HashMap<String, TableEntry> row1 = new HashMap<>();
        row1.put("+", new TableEntry(TypeEnum.NONE, 0, "", null));
        row1.put("-", new TableEntry(TypeEnum.NONE, 0, "", null));
        row1.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row1.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row1.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row1.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row1.put("$", new TableEntry(TypeEnum.ACCEPT, 0, "", null));

        HashMap<String, TableEntry> row2 = new HashMap<>();
        row2.put("+", new TableEntry(TypeEnum.SHIFT, 10, "", null));
        row2.put("-", new TableEntry(TypeEnum.NONE, 0, "", null));
        row2.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row2.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row2.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row2.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        ArrayList<String> add = new ArrayList<String>();
        add.add("add");
        row2.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("S", add)));


        ArrayList<String> sub = new ArrayList<String>();
        sub.add("sub");

        ArrayList<String> mult = new ArrayList<String>();
        mult.add("mult");

        ArrayList<String> cosine = new ArrayList<String>();
        cosine.add("cosine");

        ArrayList<String> fac = new ArrayList<String>();
        fac.add("fac");
        
        ArrayList<String> Float = new ArrayList<String>();
        Float.add("float");

        ArrayList<String> sub_mult = new ArrayList<String>();
        sub_mult.add("-");
        sub_mult.add("mult");

        ArrayList<String> cos_cosine = new ArrayList<String>();
        cos_cosine.add("cos");
        cos_cosine.add("cosine");

        ArrayList<String> fac_exc = new ArrayList<String>();
        fac_exc.add("fac");
        fac_exc.add("!");

        ArrayList<String> add_pl_sub = new ArrayList<String>();
        add_pl_sub.add("add");
        add_pl_sub.add("+");
        add_pl_sub.add("sub");

        ArrayList<String> sub_min_mult = new ArrayList<String>();
        sub_min_mult.add("sub");
        sub_min_mult.add("-");
        sub_min_mult.add("mult");

        ArrayList<String> cosine_times_mult = new ArrayList<String>();
        cosine_times_mult.add("cosine");
        cosine_times_mult.add("*");
        cosine_times_mult.add("mult");


        HashMap<String, TableEntry> row3 = new HashMap<>();
        row3.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("add", sub)));
        row3.put("-", new TableEntry(TypeEnum.SHIFT, 11, "", null));
        row3.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row3.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row3.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row3.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row3.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("add", sub)));

        HashMap<String, TableEntry> row4 = new HashMap<>();
        row4.put("+", new TableEntry(TypeEnum.NONE, 0, "", null));
        row4.put("-", new TableEntry(TypeEnum.NONE, 0, "", null));
        row4.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row4.put("cos", new TableEntry(TypeEnum.SHIFT, 7, "", null));
        row4.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row4.put("float", new TableEntry(TypeEnum.SHIFT, 9, "", null));
        row4.put("$", new TableEntry(TypeEnum.NONE, 0, "", null));

        HashMap<String, TableEntry> row5 = new HashMap<>();
        row5.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", mult)));
        row5.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", mult)));
        row5.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row5.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row5.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row5.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row5.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", mult)));

        HashMap<String, TableEntry> row6 = new HashMap<>();
        row6.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("mult", cosine)));
        row6.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("mult", cosine)));
        row6.put("*", new TableEntry(TypeEnum.SHIFT, 13, "", null));
        row6.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row6.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row6.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row6.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("mult", cosine)));

        HashMap<String, TableEntry> row7 = new HashMap<>();
        row7.put("+", new TableEntry(TypeEnum.NONE, 0, "", null));
        row7.put("-", new TableEntry(TypeEnum.NONE, 0, "", null));
        row7.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row7.put("cos", new TableEntry(TypeEnum.SHIFT, 7, "", null));
        row7.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row7.put("float", new TableEntry(TypeEnum.SHIFT, 9, "", null));
        row7.put("$", new TableEntry(TypeEnum.NONE, 0, "", null));

        HashMap<String, TableEntry> row8 = new HashMap<>();
        row8.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", fac)));
        row8.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", fac)));
        row8.put("*", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", fac)));
        row8.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row8.put("!", new TableEntry(TypeEnum.SHIFT, 15, "", null));
        row8.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row8.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", fac)));

        HashMap<String, TableEntry> row9 = new HashMap<>();
        row9.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", Float)));
        row9.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", Float)));
        row9.put("*", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", Float)));
        row9.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row9.put("!", new TableEntry(TypeEnum.SHIFT, 15, "", new Reduction("fac", Float)));
        row9.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row9.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", Float)));

        HashMap<String, TableEntry> row10 = new HashMap<>();
        row10.put("+", new TableEntry(TypeEnum.NONE, 0, "", null));
        row10.put("-", new TableEntry(TypeEnum.SHIFT, 4, "", null));
        row10.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row10.put("cos", new TableEntry(TypeEnum.SHIFT, 7, "", null));
        row10.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row10.put("float", new TableEntry(TypeEnum.SHIFT, 9, "", null));
        row10.put("$", new TableEntry(TypeEnum.SHIFT, 0, "", null));

        HashMap<String, TableEntry> row11 = new HashMap<>();
        row11.put("+", new TableEntry(TypeEnum.NONE, 0, "", null));
        row11.put("-", new TableEntry(TypeEnum.NONE, 0, "", null));
        row11.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row11.put("cos", new TableEntry(TypeEnum.SHIFT, 7, "", null));
        row11.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row11.put("float", new TableEntry(TypeEnum.SHIFT, 9, "", null));
        row11.put("$", new TableEntry(TypeEnum.SHIFT, 0, "", null));

        HashMap<String, TableEntry> row12 = new HashMap<>();
        row12.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", sub_mult)));
        row12.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", sub_mult)));
        row12.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row12.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row12.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row12.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row12.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", sub_mult)));

        HashMap<String, TableEntry> row13 = new HashMap<>();
        row13.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", null));
        row13.put("-", new TableEntry(TypeEnum.NONE, 0, "", null));
        row13.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row13.put("cos", new TableEntry(TypeEnum.SHIFT, 7, "", null));
        row13.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row13.put("float", new TableEntry(TypeEnum.SHIFT, 9, "", null));
        row13.put("$", new TableEntry(TypeEnum.NONE, 0, "", null));

        HashMap<String, TableEntry> row14 = new HashMap<>();
        row14.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", cos_cosine)));
        row14.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", cos_cosine)));
        row14.put("*", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", cos_cosine)));
        row14.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row14.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row14.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row14.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("cosine", cos_cosine)));

        HashMap<String, TableEntry> row15 = new HashMap<>();
        row15.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", fac_exc)));
        row15.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", fac_exc)));
        row15.put("*", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", fac_exc)));
        row15.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row15.put("!", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", fac_exc)));
        row15.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row15.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("fac", fac_exc)));

        HashMap<String, TableEntry> row16 = new HashMap<>();
        row16.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("add", add_pl_sub)));
        row16.put("-", new TableEntry(TypeEnum.SHIFT, 11, "", null));
        row16.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row16.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row16.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row16.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row16.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("add", add_pl_sub)));

        HashMap<String, TableEntry> row17 = new HashMap<>();
        row17.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", sub_min_mult)));
        row17.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", sub_min_mult)));
        row17.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row17.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row17.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row17.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row17.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("sub", sub_min_mult)));

        HashMap<String, TableEntry> row18 = new HashMap<>();
        row18.put("+", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("mult", cosine_times_mult)));
        row18.put("-", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("mult", cosine_times_mult)));
        row18.put("*", new TableEntry(TypeEnum.NONE, 0, "", null));
        row18.put("cos", new TableEntry(TypeEnum.NONE, 0, "", null));
        row18.put("!", new TableEntry(TypeEnum.NONE, 0, "", null));
        row18.put("float", new TableEntry(TypeEnum.NONE, 0, "", null));
        row18.put("$", new TableEntry(TypeEnum.REDUCE, 0, "", new Reduction("mult", cosine_times_mult)));

        actionTable.add(row0);
        actionTable.add(row1);
        actionTable.add(row2);
        actionTable.add(row3);
        actionTable.add(row4);
        actionTable.add(row5);
        actionTable.add(row6);
        actionTable.add(row7);
        actionTable.add(row8);
        actionTable.add(row9);
        actionTable.add(row10);
        actionTable.add(row11);
        actionTable.add(row12);
        actionTable.add(row13);
        actionTable.add(row14);
        actionTable.add(row15);
        actionTable.add(row16);
        actionTable.add(row17);
        actionTable.add(row18);

        ArrayList<HashMap<String, Integer>> gotoTable = new ArrayList<HashMap<String, Integer>>();
        HashMap<String, Integer> goto0 = new HashMap<>();
        goto0.put("S", 1);
        goto0.put("add", 2);
        goto0.put("sub", 3);
        goto0.put("mult", 5);
        goto0.put("cosine", 6);
        goto0.put("fac", 8);

        HashMap<String, Integer> goto1 = new HashMap<>();
        goto1.put("S", -1);
        goto1.put("add", -1);
        goto1.put("sub", -1);
        goto1.put("mult", -1);
        goto1.put("cosine", -1);
        goto1.put("fac", -1);

        HashMap<String, Integer> goto2 = new HashMap<>();
        goto2.put("S", -1);
        goto2.put("add", -1);
        goto2.put("sub", -1);
        goto2.put("mult", -1);
        goto2.put("cosine", -1);
        goto2.put("fac", -1);

        HashMap<String, Integer> goto3 = new HashMap<>();
        goto3.put("S", -1);
        goto3.put("add", -1);
        goto3.put("sub", -1);
        goto3.put("mult", -1);
        goto3.put("cosine", -1);
        goto3.put("fac", -1);

        HashMap<String, Integer> goto4 = new HashMap<>();
        goto4.put("S", -1);
        goto4.put("add", -1);
        goto4.put("sub", -1);
        goto4.put("mult", 12);
        goto4.put("cosine", 6);
        goto4.put("fac", 8);

        HashMap<String, Integer> goto5 = new HashMap<>();
        goto5.put("S", -1);
        goto5.put("add", -1);
        goto5.put("sub", -1);
        goto5.put("mult", -1);
        goto5.put("cosine", -1);
        goto5.put("fac", -1);

        HashMap<String, Integer> goto6 = new HashMap<>();
        goto6.put("S", -1);
        goto6.put("add", -1);
        goto6.put("sub", -1);
        goto6.put("mult", -1);
        goto6.put("cosine", -1);
        goto6.put("fac", -1);

        HashMap<String, Integer> goto7 = new HashMap<>();
        goto7.put("S", -1);
        goto7.put("add", -1);
        goto7.put("sub", -1);
        goto7.put("mult", -1);
        goto7.put("cosine", 14);
        goto7.put("fac", 8);

        HashMap<String, Integer> goto8 = new HashMap<>();
        goto8.put("S", -1);
        goto8.put("add", -1);
        goto8.put("sub", -1);
        goto8.put("mult", -1);
        goto8.put("cosine", -1);
        goto8.put("fac", -1);

        HashMap<String, Integer> goto9 = new HashMap<>();
        goto9.put("S", -1);
        goto9.put("add", -1);
        goto9.put("sub", -1);
        goto9.put("mult", -1);
        goto9.put("cosine", -1);
        goto9.put("fac", -1);

        HashMap<String, Integer> goto10 = new HashMap<>();
        goto10.put("S", -1);
        goto10.put("add", -1);
        goto10.put("sub", 16);
        goto10.put("mult", 5);
        goto10.put("cosine", 6);
        goto10.put("fac", 8);

        HashMap<String, Integer> goto11 = new HashMap<>();
        goto11.put("S", -1);
        goto11.put("add", -1);
        goto11.put("sub", -1);
        goto11.put("mult", 17);
        goto11.put("cosine", 6);
        goto11.put("fac", 8);

        HashMap<String, Integer> goto12 = new HashMap<>();
        goto12.put("S", -1);
        goto12.put("add", -1);
        goto12.put("sub", -1);
        goto12.put("mult", -1);
        goto12.put("cosine", -1);
        goto12.put("fac", -1);

        HashMap<String, Integer> goto13 = new HashMap<>();
        goto13.put("S", -1);
        goto13.put("add", -1);
        goto13.put("sub", -1);
        goto13.put("mult", 18);
        goto13.put("cosine", 6);
        goto13.put("fac", 8);

        HashMap<String, Integer> goto14 = new HashMap<>();
        goto14.put("S", -1);
        goto14.put("add", -1);
        goto14.put("sub", -1);
        goto14.put("mult", -1);
        goto14.put("cosine", -1);
        goto14.put("fac", -1);

        HashMap<String, Integer> goto15 = new HashMap<>();
        goto15.put("S", -1);
        goto15.put("add", -1);
        goto15.put("sub", -1);
        goto15.put("mult", -1);
        goto15.put("cosine", -1);
        goto15.put("fac", -1);

        HashMap<String, Integer> goto16 = new HashMap<>();
        goto16.put("S", -1);
        goto16.put("add", -1);
        goto16.put("sub", -1);
        goto16.put("mult", -1);
        goto16.put("cosine", -1);
        goto16.put("fac", -1);

        HashMap<String, Integer> goto17 = new HashMap<>();
        goto17.put("S", -1);
        goto17.put("add", -1);
        goto17.put("sub", -1);
        goto17.put("mult", -1);
        goto17.put("cosine", -1);
        goto17.put("fac", -1);

        HashMap<String, Integer> goto18 = new HashMap<>();
        goto18.put("S", -1);
        goto18.put("add", -1);
        goto18.put("sub", -1);
        goto18.put("mult", -1);
        goto18.put("cosine", -1);
        goto18.put("fac", -1);

        gotoTable.add(goto0);
        gotoTable.add(goto1);
        gotoTable.add(goto2);
        gotoTable.add(goto3);
        gotoTable.add(goto4);
        gotoTable.add(goto5);
        gotoTable.add(goto6);
        gotoTable.add(goto7);
        gotoTable.add(goto8);
        gotoTable.add(goto9);
        gotoTable.add(goto10);
        gotoTable.add(goto11);
        gotoTable.add(goto12);
        gotoTable.add(goto13);
        gotoTable.add(goto14);
        gotoTable.add(goto15);
        gotoTable.add(goto16);
        gotoTable.add(goto17);
        gotoTable.add(goto18);

        Parser parser = new Parser(actionTable, gotoTable);

        ArrayList<Token> tokens = new ArrayList<>();
        while(lexer.isInputRemaining()){
            try {
                Token token = lexer.getToken();
                tokens.add(token);
                System.out.println(token.name + ": " + token.attribute);
            }catch(InvalidInputException e){
                System.out.println(e.getMessage());
            }
        }

        tokens.add(new Token(TokenName.END, "$"));

        parser.parse(input, tokens);
    }
}
