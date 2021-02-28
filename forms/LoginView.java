import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Feb 28 20:41:11 WET 2021
 */



/**
 * @author youssef
 */
public class LoginView extends JFrame {
	public LoginView() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		panel2 = new JPanel();
		label1 = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		button1 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel2 ========
		{
			panel2.setLayout(null);

			//---- label1 ----
			label1.setText("text");
			label1.setPreferredSize(new Dimension(50, 14));
			label1.setMinimumSize(new Dimension(50, 14));
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setFont(label1.getFont().deriveFont(Font.BOLD, 27f));
			panel2.add(label1);
			label1.setBounds(0, 0, 373, 45);

			//---- textField1 ----
			textField1.setHorizontalAlignment(SwingConstants.CENTER);
			panel2.add(textField1);
			textField1.setBounds(6, 63, 360, 30);

			//---- textField2 ----
			textField2.setHorizontalAlignment(SwingConstants.CENTER);
			panel2.add(textField2);
			textField2.setBounds(6, 98, 360, 30);

			//---- button1 ----
			button1.setText("text");
			button1.setBackground(new Color(0, 51, 255));
			button1.setForeground(Color.white);
			panel2.add(button1);
			button1.setBounds(6, 138, 360, 30);

			{ // compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel2.getComponentCount(); i++) {
					Rectangle bounds = panel2.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panel2.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panel2.setMinimumSize(preferredSize);
				panel2.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(panel2);
		panel2.setBounds(new Rectangle(new Point(211, 169), panel2.getPreferredSize()));

		contentPane.setPreferredSize(new Dimension(815, 530));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel panel2;
	private JLabel label1;
	private JTextField textField1;
	private JTextField textField2;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
