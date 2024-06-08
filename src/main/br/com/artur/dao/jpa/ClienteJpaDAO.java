package main.br.com.artur.dao.jpa;

import main.br.com.artur.dao.generic.jpa.GenericJpaDAO;
import main.br.com.artur.domain.jpa.ClienteJpa;

public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

    public ClienteJpaDAO() {
        super(ClienteJpa.class);
    }

}
