package PersonalNotepadPkg.Utilities;

import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import PersonalNotepadPkg.Domain.PersonalNotepadUI;

public class ActionEvents
{

    public static void print(ActionEvent e, PersonalNotepadUI notepad)
    {
        try
        {
            notepad.textArea.print();
        } catch (PrinterException ex)
        {
            Logger.getLogger(PersonalNotepadUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void open(ActionEvent e, PersonalNotepadUI notepad)
    {
        var fileChooser = new JFileChooser();
        var textFilter = new FileNameExtensionFilter("Only Text Files(.txt)",
                "txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(textFilter);

        int action = fileChooser.showSaveDialog(null);
        if (action != JFileChooser.APPROVE_OPTION)
        {
            return;
        }

        var fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
        if (!fileName.contains(".txt"))
        {
            fileName = fileName + ".txt";
        }

        try
        {
            var writer = new BufferedWriter(new FileWriter(fileName));
            notepad.textArea.write(writer);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void save(ActionEvent e, PersonalNotepadUI notepad)
    {
        var fileChooser = new JFileChooser();
        var textFilter = new FileNameExtensionFilter("Only Text Files(.txt)", "txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(textFilter);

        var action = fileChooser.showSaveDialog(null);
        if (action != JFileChooser.APPROVE_OPTION)
        {
            return;
        }

        String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
        if (!fileName.contains(".txt"))
            fileName = fileName + ".txt";
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            notepad.textArea.write(writer);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}