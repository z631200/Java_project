import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.event.*;

public class Reset {
    public int[] array_que = new int[9];
    public int[] array_ans = new int[9];
    Button [] buttons_que = new Button[9];
    Button [] buttons_ans = new Button[9];
    int count_num = 0;
    int setNumber_done = 0;
    
    Action action = new Action();
    

    /*
    public int[] Reset(){
        return ;
    }*/
    public void process(Button [] buttons, Button [] buttons_ans){
        building();
        this.buttons_que = buttons;
        this.buttons_ans = buttons_ans;
    }

    public void setbuttons_in_A6(){
        for(int i=0;i<9;i++){
            buttons_que[i].setText(Integer.toString(array_que[i]));
            buttons_ans[i].setText(Integer.toString(array_ans[i]));
        }
    }

    public void building(){
        JFrame resetting = new JFrame("resetting");
        resetting.setSize(800, 400);
        resetting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resetting.setVisible(true);
        resetting.setLayout(null);
        resetting.setLocationRelativeTo(null);

        Button Q1 = new Button("1");
        Button Q2 = new Button("2");
        Button Q3 = new Button("3");
        Button Q4 = new Button("4");
        Button Q5 = new Button("5");
        Button Q6 = new Button("6");
        Button Q7 = new Button("7");
        Button Q8 = new Button("8");
        Button Q9 = new Button("9");
        Button[] buttons_que = {Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9};        
        Q1.setBounds(100, 50, 50, 50);
        Q2.setBounds(150, 50, 50, 50);
        Q3.setBounds(200, 50, 50, 50);
        Q4.setBounds(100, 100, 50, 50);
        Q5.setBounds(150, 100, 50, 50); 
        Q6.setBounds(200, 100, 50, 50);
        Q7.setBounds(100, 150, 50, 50);
        Q8.setBounds(150, 150, 50, 50);
        Q9.setBounds(200, 150, 50, 50);
        Button A1 = new Button("1");
        Button A2 = new Button("2");
        Button A3 = new Button("3");
        Button A4 = new Button("4");
        Button A5 = new Button("5");
        Button A6 = new Button("6");
        Button A7 = new Button("7");
        Button A8 = new Button("8");
        Button A9 = new Button("9");
        Button[] buttons_ans = {A1, A2, A3, A4, A5, A6, A7, A8, A9};        
        A1.setBounds(500, 50, 50, 50);
        A2.setBounds(550, 50, 50, 50);
        A3.setBounds(600, 50, 50, 50);
        A4.setBounds(500, 100, 50, 50);
        A5.setBounds(550, 100, 50, 50);
        A6.setBounds(600, 100, 50, 50);
        A7.setBounds(500, 150, 50, 50);
        A8.setBounds(550, 150, 50, 50);
        A9.setBounds(600, 150, 50, 50);
        for(int i=0;i<9;i++){
            buttons_que[i].setFont(new Font(null,Font.BOLD, 20));
            buttons_ans[i].setFont(new Font(null,Font.BOLD, 20));                
            resetting.add(buttons_que[i]);
            resetting.add(buttons_ans[i]);
            buttons_que[i].setEnabled(false);
            buttons_ans[i].setEnabled(false);
            setNumber_que(buttons_que[i], array_que);
            setNumber_ans(buttons_ans[i], array_ans);

        }
        
        ////////////////////////////////////////////////////////////////////
        Button startButton_que = new Button("start");        
        startButton_que.setBounds(25, 250, 100, 50);
        startButton_que.setFont(new Font(null,Font.BOLD, 20));
        startButton_que.setText(startButton_que.getName());
        resetting.add(startButton_que);
        
        Button startButton_ans = new Button("start");        
        startButton_ans.setBounds(425, 250, 100, 50);
        startButton_ans.setFont(new Font(null,Font.BOLD, 20));
        startButton_ans.setText(startButton_ans.getName());
        resetting.add(startButton_ans);
        
        Button clearButton_que = new Button("clear");        
        clearButton_que.setBounds(125, 250, 100, 50);
        clearButton_que.setFont(new Font(null,Font.BOLD, 20));
        clearButton_que.setText(clearButton_que.getName());
        resetting.add(clearButton_que);
        clearButton_que.setEnabled(false);
        
        Button clearButton_ans = new Button("clear");        
        clearButton_ans.setBounds(525, 250, 100, 50);
        clearButton_ans.setFont(new Font(null,Font.BOLD, 20));
        clearButton_ans.setText(clearButton_ans.getName());
        resetting.add(clearButton_ans);
        clearButton_ans.setEnabled(false);
        
        Button doneButton_que = new Button("enter");        
        doneButton_que.setBounds(225, 250, 100, 50);
        doneButton_que.setFont(new Font(null,Font.BOLD, 20));
        doneButton_que.setText(doneButton_que.getName());
        resetting.add(doneButton_que);
        doneButton_que.setEnabled(false);
        
        Button doneButton_ans = new Button("enter");        
        doneButton_ans.setBounds(625, 250, 100, 50);
        doneButton_ans.setFont(new Font(null,Font.BOLD, 20));
        doneButton_ans.setText(doneButton_ans.getName());
        resetting.add(doneButton_ans);
        doneButton_ans.setEnabled(false);
        
        Button finishButton = new Button("finish");        
        finishButton.setBounds(325, 100, 100, 50);
        finishButton.setFont(new Font(null,Font.BOLD, 20));
        finishButton.setText(finishButton.getName());
        resetting.add(finishButton);
        finishButton.setEnabled(false);
        
        ////
        Button testButton = new Button("test");        
        testButton.setBounds(325, 150, 100, 50);
        testButton.setFont(new Font(null,Font.BOLD, 20));
        testButton.setText(testButton.getName());
        resetting.add(testButton);
        testButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                test();
            }
        });

        //////buttons' fuction
        startButton_que.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int i=0;i<9;i++){
                    buttons_que[i].setEnabled(true);
                    clearButton_que.setEnabled(true);
                    doneButton_que.setEnabled(true);
                    startButton_ans.setEnabled(false);
                }
            }
        });
        startButton_ans.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int i=0;i<9;i++){
                    buttons_ans[i].setEnabled(true);
                    clearButton_ans.setEnabled(true);
                    doneButton_ans.setEnabled(true);
                    startButton_que.setEnabled(false);
                }
            }
        });
        clearButton_que.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                count_num = 0;
                array_que = new int [9];                
                for(int i=0;i<9;i++){
                    buttons_que[i].setText("");
                }
                /*test*/
                for(int i=0;i<9;i++){
                    System.out.printf("%d",array_que[i]);
                }
                System.out.println();
            }
        });
        clearButton_ans.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                count_num = 0;
                array_ans = new int [9];
                for(int i=0;i<9;i++){
                    buttons_ans[i].setText("");
                }
                /*test*/
                for(int i=0;i<9;i++){
                    System.out.printf("--%d",array_que[i]);
                }
                System.out.println();
            }
        });
        doneButton_que.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                int setNumber_done_qus = 0;
                for(int i=0;i<9;i++){
                    if(buttons_que[i].getText().equals("")){
                        setNumber_done_qus++;
                    }
                }

                if(setNumber_done_qus>0){
                    System.out.printf("error 4, %d undone\n",setNumber_done_qus);                    
                }
                else if(setNumber_done_qus==0){
                    setNumber_done++;
                    clearButton_que.setEnabled(false);
                    doneButton_que.setEnabled(false);
                    startButton_ans.setEnabled(true);
                    if(setNumber_done==2){
                        finishButton.setEnabled(true);
                    }
                }
            }
        });
        doneButton_ans.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int setNumber_done_ans = 0;                
                for(int i=0;i<9;i++){
                    if(buttons_ans[i].getText().equals("")){
                        setNumber_done_ans++;
                    }
                }

                if(setNumber_done_ans>0){
                    System.out.printf("error 4, %d undone\n",setNumber_done_ans);                    
                }
                else if(setNumber_done_ans==0){
                    setNumber_done++;
                    clearButton_ans.setEnabled(false);
                    doneButton_ans.setEnabled(false);
                    startButton_que.setEnabled(true);
                    if(setNumber_done==2){
                        finishButton.setEnabled(true);
                    }
                }
            }
        });
        finishButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setbuttons_in_A6();
                setNumber_done = 0;
                resetting.dispose();
            }
        });
        /*
        resetting.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);        
        resetting.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int result=JOptionPane.showConfirmDialog(resetting,"sure to stop reset?","stop",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if (result==JOptionPane.YES_OPTION) {resetting.dispose();}
            }  
        });*/
        
    }

    public void test(){
        for(int i=0;i<9;i++){
            System.out.printf("%d",array_que[i]);
        }
        System.out.println();
    }
    
    public void setNumber_que(Button b, int [] array_num_q){
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ////
                if(!b.getText().equals("")){
                    System.out.println("error 2");
                }
                else{
                    count_num++;                
                    b.setText(Integer.toString(count_num));
                    switch(b.getName()){
                        case "1":
                            array_num_q[0] = count_num;
                            break;
                        case "2":
                            array_num_q[1] = count_num;
                            break;
                        case "3":
                            array_num_q[2] = count_num;
                            break;
                        case "4":
                            array_num_q[3] = count_num;
                            break;
                        case "5":
                            array_num_q[4] = count_num;
                            break;
                        case "6":
                            array_num_q[5] = count_num;
                            break;
                        case "7":
                            array_num_q[6] = count_num;
                            break;
                        case "8":
                            array_num_q[7] = count_num;
                            break;
                        case "9":
                            array_num_q[8] = count_num;
                            break;
                    }                    
                }
                /*test*/
                for(int i=0;i<9;i++){
                    System.out.printf("%d",array_num_q[i]);
                }
                System.out.println();//
                  
                if(count_num == 9){
                    count_num =0;
                }
                array_que = array_num_q;     
            }            
        });       
    }

    public void setNumber_ans(Button b, int [] array_num_a){
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ////
                if(!b.getText().equals("")){
                    System.out.println("error 2");
                }
                else{
                    count_num++;                
                    b.setText(Integer.toString(count_num));
                    switch(b.getName()){
                        case "1":
                            array_num_a[0] = count_num;
                            break;
                        case "2":
                            array_num_a[1] = count_num;
                            break;
                        case "3":
                            array_num_a[2] = count_num;
                            break;
                        case "4":
                            array_num_a[3] = count_num;
                            break;
                        case "5":
                            array_num_a[4] = count_num;
                            break;
                        case "6":
                            array_num_a[5] = count_num;
                            break;
                        case "7":
                            array_num_a[6] = count_num;
                            break;
                        case "8":
                            array_num_a[7] = count_num;
                            break;
                        case "9":
                            array_num_a[8] = count_num;
                            break;
                    }                    
                }
                /*test*/
                for(int i=0;i<9;i++){
                    System.out.printf("%d",array_num_a[i]);
                }
                System.out.println();//
                  
                if(count_num == 9){
                    count_num =0;
                }
                array_ans = array_num_a;     
            }            
        });
    }

    
    public int[] get_que(){
        return array_que;
    }
    public int[] get_ans(){
        return array_ans;
    }
}