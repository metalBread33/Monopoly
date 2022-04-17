//Quan Pham - QMP20A

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.geom.GeneralPath;
import java.util.Random;
import java.awt.*;
import java.awt.Graphics2D;

public class DrawTriangles extends JPanel
{
    private JFrame frame;
    public DrawTriangles(){
        super();
        setOpaque(true);
        setBackground(new Color(0,0,0,0));
    }

    //Get the reference of the frame that will contain this JPanel
    public void SetOriginFrame(JFrame frame){
        this.frame = frame;
    }
    public void paintComponent(Graphics g){
        Random rand = new Random();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        Slot[] slots = new Slot[5];
        int height = frame.getHeight();
        int width = frame.getWidth();
        g2.setColor(new Color(255,0,0));
        g2.setStroke(new BasicStroke(4.0f));
        g2.setPaint(new Color(255,0,0));
        int slot_count = 0;

        //Set up the boundaries of the slots for the triangles
        for(int i = 0; i < 2; i++){
            int up_border = (height / 2) * i;
            int low_border = (height / 2) * (i + 1);
            for(int j = 0; j < 3; j ++){
                if(slot_count == 5)
                    break;
                int left_border = (width / 3) * j;
                int right_border = (width / 3) * (j + 1);
                slots[slot_count] = new Slot(low_border, up_border, left_border, right_border);
                slot_count ++;
            }
        }

        //Draw all the triangles to the JPanel
        for(int i = 0; i < 5; i ++){
            GeneralPath triangle = TrianglePath(slots[i]);
            g2.setPaint(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
            g2.fill(triangle);
            g2.draw(triangle);
        }
    }

    //Construct a GeneralPath for a triangle based on the slot for that triangle
    public GeneralPath TrianglePath(Slot s){
        GeneralPath path = new GeneralPath();
        path.moveTo(s.GetLeft() + 50, s.GetLow() - 100);
        path.lineTo(s.GetRight() - 10, s.GetUp() + 10);
        path.lineTo(s.GetRight() - 20, s.GetLow() - 80);
        path.closePath();
        return path;
    }

    //I want to split the JPanel into 5 slots for 5 triangles
    //A Slot object will store the coordinates of the borders of each slot
    class Slot{
        private int low_border;
        private int up_border;
        private int left_border;
        private int right_border;

        public int GetLow(){
            return low_border;
        }
        public int GetUp(){
            return up_border;
        }
        public int GetLeft(){
            return left_border;
        }
        public int GetRight(){
            return right_border;
        }
        Slot(int low, int up, int left, int right){
            low_border = low;
            up_border = up;
            left_border = left;
            right_border = right;
        }
    }
}

// class Triangles
// {
//     public static void main(String args[]){
//         JFrame frame = new JFrame("Triangles");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         DrawTriangles triangles = new DrawTriangles();
//         triangles.SetOriginFrame(frame);
//         frame.add(triangles);
//         frame.setSize(500, 500);
//         frame.setVisible(true);
//     }
// }