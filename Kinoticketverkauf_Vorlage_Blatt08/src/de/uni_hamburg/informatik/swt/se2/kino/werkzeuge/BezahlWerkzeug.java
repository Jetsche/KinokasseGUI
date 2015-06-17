package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.uni_hamburg.informatik.swt.se2.kino.materialien.Vorstellung;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeug;

public class BezahlWerkzeug
{
    private BezahlUI _ui;
    private PlatzVerkaufsWerkzeug _platzVerkaufsWerkzeug;
    private Vorstellung _vorstellung;

    public BezahlWerkzeug(PlatzVerkaufsWerkzeug platzVerkaufsWerkzeug, Vorstellung vorstellung)
    {
        _vorstellung = vorstellung;
        _platzVerkaufsWerkzeug = platzVerkaufsWerkzeug;
        _ui = new BezahlUI();
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
    }
    
    public BezahlUI getUI()
    {
        return _ui;
    }
}
