package PersonalNotepadPkg.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import PersonalNotepadPkg.Domain.PersonalNotepadUI;
import PersonalNotepadPkg.Utilities.ActionListenerUtils;


public class NotepadFrame extends JFrame implements ActionListener
{
    public PersonalNotepadUI notepad;


    public NotepadFrame()
    {
        this.notepad = new PersonalNotepadUI();
        Initialize(this.notepad);
    }

    public void Initialize(PersonalNotepadUI notepad)
    {
        setTitle("Secure notepad");
        setBounds(100, 100, 1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
            setIconImage(icon.getImage());
        }
        catch(Exception e){

        }
        
        SetupMenuStructure(notepad);
        SetupTextArea(notepad);
        SetupEventListeners(notepad, this);

    }

    private void SetupTextArea(PersonalNotepadUI notepad)
    {
        JScrollPane scrollpane = new JScrollPane(notepad.textArea);
        add(scrollpane);
        notepad.textArea.setFont((new Font(Font.SANS_SERIF, Font.PLAIN, 20)));
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        notepad.textArea.setLineWrap(true);
        notepad.textArea.setWrapStyleWord(true);

    }

    private void SetupEventListeners(PersonalNotepadUI notepad, ActionListener listener)
    {
        ActionListenerUtils.SetupEventListeners(notepad, listener);
        ActionListenerUtils.SetupKeyActions(notepad, listener);
    }

    private void SetupMenuStructure(PersonalNotepadUI notepad)
    {
        setJMenuBar(notepad.menubar);
        ActionListenerUtils.SetupMenuStructure(notepad);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ActionListenerUtils.actionPerformed(e, notepad);
    }
}
