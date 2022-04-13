package tema1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex
{

    private JFrame frame;
    private JTextArea stringForSearch;
    private JTextField regularExpr;
    private JTextArea verify;

    public JFrame getFrame() 
    {
        return frame;
    }

    public void setFrame(JFrame frame) 
    {
        this.frame = frame;
    }

    public regex()
    {
        initialize();
    }

    private void initialize() 
    {

        setFrame(new JFrame("Cautare expresie regulata:"));
        getFrame().setBounds(600, 250, 500, 400);
        getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getFrame().getContentPane().setLayout(null);

        JLabel labelRegularExpression = new JLabel("Introdu regex-ul:");
        labelRegularExpression.setBounds(50, 50, 300, 35);
        getFrame().add(labelRegularExpression);

        regularExpr = new JTextField();
        regularExpr.setBounds(50, 80, 300, 30);
        getFrame().getContentPane().add(regularExpr);
        regularExpr.setColumns(10);

        JLabel labelTestString = new JLabel("Textul in care vrei sa cauti:");
        labelTestString.setBounds(50, 120, 300, 35);
        getFrame().add(labelTestString);

        stringForSearch = new JTextArea();
        stringForSearch.setBounds(50, 150, 400, 65);
        getFrame().getContentPane().add(stringForSearch);
        stringForSearch.setColumns(10);

        JLabel labelRaspuns = new JLabel("Raspuns:");
        labelRaspuns.setBounds(50, 210, 100, 35);
        getFrame().add(labelRaspuns);

        verify = new JTextArea();
        verify.setEditable(false);
        JScrollPane scroll = new JScrollPane(verify);
        verify.setBounds(50, 25, 100, 10);
        scroll.setBounds(50, 240, 300, 30);
        getFrame().getContentPane().add(scroll);

        JButton btnCheck = new JButton("Verifica");
        btnCheck.addActionListener(this::actionButtonSubmit);

        btnCheck.setBounds(50, 300, 100, 30);
        getFrame().getContentPane().add(btnCheck);

        JButton btnClear = new JButton("Sterge");
        btnClear.addActionListener(this::actionButtonClear);

        btnClear.setBounds(160, 300, 100, 30);
        getFrame().getContentPane().add(btnClear);
    }

    private void actionButtonSubmit(ActionEvent arg0) 
    {

        String regex = regularExpr.getText();
        String string = stringForSearch.getText();
        
        verify.setText(null);
        
        try {
            if (!regex.isEmpty() && !string.isEmpty()) 
            {
                boolean isRegexInvalid = false;
                Pattern pattern = null;
                
                try 
                {
                	pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
                } 
                catch (Exception x)
                {
                	isRegexInvalid = true;
                }
                
                if (isRegexInvalid)
                {
                	verify.setForeground(Color.ORANGE);
                	verify.append("\n\n Ai introdus un pattern invalid ! \n\n");
                }
                else
                {
                	final Matcher match = pattern.matcher(string);
                
                	if (match.find()) 
                	{
                		verify.setForeground(Color.GREEN);
                		verify.append("\n\n Patternul se gaseste in text! \n\n");
                	} 
                	else 
                	{
                		verify.setForeground(Color.RED);
                		verify.append("\n\n Patternul nu se gaseste in text! \n\n");
                	}
                }

            }
            
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage());
        }
    }

    private void actionButtonClear(ActionEvent arg0) 
    {
        regularExpr.setText(null);
        stringForSearch.setText(null);
        verify.setText(null);
    }
    
}