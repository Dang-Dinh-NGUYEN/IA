public class Block {
    private char value;

    public Block(char value){
        this.value = value;
    }

    public char getValue(){
        return value;
    }

    public String toString(){
        return String.valueOf(this.getValue());
    }

}

