package org.example.metier;

import org.example.dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;
    public void setDao(IDao dao){
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return 2*dao.getValue();
    }
}
