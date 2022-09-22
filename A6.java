import java.awt.*;
import java.awt.event.*;
import java.sql.Array;

import javax.swing.*;
import javax.swing.event.*;

public class A6 extends JFrame{
    JFrame f;
    Action action = new Action();
    Reset reset = new Reset();
    int[] array_que = new int[9];
    int[] array_ans = new int[9];
    public static void main(String argv[]){
        new A6();
    }

    public A6() {        
        //JButton button [] = new JButton[9];
        //action.SetArray();
        /*
        f=new JFrame("JButton9");
        f.setSize(300,200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        Container cp=f.getContentPane();
        cp.setLayout(new GridLayout(3,3));
        */
        f = new JFrame("JButton9");
        f.setSize(800, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);//put to windoe's middle
        f.setVisible(true);
        Container cp=f.getContentPane();
        cp.setLayout(null);  //取消預設之 BorderLayout   

        
        //////////////////////////////////////////

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");
        Button b4 = new Button("b4");
        Button b5 = new Button("b5");
        Button b6 = new Button("b6");
        Button b7 = new Button("b7");
        Button b8 = new Button("b8");
        Button b9 = new Button("b9");
        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9};        
        b1.setBounds(100, 50, 50, 50);
        b2.setBounds(150, 50, 50, 50);
        b3.setBounds(200, 50, 50, 50);
        b4.setBounds(100, 100, 50, 50);
        b5.setBounds(150, 100, 50, 50);
        b6.setBounds(200, 100, 50, 50);
        b7.setBounds(100, 150, 50, 50);
        b8.setBounds(150, 150, 50, 50);
        b9.setBounds(200, 150, 50, 50);
        action.setArray();
        for(int i=0;i<9;i++){ 
            buttons[i].setFont(new Font(null,Font.BOLD, 20));
            buttons[i].setText(Integer.toString(i+1));                               
            action.setAction(buttons[i],buttons);
            cp.add(buttons[i]);            
        }

        /////////////////////////////////////////////////////////////////////
        Button a1 = new Button("a1");
        Button a2 = new Button("a2");
        Button a3 = new Button("a3");
        Button a4 = new Button("a4");
        Button a5 = new Button("a5");
        Button a6 = new Button("a6");
        Button a7 = new Button("a7");
        Button a8 = new Button("a8");
        Button a9 = new Button("a9");
        Button[] buttons_ans = {a1, a2, a3, a4, a5, a6, a7, a8, a9};        
        a1.setBounds(500, 50, 50, 50);
        a2.setBounds(550, 50, 50, 50);
        a3.setBounds(600, 50, 50, 50);
        a4.setBounds(500, 100, 50, 50);
        a5.setBounds(550, 100, 50, 50);
        a6.setBounds(600, 100, 50, 50);
        a7.setBounds(500, 150, 50, 50);
        a8.setBounds(550, 150, 50, 50);
        a9.setBounds(600, 150, 50, 50);
        for(int i=0;i<9;i++){
            buttons_ans[i].setFont(new Font(null,Font.BOLD, 20));
            //buttons_ans[i].setText(Integer.toString(i+1));                
            cp.add(buttons_ans[i]);            
        }
        ////////////////////
        Button resetbButton = new Button("reset");        
        resetbButton.setBounds(325, 250, 100, 50);
        resetbButton.setFont(new Font(null,Font.BOLD, 20));
        resetbButton.setText(resetbButton.getName());
        cp.add(resetbButton);
        resetbButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reset.process(buttons, buttons_ans);
                System.out.printf("%d\n",reset.get_que()[0]); 
                System.out.println("wwwww");               
            }
        });
        


        
        //////////////////////////////////////////////////////////

        f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);        
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int result=JOptionPane.showConfirmDialog(f,"確定要結束程式嗎?","確認訊息",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if (result==JOptionPane.YES_OPTION) {System.exit(0);}
            }  
        });
    }

}