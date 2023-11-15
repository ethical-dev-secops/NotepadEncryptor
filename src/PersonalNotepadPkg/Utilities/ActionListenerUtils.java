package PersonalNotepadPkg.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import PersonalNotepadPkg.About;
import PersonalNotepadPkg.Domain.PersonalNotepadUI;

public class ActionListenerUtils
{
    public static ActionListener GetEncryptionActionListeners(JTextArea textArea)
    {
        ActionListener encryptionAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent clickevent)
            {
                var stringBuilder = new StringBuilder();
                var clearText = textArea.getText();
                for (var i = 0; i < clearText.length(); i++)
                {
                    var newValue = clearText.charAt(i)+1;
                    stringBuilder.append((char)newValue);
                }

                textArea.setText(stringBuilder.toString());
            }
        };

        return encryptionAction;
    }

    public static ActionListener GetDecryptionActionListeners(JTextArea textArea)
    {
        ActionListener decryptionAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent clickevent)
            {
                var stringBuilder = new StringBuilder();
                var cipherText = textArea.getText();
                for (var i = 0; i < cipherText.length(); i++)
                {
                    var oldValue = cipherText.charAt(i)-1;
                    stringBuilder.append((char)oldValue);
                }

                textArea.setText(stringBuilder.toString());
            }
        };

        return decryptionAction;
    }

    public static void SetupMenuStructure(PersonalNotepadUI notepad)
    {
        notepad.menubar.add(notepad.fileMenu);
        notepad.menubar.add(notepad.editMenu);
        notepad.menubar.add(notepad.encryptionMenu);
        notepad.menubar.add(notepad.helpMenu);

        notepad.fileMenu.add(notepad.newFileMenuItem);
        notepad.fileMenu.add(notepad.openFileMenuItem);
        notepad.fileMenu.add(notepad.saveFileMenuItem);
        notepad.fileMenu.add(notepad.printMenuItem);
        notepad.fileMenu.add(notepad.exitMenuItem);

        notepad.editMenu.add(notepad.cutMenuItem);
        notepad.editMenu.add(notepad.copyMenuItem);
        notepad.editMenu.add(notepad.pasteMenuItem);
        notepad.editMenu.add(notepad.selectAllMenuItem);

        notepad.encryptionMenu.add(notepad.caesarEncryptionMenuItem);
        notepad.encryptionMenu.add(notepad.caesarDecryptionMenuItem);

        notepad.helpMenu.add(notepad.aboutMenuItem);
    }

    public static void SetupKeyActions(PersonalNotepadUI notepad, ActionListener listener)
    {
        notepad.newFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        notepad.openFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        notepad.saveFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        notepad.printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        notepad.exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        notepad.cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        notepad.copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        notepad.pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        notepad.selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        notepad.aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
    }

    public static void SetupEventListeners(PersonalNotepadUI notepad, ActionListener listener)
    {
            notepad.newFileMenuItem.addActionListener(listener);
            notepad.openFileMenuItem.addActionListener(listener);
            notepad.saveFileMenuItem.addActionListener(listener);
            notepad.printMenuItem.addActionListener(listener);
            notepad.exitMenuItem.addActionListener(listener);
            notepad.cutMenuItem.addActionListener(listener);
            notepad.copyMenuItem.addActionListener(listener);
            notepad.pasteMenuItem.addActionListener(listener);
            notepad.selectAllMenuItem.addActionListener(listener);
            notepad.aboutMenuItem.addActionListener(listener);
    
            notepad.caesarDecryptionMenuItem
                    .addActionListener(ActionListenerUtils.GetEncryptionActionListeners(notepad.textArea));
            notepad.caesarEncryptionMenuItem
                    .addActionListener(ActionListenerUtils.GetDecryptionActionListeners(notepad.textArea));
    }

    public static void actionPerformed(ActionEvent e, PersonalNotepadUI notepad)
    {
        var command = e.getActionCommand();

        switch(command.toLowerCase())
        {
            case "new":
                notepad.textArea.setText(null);
                break;
            case "save":
                ActionEvents.save(e, notepad);
                break;
            case "open":
                ActionEvents.open(e, notepad);
                break;
            case "print":
                ActionEvents.print(e, notepad);
                break;
            case "exit":
                System.exit(0);
                break;
            case "cut":
                notepad.textArea.cut();
                break;
            case "copy":
                notepad.textArea.copy();
                break;
            case "paste":
                notepad.textArea.paste();
                break;
            case "select all" :
                notepad.textArea.selectAll();
                break;
            case "about" :
                new About().setVisible(true);
                break;
        }
    }
}