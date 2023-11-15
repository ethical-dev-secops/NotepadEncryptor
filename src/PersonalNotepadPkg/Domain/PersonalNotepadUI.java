package PersonalNotepadPkg.Domain;

import javax.swing.*;

public class PersonalNotepadUI
{
    // Primary Menu Bar
    public JMenuBar menubar = new JMenuBar();
    public JMenu fileMenu = new JMenu("File");
    public JMenu editMenu = new JMenu("Edit");
    public JMenu encryptionMenu = new JMenu("Encryption");
    public JMenu helpMenu = new JMenu("Help");

    // File options
    public JMenuItem newFileMenuItem = new JMenuItem("New");
    public JMenuItem openFileMenuItem = new JMenuItem("Open");
    public JMenuItem saveFileMenuItem = new JMenuItem("Save");
    public JMenuItem printMenuItem = new JMenuItem("Print");
    public JMenuItem exitMenuItem = new JMenuItem("Exit");

    // Edit options
    public JMenuItem cutMenuItem = new JMenuItem("Cut");
    public JMenuItem copyMenuItem = new JMenuItem("Copy");
    public JMenuItem pasteMenuItem = new JMenuItem("Paste");
    public JMenuItem selectAllMenuItem = new JMenuItem("Select All");

    // Encryption options
    public JMenuItem caesarEncryptionMenuItem = new JMenuItem("Caesar's Protection");
    public JMenuItem caesarDecryptionMenuItem = new JMenuItem("Caesar's Reveal");

    // Help options
    public JMenuItem aboutMenuItem = new JMenuItem("About");

    public JTextArea textArea = new JTextArea();
}
