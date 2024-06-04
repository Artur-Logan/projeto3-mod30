package services.generic.jpa;

import dao.Persistente;
import dao.generic.jpa.IGenericJapDAO;

import java.io.Serializable;

public abstract class GenericJpaService<T extends Persistente, E extends Serializable>
        implements IGenericJpaService<T, E> {

    protected IGenericJapDAO<T, E> dao;

    public GenericJpaService(IGenericJapDAO<T, E> dao) {
        this.dao = dao;
    }
}
