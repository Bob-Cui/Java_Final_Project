import java.awt.*;
import java.io.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Nov 22 13:47:13 CST 2020
 */


/**
 * @author 崔博
 */
public class HomeWork extends JFrame {
    public HomeWork() {
        hasfile = false;
        this.setTitle("GUI");
        initComponents();
        init_CardLayout();
        change.addActionListener(e -> change_CardLayout());


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 崔博
        panel1 = new JPanel();
        label2 = new JLabel();
        change = new JButton();
        label1 = new JLabel();
        cardLayout = new JPanel();
        label3 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(3, 3));

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            panel1.setLayout(new GridLayout(5, 1));

            //---- label2 ----
            label2.setText("\u9009\u62e9\u914d\u7f6e\u6587\u4ef6");
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 6f));
            panel1.add(label2);

            //---- change ----
            change.setText("\u4fee\u6539\u754c\u9762\u6837\u5f0f");
            panel1.add(change);
        }
        contentPane.add(panel1, BorderLayout.WEST);

        //---- label1 ----
        label1.setText("Java\u7b2c\u56db\u6b21\u4f5c\u4e1a");
        label1.setMaximumSize(new Dimension(23, 30));
        label1.setMinimumSize(new Dimension(23, 30));
        label1.setPreferredSize(new Dimension(23, 30));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 8f));
        contentPane.add(label1, BorderLayout.NORTH);

        //======== cardLayout ========
        {
            cardLayout.setLayout(new CardLayout(1, 1));
        }
        contentPane.add(cardLayout, BorderLayout.CENTER);
        contentPane.add(label3, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 崔博
    private JPanel panel1;
    private JLabel label2;
    private JButton change;
    private JLabel label1;
    private JPanel cardLayout;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    // private void
    private Boolean hasfile;
    private JTextField fileinput;
    private JTextArea fileContent;


    private void init_CardLayout() {
        JPanel init_panel = new JPanel();

        //初始化最开始的Box布局,总体是一个水平的Box ,左右各一个垂直Box
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        /// right.setBackground(Color.MAGENTA);

        GridLayout gridLayout = new GridLayout(5, 1);
        gridLayout.setVgap(40);//设置表格不同块的间距
        left.setLayout(gridLayout);

        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        init_panel.setLayout(new BoxLayout(init_panel, BoxLayout.X_AXIS));
        init_panel.add("l", left);
        init_panel.add("r", right);


        {
            //初始化左边的Box
            JLabel l_Title = new JLabel("输入文件名");
            JLabel empty1 = new JLabel();
            JLabel empty2 = new JLabel();

            l_Title.setHorizontalAlignment(SwingConstants.CENTER);
            l_Title.setFont(new Font(null, Font.BOLD | Font.ITALIC, 20));
            fileinput = new JTextField();

            fileinput.setToolTipText("请输入文件名或者是文件路径");
            fileinput.setFont(new Font(null, Font.BOLD, 20));

            JButton confirm = new JButton();//
            confirm.setText("确定");


            confirm.addActionListener(e -> {

                {

                    String filename = fileinput.getText();


                    if (fileinput.getText().equals("")) {
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
                                    fileContent.append(t + '\n');
                                }
                                bufferedReader.close();

                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "文件不存在，已创建相关文件");
                        }
                    }
                }
            });

            left.add(empty1);
            left.add(l_Title);

            left.add(fileinput);
            left.add(confirm);
            left.add(empty2);

        }
        {
            JLabel rTitle = new JLabel();

            rTitle.setAlignmentX((float) 0.5);

            rTitle.setText("文件操作");
            rTitle.setFont(new Font(null, Font.BOLD, 25));
            fileContent = new JTextArea();
            fileContent.setColumns(40);
            fileContent.setRows(100);
            JScrollPane jScrollPane = new JScrollPane(fileContent);
            JButton change = new JButton();
            change.setText("确定");

            change.addActionListener(e -> {



                if (!hasfile) {
//说明并不存在需要修改的文件

                    JOptionPane.showMessageDialog(null, "请先确定要输入的文件", "操作错误", JOptionPane.WARNING_MESSAGE);

                } else {//说明有需要修改的文件

                    File file = new File(fileinput.getText());
                    try {
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(fileContent.getText());
                        bufferedWriter.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "文件修改成功", "操作成功", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            change.setHorizontalAlignment(SwingConstants.CENTER);
            right.add(rTitle);
            right.add(jScrollPane);
            right.add(change);

        }

        cardLayout.setLayout(new CardLayout());
        cardLayout.add("first", init_panel);
        CardLayout t = (CardLayout) cardLayout.getLayout();

        t.show(cardLayout, "first");

        cardLayout.setVisible(true);
    }

    private void change_CardLayout() {
        CardLayout t = (CardLayout) cardLayout.getLayout();
        JPanel newjPanel = new JPanel();

        newjPanel.setLayout(null);
        JLabel jLabel = new JLabel("fudfsakd ");

        jLabel.setBounds(40, 40, 40, 40);

        newjPanel.add(jLabel);

        cardLayout.add("new", newjPanel);
        t.show(cardLayout, "new");


    }

    public static void main(String[] args) {
        HomeWork t = new HomeWork();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        int Width = dimension.width / 2;
        int Height = dimension.height / 2;
        t.setSize(Width, Height);
        t.setVisible(true);
    }
}
