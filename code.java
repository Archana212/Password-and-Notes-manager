import java.awt.*; 
         import javax.swing.*; 
         import java.awt.event.ActionEvent; 
         import java.awt.event.ActionListener; 
         import java.util.ArrayList; 
         import java.security.SecureRandom; 
         import java.io.IOException; 
         import java.io.UnsupportedEncodingException; 
         import java.security.InvalidAlgorithmParameterException; 
         import java.security.InvalidKeyException; 
         import java.security.NoSuchAlgorithmException; 
         import java.security.spec.AlgorithmParameterSpec; 
         import java.security.spec.InvalidKeySpecException; 
         import java.security.spec.KeySpec; 
         import java.util.Base64; 
         import javax.crypto.*; 
         import javax.crypto.spec.PBEKeySpec; 
         import javax.crypto.spec.PBEParameterSpec;
// This class is used to create a loading screen 
class SplashScreen { 
    JFrame frame; 
    JLabel image=new JLabel(new ImageIcon("key-lock.png")); 
    JLabel text=new JLabel("PASSWORD & NOTES MANAGER"); 
    JProgressBar progressBar=new JProgressBar(); 
    JLabel message=new JLabel(); 
    SplashScreen() 
    { 
        createGUI(); 
        addImage(); 
        addText(); 
        addProgressBar(); 
        runningPBar(); 
    } 
 
    public void createGUI(){ 
        frame=new JFrame(); // to create a frame 
        frame.getContentPane().setLayout(null); // to set the layout of the frame 
        frame.setUndecorated(true); 
        frame.setSize(400,400); // to set the size of the frame 
        frame.setLocationRelativeTo(null); 
        frame.getContentPane().setBackground(new Color(0XFF8787)); // to set the background color of the 
frame 
        frame.setVisible(true); 
    } 
 
    public void addImage(){ 
        image.setSize(400,200); // to set the size of the image 
        frame.add(image); 
    } 
     
    public void addText() 
    { 
        text.setFont(new Font("MV Boli",Font.BOLD,20)); // to set the font of the text 
        text.setBounds(30,200,400,30); 
        text.setForeground(Color.black); 
              frame.add(text); 
    } 
     
    public void addProgressBar(){ 
        progressBar.setBounds(100,280,200,30); // to set the size of the progress bar 
        progressBar.setBorderPainted(true); 
        progressBar.setStringPainted(true); 
        progressBar.setBackground(Color.black); 
        progressBar.setForeground(new Color(0X38E54D));
         progressBar.setValue(0);  
data.remove_Acc(acc_name.toLowerCase()); // removing the account name and password from the hashtable 
                        JOptionPane.showMessageDialog(conn1, "Delete successfully!"); // showing the message 
                    } 
                    else JOptionPane.showMessageDialog(conn1, "Account not found!", "INFO", 
JOptionPane.INFORMATION_MESSAGE); 
                          } catch (Exception ex) { 
                    JOptionPane.showMessageDialog(conn1, "Write something", "EXIT", 
JOptionPane.ERROR_MESSAGE);                                                                                                                                
                } 
            } 
 
        } 
        ); 
 
        addNoteBtn = new JButton("ADD NOTE"); 
        GUIButtonsSetting(addNoteBtn); 
        addNoteBtn.setBounds(90, 440, 220, 40); 
        conn1.add(addNoteBtn); 
        addNoteBtn.addActionListener(e -> { 
            if (addNoteBtn == e.getSource()) { 
                try { 
                    NoteGUI(); 
                    // action on the add note btn 
                    addNote.addActionListener(e4 -> { 
                        if (addNote == e4.getSource()) { 
                            String note = tNote.getText(); // getting the note 
                            if (note.isEmpty()) { 
                                JOptionPane.showMessageDialog(conn3, "unable to store your note!", "ERROR", 
JOptionPane.ERROR_MESSAGE); 
                            } else { 
                                //calling put method of the hashtablePassword class 
                                notes.add(note); // adding the note to the arraylist 
                                JOptionPane.showMessageDialog(conn3, "Note added Successfully !"); 
                                conn3.setVisible(false); 
                                tNote.setText(null); 
                            } 
                        } 
                    }); 
                } catch (Exception ex) { 
                    JOptionPane.showMessageDialog(conn3, "Write something", "EXIT", 
JOptionPane.ERROR_MESSAGE); 
                } 
        } 
        } 
        ); 
         
        //get all notes 
        JButton getNoteBtn = new JButton("GET NOTE"); 
        GUIButtonsSetting(getNoteBtn); 
        getNoteBtn.setBounds(90, 510, 220, 40); 
        conn1.add(getNoteBtn); 
        getNoteBtn.addActionListener(e -> {    
         if (getNoteBtn == e.getSource()) { 
                try { 
                    String allNotes = notes.get(notes.size() - 1); // getting the last note added 
                    if (allNotes.isEmpty()) { // checking if the note is empty or not 
                        JOptionPane.showMessageDialog(conn1, "No note found!", "INFO", 
JOptionPane.INFORMATION_MESSAGE); // showing the message 
                    } else { 
                        searchPassArea = new JTextArea(4, 5); // text area for the note 
                        textArea(allNotes, searchPassArea); // setting the text area                                                                   
                        JOptionPane.showMessageDialog(conn1, new JScrollPane(searchPassArea), "Get your notes", 
JOptionPane.INFORMATION_MESSAGE); // showing the message 
                    } 
                } catch (Exception ex) { 
                    JOptionPane.showMessageDialog(conn1, "Add a note before trying to retrive", "EXIT", 
JOptionPane.ERROR_MESSAGE); 
                } 
            } 
        } 
        ); 
 
    } 
 
    // method for setting the buttons and GUI for adding notes 
    private void NoteGUI() { 
 
        conn3 = new JFrame("Add Note"); 
        conn3.setSize(500, 500); 
        conn3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        conn3.setLocationRelativeTo(null); 
        conn3.setLayout(null); 
        conn3.setVisible(true); 
        conn3.setResizable(false); 
 
        //add note label 
         addNoteLabel = new JLabel("Add Note"); 
        addNoteLabel.setBounds(200, 20, 100, 30); 
        conn3.add(addNoteLabel); 
 
        //add note text area 
         tNote = new JTextArea(10, 10); 
        tNote.setBounds(100, 60, 300, 300); 
        conn3.add(tNote); 
 
        //add note button 
         addNote = new JButton("ADD NOTE"); 
        GUIButtonsSetting(addNote); 
        addNote.setBounds(140, 380, 220, 30); 
        conn3.add(addNote); 
    } 
 
    // main method to run the application    
    public static void main(String[] args) {      
         
 //loading screen class 
        new SplashScreen(); 
        try { 
            new PasswordManager(); 
        }catch (Exception ex) { ex.printStackTrace(); } 
 } 
} 
                       
