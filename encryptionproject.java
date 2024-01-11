import java.awt.Font;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class encryptionproject {
    public static void operate(int key) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        try {
            // READING FILE
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            }
            // WRITING FILE
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fileInputStream.close();
            JOptionPane.showMessageDialog(null, "done");
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        // frame creating:
        System.out.println("this is testing");
        JFrame f = new JFrame();
        f.setTitle("IMAGE OPERATIION");
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // creating font;
        Font font = new Font("Roboto", Font.CENTER_BASELINE, 16);
        // creating button
        JButton button = new JButton();
        button.setText("click");
        button.setFont(font);
        // creating text feild :
        TextField textfeild = new TextField();
        textfeild.setFont(font);
        button.addActionListener(e -> {
            System.out.println("this is working");
            String text = textfeild.getText();
            int num = Integer.parseInt(text);
            operate(num);
        });
        // setting layout to frame
        f.setLayout(new FlowLayout());
        // adding button
        f.add(button);
        f.add(textfeild);
        f.setVisible(true);
    }
}
