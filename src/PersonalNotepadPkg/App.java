package PersonalNotepadPkg;

import javax.swing.UIManager;

import PersonalNotepadPkg.UI.NotepadFrame;

public class App {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        var notepad = new NotepadFrame();
        
        notepad.setVisible(true);
    }
}
