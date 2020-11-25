import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private int Width;
    private int Height;
    private TextField textArea;

    private JPanel jPanel1, newpanel;
    JLabel jLabel;

    public MyFrame() throws HeadlessException {
        this.setTitle("作业");
        //    this.setLayout(null);
        this.setResizable(false);


        jPanel1 = new JPanel();
        jPanel1.setLayout(null);


        init();


        textArea = new TextField();
        JButton jButton = new JButton("change");

        jButton.setBounds(Width / 4, Height / 4, Width / 6, Height / 24);
        jButton.addActionListener(e -> changePanel());
        jPanel1.add(jButton);

        textArea.setBounds(Width / 12, Height / 2 - Height / 6, Width / 6, Height / 24);

        textArea.setFont(new Font(null, Font.BOLD, 15));


        jPanel1.add(textArea);


        this.add(jPanel1);
    }

    private void init() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        Width = dimension.width;
        Height = dimension.height;

        this.setBounds(Width / 4, Height / 4, Width / 2, Height / 2);
        Width /= 2;
        Height /= 2;

    }

    private void changePanel() {
        newpanel = new JPanel();
        jLabel = new JLabel();
        jLabel.setBounds(Width / 4, Height / 4, Width / 2, Height / 2);
        jLabel.setText("张辉");
        newpanel.add(jLabel);
        this.remove(jPanel1);
        this.add(newpanel);

    }

    public MyFrame(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
    }
}
