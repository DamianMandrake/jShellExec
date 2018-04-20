//should be singleton?
public class LsImpl extends ActionListenerImpl{

    private final static String ACTION = "ls";
    private String streamContents;
    public LsImpl(String arguments[]){
        super(ACTION,arguments);

    }
    /* Overriding ActionListenerImpl*/
    @Override
    public String getAction(){
        return LsImpl.ACTION;
    }

    @Override
    public void go(String[] textFieldText){
        //todo do something
        this.addCommands(new String[]{textFieldText[0]});
        this.streamContents = super.execChildProcess();
        System.out.println(this.streamContents);
        this.clearAndReinit(ACTION);
    }

    @Override
    public String getStreamData(){
        return this.streamContents;
    }
}