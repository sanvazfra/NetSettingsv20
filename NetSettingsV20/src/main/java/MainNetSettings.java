import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.netsettings.application.view.MainWindow;
import com.netsettings.application.view.MainWindowImp;


public class MainNetSettings {
	
	public static void main(String args[]){
		try {
			//com.sun.java.swing.plaf.windows.WindowsLookAndFeel
			//com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			MainWindow mainWindow = new MainWindowImp();
			mainWindow.mostrarVentana(true);
		} catch (ClassNotFoundException | InstantiationException| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
