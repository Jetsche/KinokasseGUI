package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import de.uni_hamburg.informatik.swt.se2.kino.materialien.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Vorstellung;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeug;

public class BezahlWerkzeug
{
    private BezahlUI _ui;
    private PlatzVerkaufsWerkzeug _platzVerkaufsWerkzeug;
    private Vorstellung _vorstellung;
    private int _preis;

    public BezahlWerkzeug(PlatzVerkaufsWerkzeug platzVerkaufsWerkzeug, Vorstellung vorstellung, int preis)
    {
        _vorstellung = vorstellung;
        _platzVerkaufsWerkzeug = platzVerkaufsWerkzeug;
        _ui = new BezahlUI(preis);
        _preis = preis;
    }
    
    public void registriereUIAktionen()
    {
        _ui.getOkButton().addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // TODO Was soll passieren, wenn OK geklickt wird?
                _platzVerkaufsWerkzeug.verkaufePlaetze(_vorstellung);
                _ui.closeUI();
            }
        });
        _ui.getCancelButton().addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                _ui.closeUI();
                _platzVerkaufsWerkzeug.aktualisierePlatzplan();
            }
        });
        _ui.getEingabefeld().addKeyListener(new KeyAdapter()
        {
            
            
            @Override
            public void keyReleased(KeyEvent e)
            {
                int differenz = berechneDifferenz(_preis, _ui.getEingabefeld().getText());
                _ui.getDifferenzBetragFeld().setText(new Geldbetrag(Math.abs(differenz)).getFormatiertenString());
                
            }
          
        }
        );
    }
    
    private int berechneDifferenz(int Gesamtbetrag, String Eingabebetrag)
    {
        boolean eingabebetragGueltig = Pattern.matches( "^\\d+([.,]\\d{2})$", Eingabebetrag);
        if (!eingabebetragGueltig)
        {
            _ui.getOkButton().setEnabled(false);
            return 0;
        }
        else
        {
            
            int i = Eingabebetrag.length();
            String cent = Eingabebetrag.substring(i-2);
            String euro = Eingabebetrag.substring(0,i-3);
           int betrag = Integer.parseInt(euro + cent);
           int diffBetrag = Gesamtbetrag - betrag;
           if(diffBetrag <= 0)
           {
               _ui.getOkButton().setEnabled(true);
           }
           else
           {
               return 0;
           }
            
            return diffBetrag;
        }

        
    }
    
    public BezahlUI getUI()
    {
        return _ui;
    }
}
