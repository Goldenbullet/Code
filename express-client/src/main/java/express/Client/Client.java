package express.Client;

import java.awt.CardLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.AutumnSkin;
import org.jvnet.substance.skin.CremeSkin;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.skin.ModerateSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.theme.SubstanceAquaTheme;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.MatteHeaderPainter;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import express.presentation.mainUI.MainUI;
import express.presentation.mainUI.MainUIService;
import express.presentation.userUI.SignInUI;
import express.rmi.ClientException;
import express.rmi.RMIClient;

public class Client extends JFrame {
	private SignInUI signin;
	private CardLayout card;
	private JPanel container;
	private MainUIService main;

	public Client() {

		this.setLayout(null);
		container = new JPanel();
		container.setBounds(0, 0, 1000, 700);
		// this.setContentPane(container);
		card = new CardLayout();
		container.setLayout(card);

		main = new MainUI(card, container);
		signin = new SignInUI(main);
		this.add(container);
		container.add("signin", signin);
		card.show(container, "signin");

		// Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setUndecorated(true);
		// this.setLocation(screenSize.width/2-1200/2,screenSize.height/2-900/2);
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {

//		try {
//			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
//			JFrame.setDefaultLookAndFeelDecorated(true);
//			JDialog.setDefaultLookAndFeelDecorated(true);
//			SubstanceLookAndFeel
//					.setCurrentTheme(new SubstanceAquaTheme());
//			SubstanceLookAndFeel.setSkin(new CremeSkin());
//			SubstanceLookAndFeel
//					.setCurrentButtonShaper(new StandardButtonShaper());
//			SubstanceLookAndFeel
//					.setCurrentWatermark(new SubstanceBubblesWatermark());
//			SubstanceLookAndFeel
//					.setCurrentBorderPainter(new StandardBorderPainter());
//			SubstanceLookAndFeel
//					.setCurrentGradientPainter(new StandardGradientPainter());
//			SubstanceLookAndFeel.setCurrentTitlePainter(new MatteHeaderPainter());
//		} catch (Exception e) {
//			System.err.println("Something went wrong!");
//		}

		try {
			RMIClient.init();
			new Client();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}
}
