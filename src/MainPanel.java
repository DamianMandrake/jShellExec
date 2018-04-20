import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class MainPanel extends Panel implements ActionListener{
	private ArrayList<ActionListenerImpl> buttonImpls;
	private ArrayList<String> actions;
	private ArrayList<Button> buttons;
	private static MainPanel ref;
	private static int NUM_ACTIONS = 0;
	private TextField arg1, arg2;
	private Label tf1Descr, tf2Descr;

	private TextArea solution;
	private Panel inner;

	public MainPanel( /*ArrayList<String> actions,ArrayList<ActionListenerImpl> buttonsImpls*/){

		this.setLayout(new BorderLayout());
		this.buttons = new ArrayList();
		this.buttonImpls = new ArrayList();
		this.tf1Descr = new Label("Parameter 1");
		this.arg1 = new TextField(50);
		this.tf2Descr = new Label("Parameter 2");
		this.arg2 = new TextField(50);
		this.solution = new TextArea(30,50);
		this.add(inner=new Panel());

		this.inner.add(this.tf1Descr);
		this.inner.add(arg1);
		this.inner.add(tf2Descr);
		this.inner.add(arg2);

		this.add(this.solution,BorderLayout.EAST);
	}


	@Override
	public void actionPerformed(ActionEvent source){
		String a =this.arg1.getText(), b= this.arg2.getText();
		ActionListenerImpl impl = this.buttonImpls.get(Integer.parseInt(source.getActionCommand()));
		impl.go(new String[] { a , b});
		this.solution.setText(impl.getStreamData());
	}

	public void addImpl(ActionListenerImpl impl){
		this.buttonImpls.add(impl);
		this.handleButtons(impl.getAction());
	}



	private void handleButtons(String command){
		Button b =  new Button();
		b.setActionCommand(NUM_ACTIONS+"");
		this.buttons.add(b);
		b.setLabel(command);
		b.addActionListener(this);
		this.inner.add(b);
		NUM_ACTIONS++;
	}





}