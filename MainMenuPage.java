import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class MainMenuPage extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonSpeed;
    private JButton buttonMenu;
    private JButton buttonTemp;
    private JLabel statusBar;
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public MainMenuPage() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonSpeed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSpeed();
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        //Create the menu bar.
        //MenuDropDown();
        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Menu Button Clicked!");
                if (buttonMenu.isSelected()){
                    buttonMenu.setSelected(false);
                    statusBar.setText("Main Menu Disabled cause you're here MORON!.");
                }
                else
                {
                    buttonMenu.setSelected(true);
                    statusBar.setText("Main Menu");
                }

            }
        });
        buttonTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("HOT Buttontemp Clicked!");
                if (buttonTemp.isSelected()){
                    buttonTemp.setSelected(false);
                    statusBar.setText("Temp is really kinda of HOT!!! ###F or ###C <set lang>");
                }
                else
                {
                    buttonTemp.setSelected(true);
                    statusBar.setText("My butt is hot. <CLICKED>");
                }
            }
        });
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = PopupMenuDemo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void onOK() {
        if (buttonOK.isSelected()){
            buttonOK.setSelected(false);
            statusBar.setText("STATUS button UNclicked & sucks");
        }
        else
        {
            buttonOK.setSelected(true);
            statusBar.setText("Status still sucksclicked");
        }
    }

    // onSpeed
    private void onSpeed() {
        System.out.println("On Speed button clicked");
        if (buttonSpeed.isSelected()){
            buttonSpeed.setSelected(false);
            statusBar.setText("On Speed button UNclicked");
        }
        else
        {
            buttonSpeed.setSelected(true);
            statusBar.setText("On Speed button clicked");
        }
    }

    private void onCancel() {
// add your code here if necessary
        System.out.println("CANCEL BUTTON CLICKED");
        dispose();
    }

    public static void main(String[] args) {
        MainMenuPage dialog = new MainMenuPage();
        dialog.setUndecorated(true);
        dialog.pack();
        dialog.setSize(480,360);
        dialog.setVisible(true);
        System.exit(0);
    }
}
