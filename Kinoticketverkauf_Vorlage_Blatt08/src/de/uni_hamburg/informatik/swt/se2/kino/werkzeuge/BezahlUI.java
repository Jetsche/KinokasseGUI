package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.GridLayout;

import javax.swing.*;

public class BezahlUI
{
    JDialog _dialog;
    JButton _okButton;
    JButton _cancelButton;
    JLabel _gesamtbetragText;
    JLabel _bezahlBetragText;
    JLabel _differenzBetragText;
    JTextField _gesamtbetrag;
    JTextField _bezahlBetrag;
    JTextField _differenzBetrag;
    
    public BezahlUI()
    {
        initDialog();
        initGesamtBetrag();
        initBezahlen();
        initDifferenz();
        initOkButton();
        initCancelButton();
        JPanel panel = new JPanel();
        panel.add(_okButton);
        panel.add(_cancelButton);
        _dialog.add(panel);
        _dialog.setAlwaysOnTop(true);
        _dialog.pack();
        _dialog.setVisible(true);
        _dialog.setBounds(200, 400, 500, 200);
    }
    
    private void initDialog()
    {
        _dialog = new JDialog();
        _dialog.setTitle("Barzahlung");
       _dialog.setLayout(new GridLayout(4,2));
    }
    
    private void initBezahlen()
    {
        _bezahlBetragText = new JLabel("Eingabebetrag:");
        _bezahlBetrag = new JTextField(25);
        _bezahlBetrag.setEditable(true);
        JPanel panel = new JPanel();
        panel.add(_bezahlBetragText);
        panel.add(_bezahlBetrag);
        panel.setEnabled(true);
        _dialog.add(panel);
    }
    
    private void initGesamtBetrag()
    {
        _gesamtbetragText = new JLabel("Gesamtbetrag:");
        _gesamtbetrag = new JTextField(25);
        _gesamtbetrag.setEditable(false);
        JPanel panel = new JPanel();
        panel.add(_gesamtbetragText);
        panel.add(_gesamtbetrag);
        _dialog.add(panel);
    }
    
    private void initDifferenz()
    {
        _differenzBetragText = new JLabel("Rückgabebetrag:");
        _differenzBetrag = new JTextField(25);
        _differenzBetrag.setEditable(false);
        JPanel panel = new JPanel();
        panel.add(_differenzBetragText);
        panel.add(_differenzBetrag);
        _dialog.add(panel);
    }
    private void initOkButton()
    {
        _okButton = new JButton("OK");
       
    }
    
    private void initCancelButton()
    {
        _cancelButton = new JButton("Abbrechen");
    }

}
