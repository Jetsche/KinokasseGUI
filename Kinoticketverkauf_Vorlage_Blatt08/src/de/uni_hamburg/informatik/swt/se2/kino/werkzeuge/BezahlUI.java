package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.GridLayout;

import javax.swing.*;

import de.uni_hamburg.informatik.swt.se2.kino.materialien.Geldbetrag;

public class BezahlUI
{
    private JDialog _dialog;
    private JButton _okButton;
    private JButton _cancelButton;
    private JLabel _gesamtbetragText;
    private JLabel _bezahlBetragText;
    private JLabel _differenzBetragText;
    private JTextField _gesamtbetrag;
    private JTextField _bezahlBetrag;
    private JTextField _differenzBetrag;
    
    public BezahlUI(int preis)
    {
        initDialog();
        initGesamtBetrag(preis);
        initBezahlen();
        initDifferenz(preis);
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
    
    private void initGesamtBetrag(int preis)
    {
        _gesamtbetragText = new JLabel("Gesamtbetrag:");
        _gesamtbetrag = new JTextField(25);
        _gesamtbetrag.setText(new Geldbetrag(preis).getFormatiertenString());
        _gesamtbetrag.setEditable(false);
        JPanel panel = new JPanel();
        panel.add(_gesamtbetragText);
        panel.add(_gesamtbetrag);
        _dialog.add(panel);
    }
    
    private void initDifferenz(int preis)
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
    
    public JButton getOkButton()
    {
        return _okButton;
    }
    
    public JButton getCancelButton()
    {
        return _cancelButton;
    }
    
    public void closeUI()
    {
        _dialog.dispose();
    }
    
    public JTextField getEingabefeld()
    {
        return _bezahlBetrag;
    }

    public JTextField getDifferenzBetragFeld()
    {
        return _differenzBetrag;
    }
}
