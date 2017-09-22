import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Parser {
    ArrayList<HashMap<String, TableEntry>> actionTable;
    ArrayList<HashMap<String, Integer>> gotoTable;

    Parser(ArrayList<HashMap<String, TableEntry>> actionTable, ArrayList<HashMap<String, Integer>> gotoTable){
        this.actionTable = actionTable;
        this.gotoTable = gotoTable;
    }

    public void parse(String input, ArrayList<Token> tokens){
        int index = 0;
        Token a = tokens.get(index);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(true){
            int s = stack.peek();
            if(actionTable.get(s).get(a.getSymbol()).type == TypeEnum.SHIFT){
                stack.push(actionTable.get(s).get(a.getSymbol()).shiftState);
                a = tokens.get(++index);
            }else if(actionTable.get(s).get(a.getSymbol()).type == TypeEnum.REDUCE){
                Reduction r = actionTable.get(s).get(a.getSymbol()).reduction;
                int n = r.rhs.size();
                for(int i=0;i<n;i++){
                    stack.pop();
                }
                int t = stack.peek();
                stack.push(gotoTable.get(t).get(r.lhs));
                System.out.print(r.lhs + " -> ");
                for(int i=0; i < r.rhs.size(); i++){
                    System.out.print(r.rhs.get(i) + " ");
                }
                System.out.println();
            }else if(actionTable.get(s).get(a.getSymbol()).type == TypeEnum.ACCEPT){
                System.out.println("Success");
                break; //done!
            }else{
                System.out.println("An error occurred");
                break;
            }
        }
    }
}
