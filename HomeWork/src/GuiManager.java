import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
/*
 * Created by JFormDesigner on Sat Nov 21 10:53:12 CST 2020
 */


/**
 * @author 崔博
 */
public class GuiManager extends JFrame {
    private Boolean hasfile;

    public GuiManager() {


        hasfile = false;

        initComponents();
        init();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 崔博
        label2 = new JLabel();
        panel2 = new JPanel();
        label = new JLabel();
        nameInput = new JTextField();
        confirm = new JButton();
        panel3 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        content = new JTextArea();
        changeContent = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2);

        //======== panel2 ========
        {
            panel2.setPreferredSize(new Dimension(180, 73));
            panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel2. getBorder( )) ); panel2. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

            //---- label ----
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(label.getFont().deriveFont(label.getFont().getSize() + 9f));
            label.setAlignmentX(0.5F);
            label.setMaximumSize(new Dimension(146, 40));
            label.setText("\u8f93\u5165\u6587\u4ef6\u540d");
            panel2.add(label);

            //---- nameInput ----
            nameInput.setFont(nameInput.getFont().deriveFont(nameInput.getFont().getSize() + 6f));
            nameInput.setMinimumSize(new Dimension(40, 20));
            nameInput.setPreferredSize(new Dimension(30, 25));
            nameInput.setMargin(new Insets(2, 6, 2, 3));
            nameInput.setMaximumSize(new Dimension(150, 30));
            panel2.add(nameInput);

            //---- confirm ----
            confirm.setText("\u786e\u5b9a");
            confirm.setFont(confirm.getFont().deriveFont(confirm.getFont().getSize() + 5f));
            confirm.setMaximumSize(new Dimension(78, 40));
            confirm.setMinimumSize(new Dimension(78, 20));
            confirm.setPreferredSize(new Dimension(50, 20));
            confirm.setAlignmentX(0.5F);
            panel2.add(confirm);
        }
        contentPane.add(panel2);

        //======== panel3 ========
        {
            panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

            //---- label1 ----
            label1.setText("\u6587\u4ef6\u4fee\u6539\u6846");
            label1.setEnabled(false);
            label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 11f));
            label1.setAlignmentX(0.5F);
            panel3.add(label1);

            //======== scrollPane1 ========
            {
                scrollPane1.setPreferredSize(new Dimension(5, 90));
                scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane1.setAlignmentY(0.4F);

                //---- content ----
                content.setMaximumSize(new Dimension(2147483647, 300));
                content.setAlignmentY(0.6F);
                content.setPreferredSize(new Dimension(1, 20));
                content.setRows(100);
                scrollPane1.setViewportView(content);
            }
            panel3.add(scrollPane1);

            //---- changeContent ----
            changeContent.setText("\u4fee\u6539\u6587\u4ef6");
            changeContent.setFont(changeContent.getFont().deriveFont(changeContent.getFont().getStyle() | Font.BOLD, changeContent.getFont().getSize() + 8f));
            changeContent.setAlignmentX(0.5F);
            panel3.add(changeContent);
        }
        contentPane.add(panel3);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    private void init() {


        confirm.addActionListener(e -> {

            String filename = nameInput.getText();


            if (nameInput.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "文件名不能为空", "输入错误", JOptionPane.WARNING_MESSAGE);
                hasfile = false;
            } else {
                hasfile = true;

                File file = new File(filename);
                //    file.na
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null, "文件存在，可以修改");
                    try {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String t;
                        while ((t = bufferedReader.readLine()) != null) {
                            content.append(t + '\n');
                        }
                        bufferedReader.close();

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "文件不存在，已创建相关文件");

                }

            }

        });

        changeContent.addActionListener(e -> {
                    if (!hasfile) {
//说明并不存在需要修改的文件

                        JOptionPane.showMessageDialog(null, "请先确定要输入的文件", "操作错误", JOptionPane.WARNING_MESSAGE);

                    } else {//说明有需要修改的文件

                        File file = new File(nameInput.getText());
                        try {
                            FileWriter fileWriter = new FileWriter(file);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(content.getText());
                            bufferedWriter.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "文件修改成功", "操作成功", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        );


    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 崔博
    private JLabel label2;
    private JPanel panel2;
    private JLabel label;
    private JTextField nameInput;
    private JButton confirm;
    private JPanel panel3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea content;
    private JButton changeContent;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void change_panel() {
        //newJPanel = new JPanel();
//        newJPanel.


    }

    public static void main(String[] args) {
        GuiManager guiManager = new GuiManager();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        int Width = dimension.width;
        int Height = dimension.height;
        guiManager.setSize(Width / 2, Height / 2);
        guiManager.setVisible(true);
    }

}
