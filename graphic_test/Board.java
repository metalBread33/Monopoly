import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JPanel;

public class Board extends JPanel
{
    public void paint (Graphics g)
    {

        Graphics2D bd= (Graphics2D) g;
        bd.setPaint(Color.black);
        bd.drawRect(0, 0, 10, 20);





    }


}
