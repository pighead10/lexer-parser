public class Token {
    public TokenName name;
    public String attribute;

    public Token(TokenName name, String attribute){
        this.name = name;
        this.attribute = attribute;
    }

    public String getSymbol(){
        if(name == TokenName.NUMBER) {
            return "float";
        }else if(name == TokenName.END){
            return "$";
        }else{
            if(attribute.equals("ADD")){
                return "+";
            }else if(attribute.equals("SUB")){
                return "-";
            }else if(attribute.equals("MULT")) {
                return "*";
            }else if(attribute.equals("COS")) {
                return "cos";
            }else if(attribute.equals("FAC")) {
                return "!";
            }else{
                System.out.println("wtf?");
                return "";
            }
        }
    }
}
