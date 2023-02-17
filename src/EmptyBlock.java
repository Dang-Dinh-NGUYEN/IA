public class EmptyBlock extends Block {
    private static EmptyBlock instance;

    private EmptyBlock(){
        super(' ');
    }

    public static EmptyBlock getInstance(){
        if(instance == null)
            instance = new EmptyBlock();
        return instance;
    }


}
