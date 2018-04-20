public class GrepImpl extends ActionListenerImpl {


    private final static String ACTION = "grep";
    private String streamContents;
    public GrepImpl(String args[]){
        super(ACTION,args);
        this.clearAndReinit("/bin/bash");
    }
    @Override
    public void go(String[] textFieldText) {
        this.addCommands(new String[]{'\''+textFieldText[0]+'\'',textFieldText[1]});
        System.out.println(super.commands);
        this.streamContents = super.execChildProcess();
        System.out.println(this.streamContents);
        this.clearAndReinit("/bin/bash");
    }

    @Override
    protected void clearAndReinit(String action) {
        super.clearAndReinit(action);
        super.commands.add("-c");
        super.commands.add(ACTION);
    }



    @Override
    public String getAction() {
        return GrepImpl.ACTION;
    }

    @Override
    public String getStreamData() {
        return this.streamContents;
    }
}
