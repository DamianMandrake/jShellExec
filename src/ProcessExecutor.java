/*
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class ProcessExecutor {
	
	public interface ProcessExecutorCallback{
		public void call(String response);
	}

	private ArrayList commands;
	private BufferedReader buf;
	private ProcessExecutorCallback callback;
	*/
/**
	 * This class runs the list of commands provided. These run as a child process.
	 * @param  commands [the command along with the arguments]
	 *//*

	public ProcessExecutor(ArrayList<String> commands ){
		this.commands=commands;
	}
	*/
/** Returns the data present in the output stream of the child process. *//*

	public String start(){
		try{


			ProcessBuilder processBuilder = new ProcessBuilder(this.commands);
			Process process = processBuilder.start();

			this.buf = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String x ="";
			StringBuilder strBuilder = new StringBuilder();
			while( ( x= this.buf.readLine())!=null){
				strBuilder.append(x);
			}

			return strBuilder.toString();


		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	


}*/
