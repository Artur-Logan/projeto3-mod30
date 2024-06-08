package main.br.com.artur.services;

import main.br.com.artur.dao.IProdutoDAO;
import main.br.com.artur.domain.Produto;
import main.br.com.artur.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
