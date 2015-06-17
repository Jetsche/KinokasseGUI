package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BezahlWerkzeug
{
    private BezahlUI _ui;

    public BezahlWerkzeug()
    {
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
                
            }
        });
        _ui.getCancelButton().addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                _ui.closeUI();
                
            }
        });
    }
}
