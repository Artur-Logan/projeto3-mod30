package main.br.com.artur.dao;

import main.br.com.artur.dao.generic.IGenericDAO;
import main.br.com.artur.domain.Venda;
import main.br.com.artur.exceptions.DAOException;
import main.br.com.artur.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
