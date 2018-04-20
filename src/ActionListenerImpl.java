
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public abstract class ActionListenerImpl{

    protected ArrayList<String> commands;

    /** This class takes a command and a list of arguments and executes them in a child process*/
    public ActionListenerImpl(String command,String arguments[]){
        this.commands = new ArrayList();
        this.commands.add(command);

        if(arguments!=null)
            for(String arg:arguments)
                this.commands.add(arg);

    }

    /**
     * NOTE : the actual command is at arr[0]. The add call just serves as parameters to the shell command.[To be used
     * through the ui].
     * **/
    public void addCommands(String[] arguments){
        if(arguments!=null)
            for(String arg:arguments)
                this.commands.add(arg);
    }

    /**
     * This function executes the child process and returns the contents present in its stream.
     * @return String [returns the contents of the process ]
     */
    protected final String execChildProcess(){
        ProcessExecutor processExecutor = new ProcessExecutor(this.commands);
        return processExecutor.start();
    }

    /* invoked for an action command*/
    public abstract void go(String[] textFieldText);
    /* Denotes the type of command impl this is . */
    public abstract String getAction();


    /* function must return the data present in the stream*/
    public abstract String getStreamData();

    protected void clearAndReinit(String action){
        this.commands.clear();
        this.commands.add(action);
    }

    class ProcessExecutor {


        private ArrayList commands;
        private BufferedReader buf;
        //private ProcessExecutorCallback callback;
        /**
         * This class runs the list of commands provided. These run as a child process.
         * @param  commands [the command along with the arguments]
         */
        public ProcessExecutor(ArrayList<String> commands ){
            this.commands=commands;
        }

        /** Returns the data present in the output stream of the child process. */
        public String start(){
            try{


                ProcessBuilder processBuilder = new ProcessBuilder(this.commands);
                Process process = processBuilder.start();

                this.buf = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String x ="";
                StringBuilder strBuilder = new StringBuilder();
                while( ( x= this.buf.readLine())!=null){
                    strBuilder.append(x+"\n");
                }

                return strBuilder.toString();


            }
            catch(IOException ioe){
                ioe.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }



    }


}
