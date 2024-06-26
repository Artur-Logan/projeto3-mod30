package main.br.com.artur.services.generic.jpa;

import main.br.com.artur.dao.Persistente;
import main.br.com.artur.dao.generic.jpa.IGenericJapDAO;

import java.io.Serializable;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable>
        implements IGenericJpaService<T, E> {

    protected IGenericJapDAO<T, E> dao;

    public GenericJpaService(IGenericJapDAO<T, E> dao) {
        this.dao = dao;
    }
}
