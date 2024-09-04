package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {
JTextField textFieldName;
JPasswordField passwordField;
JButton login, back;
Login(){
JLabel labelName = new JLabel(&quot;Username&quot;);
labelName.setBounds(40,20,100,20);
add(labelName);
textFieldName = new JTextField();
textFieldName.setBounds(150,20,150,20);
add(textFieldName);
JLabel labelpass = new JLabel(&quot;Password&quot;);
labelpass.setBounds(40,70,100,20);
add(labelpass);
passwordField = new JPasswordField();
passwordField.setBounds(150,70,150,20);
add(passwordField);
login = new JButton(&quot;Login&quot;);
login.setBounds(40,140,120,30);
login.setBackground(Color.black);
login.setForeground(Color.white);
login.addActionListener(this);
add(login);
back = new JButton(&quot;Back&quot;);
back.setBounds(180,140,120,30);
back.setBackground(Color.black);
back.setForeground(Color.white);
back.addActionListener(this);
add(back);
ImageIcon i1 = new
ImageIcon(ClassLoader.getSystemResource(&quot;icons/second.png&quot;));
Image i2 =
i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel img = new JLabel(i3);
img.setBounds(350,20,200,200);
add(img);

ImageIcon i11 = new
ImageIcon(ClassLoader.getSystemResource(&quot;icons/loginback.png&quot;));
Image i22 =
i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
ImageIcon i33 = new ImageIcon(i22);
JLabel image = new JLabel(i33);
image.setBounds(0,0,600,300);
add(image);

setSize(600,300);
setLocation(500,250);
setLayout(null);
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource() == login){
String username = textFieldName.getText();
String password = passwordField.getText();
String query = &quot;select * from login where
username=&#39;&quot;+username+&quot;&#39; and password = &#39;&quot;+password+&quot;&#39;&quot;;
try {
Conn c = new Conn();
ResultSet resultSet = c.statement.executeQuery(query);
if (resultSet.next()){
setVisible(false);
new main_class();
}else {
JOptionPane.showMessageDialog(null,&quot;Invalid username or
password&quot;);
}

}catch (Exception E){
E.printStackTrace();
}
}else {
setVisible(false);
}
}
public static void main(String[] args) {
new Login();
}
}
