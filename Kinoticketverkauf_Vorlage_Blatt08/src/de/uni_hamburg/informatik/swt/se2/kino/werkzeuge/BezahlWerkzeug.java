package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import de.uni_hamburg.informatik.swt.se2.kino.materialien.Vorstellung;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeug;

public class BezahlWerkzeug
{
    private BezahlUI _ui;
    private PlatzVerkaufsWerkzeug _platzVerkaufsWerkzeug;
    private Vorstellung _vorstellung;

    public BezahlWerkzeug(PlatzVerkaufsWerkzeug platzVerkaufsWerkzeug, Vorstellung vorstellung, int preis)
    {
        _vorstellung = vorstellung;
        _platzVerkaufsWerkzeug = platzVerkaufsWerkzeug;
        _ui = new BezahlUI(preis);
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
                berechneDifferenz(0, _ui.getEingabefeld().getText());
                _ui.getDifferenzBetragFeld().setText("LOKLed");
                
            }
          
        }
        );
    }
    
    private int berechneDifferenz(int Gesamtbetrag, String Eingabebetrag)
    {
        boolean eingabebetragGueltig = Pattern.matches( "^\\d+([.,]\\d{2})?$", Eingabebetrag);
        if (!eingabebetragGueltig)
        {
            _ui.getOkButton().setEnabled(false);
        }
        else
        {
            _ui.getOkButton().setEnabled(true);
        }
        return 2;
    }
    
    public BezahlUI getUI()
    {
        return _ui;
    }
}
