import javax.swing.JButton;

public class Button extends JButton {
    private String name;

    public Button(String name) {
        this.name = name;
        setName(name);
    }
    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    
}



