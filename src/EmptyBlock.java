public class EmptyBlock extends Block {
    private static EmptyBlock instance;

    private EmptyBlock(){
        super('e');
    }

    public static EmptyBlock getInstance(){
        if(instance == null)
            instance = new EmptyBlock();
        return instance;
    }


}
