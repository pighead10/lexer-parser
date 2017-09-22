public class TableEntry {
    public TypeEnum type;
    public int shiftState;
    public String production;
    public Reduction reduction;

    public TableEntry(TypeEnum type, int shiftState, String production, Reduction reduction){
        this.type = type;
        this.shiftState = shiftState;
        this.production = production;
        this.reduction = reduction;
    }
}
