package tema1;

import javax.swing.*;

public class main 
{

    public static void main(String[] args) 
    {

        try 
        {
        	regex application = new regex();
        	application.getFrame().setVisible(true);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

}