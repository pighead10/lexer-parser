import org.omg.CORBA.DynAnyPackage.Invalid;

public class Lexer {
    private String input;
    private int lexemeBegin;
    private int forward;

    public Lexer(String input){
        this.input = input.replaceAll("\\s+","");
        forward = -1;
    }

    public boolean isInputRemaining(){
        return forward < (input.length()-1);
    }

    private CharWrapper getNextCharacter(){
        if(isInputRemaining()){
            forward++;
            return new CharWrapper(input.charAt(forward), false);
        }else{
            forward++;
            return new CharWrapper('0',true);
        }
    }

    private void retract(){
        forward--;
    }

    public Token getToken() throws InvalidInputException{
        lexemeBegin = forward + 1;
        int state = 0;
        while(true){
            CharWrapper c;
            switch(state){
                case 0:
                    c = getNextCharacter();
                    if(c.eof) throw new InvalidInputException("Unexpected eof at character " + forward + " of " + input);
                    else if(c.character == '!') state = 1;
                    else if(c.character == '-') state = 2;
                    else if(c.character == '+') state = 3;
                    else if(c.character == '*') state = 4;
                    else if(c.character == 'c') state = 5;
                    else if(Character.isDigit(c.character)) state = 8;
                    else throw new InvalidInputException("Unexpected character '" + c.character + "' at character " + forward + " of " + input);
                    break;
                case 1:
                    return new Token(TokenName.OP, "FAC");
                case 2:
                    return new Token(TokenName.OP, "SUB");
                case 3:
                    return new Token(TokenName.OP, "ADD");
                case 4:
                    return new Token(TokenName.OP, "MULT");
                case 5:
                    c = getNextCharacter();
                    if(c.character == 'o') state = 6;
                    else throw new InvalidInputException("Unexpected character '" + c.character + "' at character " + forward + " of " + input);
                    break;
                case 6:
                    c = getNextCharacter();
                    if(c.character == 's') state = 7;
                    else throw new InvalidInputException("Unexpected character '" + c.character + "' at character " + forward + " of " + input);
                    break;
                case 7:
                    return new Token(TokenName.OP, "COS");
                case 8:
                    c = getNextCharacter();
                    if(c.eof) state = 12;
                    else if(Character.isDigit(c.character)) state = 8;
                    else if(c.character == '.') state = 9;
                    else state = 12;
                    break;
                case 9:
                    c = getNextCharacter();
                    if(c.eof) throw new InvalidInputException("Unexpected eof at character " + forward + " of " + input);
                    if(Character.isDigit(c.character)) state = 10;
                    else throw new InvalidInputException("Unexpected character '" + c + "' at character " + forward + "of " + input);
                    break;
                case 10:
                    c = getNextCharacter();
                    if(c.eof) state = 11;
                    else if(Character.isDigit(c.character)) state = 10;
                    else state = 11;
                    break;
                case 11:
                    retract();
                    return new Token(TokenName.NUMBER, input.substring(lexemeBegin, forward+1));
                case 12:
                    retract();
                    return new Token(TokenName.NUMBER, input.substring(lexemeBegin, forward+1));
            }
        }
    }
}
