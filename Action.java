import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.event.*;

public class Action {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int [][] array = new int[3][3];
    int [][] array_ans = new int[3][3];
    int [] array_n = new int [9];
    int count_ans = 0;
    int count_num = 0;
    boolean resetting = false;

    /*i,j
    0,0  0,1  0,2
    1,0  1,1  1,2
    2,0  2,1  2,2
    */    

    public void setArray(){
        int count = 1;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                array[i][j] = count;
                count++;
            }
        }
    } 
    /*
    public int [] setNumber(Button b, int [] array_num){
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
                            array_num[0] = count_num;
                            break;
                        case "2":
                            array_num[1] = count_num;
                            break;
                        case "3":
                            array_num[2] = count_num;
                            break;
                        case "4":
                            array_num[3] = count_num;
                            break;
                        case "5":
                            array_num[4] = count_num;
                            break;
                        case "6":
                            array_num[5] = count_num;
                            break;
                        case "7":
                            array_num[6] = count_num;
                            break;
                        case "8":
                            array_num[7] = count_num;
                            break;
                        case "9":
                            array_num[8] = count_num;
                            break;
                    }                    
                }
                //test
                for(int i=0;i<9;i++){
                    System.out.printf("%d",array_num[i]);
                }
                System.out.println();//
                  
                if(count_num == 9){
                    count_num =0;
                }
            }
            
        });
        return array_num;        
    }
    */
        

    public void setAnswer(Button a, Button [] buttons_ans){
    }

    public void setFunction1(Button f, Button [] buttons_f, Button [] buttons){
        f.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
                switch(f.getName()){
                    case "reset":
                        resetting = true;
                        break;
                    case "clear":
                        for(int i=0;i<9;i++){
                            buttons[i].setText("");
                        }
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                array_ans[i][j] = 0;
                            }
                        }
                        count_ans = 0;

                        for(int i=0;i<array_ans.length;i++){
                            for(int j=0;j<array_ans[i].length;j++){
                                System.out.print(array_ans[i][j]);
                            }
                            System.out.println();
                        }
                        System.out.println();//
                        break;
                    case "enter":
                        resetting = false;
                        
                        for(int i=0;i<9;i++){ 
                            //buttons[i].setText(Integer.toString(i+1));                                 
                            //setAction(buttons[i],buttons);
                            System.out.println("oaoa");           
                        }
                        break;
                }
            }
        });
    }

    public void setFunction2(Button f, Button [] buttons_f, Button [] buttons){
        f.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){                
                switch(f.getName()){
                    case "reset":
                        resetting = true;
                        break;
                    case "clear":
                        for(int i=0;i<9;i++){
                            buttons[i].setText("");
                        }
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                array_ans[i][j] = 0;
                            }
                        }
                        count_ans = 0;

                        for(int i=0;i<array_ans.length;i++){
                            for(int j=0;j<array_ans[i].length;j++){
                                System.out.print(array_ans[i][j]);
                            }
                            System.out.println();
                        }
                        System.out.println();//
                        break;
                    case "enter":
                        resetting = false;
                        break;
                }
            }
        });
    }
    
    public boolean nearbutton(Button b, int [][] array){
        boolean block = true;
        switch(b.getName()){
            case "b1":
                if((array[0][1]==9)||(array[1][0]==9)){
                    block = false;
                }                
                break;
            case "b2":
                if((array[0][0]==9)||(array[0][2]==9)||(array[1][1]==9)){
                  block = false;
                }
                break;
            case "b3":
                if((array[0][1]==9)||(array[1][2]==9)){
                    block = false;
                }
                break;
            case "b4":
                if((array[0][0]==9)||(array[1][1]==9)||(array[2][0]==9)){
                    block = false;
                }
                break;
            case "b5":
                if((array[0][1]==9)||(array[1][0]==9)||(array[1][2]==9)||(array[2][1]==9)){
                    block = false;
                }
                break;
            case "b6":
                if((array[0][2]==9)||(array[1][1]==9)||(array[2][2]==9)){
                    block = false;
                }
                break;
            case "b7":
                if((array[1][0]==9)||(array[2][1]==9)){
                    block = false;
                }
                break;
            case "b8":
                if((array[1][1]==9)||(array[2][0]==9)||(array[2][2]==9)){
                    block = false;
                }
                break;
            case "b9":
                if((array[1][2]==9)||(array[2][1]==9)){
                    block = false;
                }
                break;
        }
        return block;
    }
    
    public void setAction(Button b, Button [] buttons){  
        
        if(b.getText().equals("9")){
            b.setEnabled(false);
        }
            
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                /*closing 9's button*/
                if(b.getText().equals("9")){
                    b.setEnabled(false);
                }
                else{
                    for(int i=0;i<9;i++){ 
                        buttons[i].setEnabled(true);                                    
                    }
                }
                
                if(e.getSource() == b){
                    /*detect if the button near? */
                    if(nearbutton(b, array)){   //unnear                     
                        System.out.println("xx");
                        for(int i=0;i<buttons.length;i++){
                            if(buttons[i].getText().equals("9")){
                                buttons[i].setEnabled(false);
                                break;
                            }
                        }                       
                    }
                    else{
                        System.out.println("oo");
                        int i1=99;int j1=99;//get
                        int i2=99;int j2=99;//set              
                        
                        /*get position of num from array*/ 
                        for(int i=0;i<array.length;i++){
                            for(int j=0;j<array[i].length;j++){
                                if(array[i][j]==Integer.parseInt(b.getText())){
                                    i1 = i;
                                    j1 = j;                                
                                }                           
                            }
                        }  
                        for(int i=0;i<array.length;i++){
                            for(int j=0;j<array[i].length;j++){
                                if(array[i][j]==9){
                                    i2 = i;
                                    j2 = j;
                                }                           
                            }
                        }

                        array[i2][j2] = Integer. parseInt(b.getText());
                        array[i1][j1] = 9;   
                        
                        int count = 0;
                        for(int i=0;i<array.length;i++){
                            for(int j=0;j<array[i].length;j++){
                                buttons[count].setText(Integer.toString(array[i][j]));                    
                                count++;
                            }
                        }                        
                        b.setEnabled(false);
                    }                    

                    /*test*/
                    for(int i=0;i<array.length;i++){
                        for(int j=0;j<array[i].length;j++){
                            System.out.print(array[i][j]);
                        }
                        System.out.println();
                    }
                    System.out.println();//

                }
            }
        });
    }

    

    

}
