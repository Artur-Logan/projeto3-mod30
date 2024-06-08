package main.br.com.artur.dao.jpa;

import main.br.com.artur.dao.generic.jpa.GenericJpaDAO;
import main.br.com.artur.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }

}
