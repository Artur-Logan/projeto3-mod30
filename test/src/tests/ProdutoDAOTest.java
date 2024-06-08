package tests;

import main.br.com.artur.dao.IProdutoDAO;
import main.br.com.artur.dao.ProdutoDAO;
import main.br.com.artur.domain.Produto;
import main.br.com.artur.exceptions.DAOException;
import main.br.com.artur.exceptions.MaisDeUmRegistroException;
import main.br.com.artur.exceptions.TableException;
import main.br.com.artur.exceptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProdutoDAOTest {

    private IProdutoDAO produtoDao;

    public ProdutoDAOTest() {
        produtoDao = (IProdutoDAO) new ProdutoDAO();
    }

    @After
    public void end() throws DAOException {
        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                produtoDao.excluir(prod.getCodigo());
            } catch (DAOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    private Produto criarProduto(String codigo) throws TipoChaveNaoEncontradaException, DAOException {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto " + codigo);
        produto.setNome("Produto " + codigo);
        produto.setValor(BigDecimal.TEN);
        produto.setMarca("Marca 1");
        produtoDao.cadastrar(produto);
        return produto;
    }

    private void excluir(String valor) throws DAOException {
        this.produtoDao.excluir(valor);
    }

    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Produto produto = criarProduto("A1");
        assertNotNull(produto);
        Produto produtoDB = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        excluir(produtoDB.getCodigo());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException {
        Produto produto = criarProduto("A2");
        assertNotNull(produto);
        excluir(produto.getCodigo());
    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Produto produto = criarProduto("A3");
        assertNotNull(produto);
        excluir(produto.getCodigo());
        Produto produtoBD = this.produtoDao.consultar(produto.getCodigo());
        assertNull(produtoBD);
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
       Produto produto = new Produto();
       produto.setNome("Produto 1");
       produto.setCodigo("1234");
       produto.setValor(BigDecimal.TEN);
       produto.setMarca("Marca 1");
       produto.setDescricao("Descirção");

       Boolean retorno = produtoDao.cadastrar(produto);
       assertTrue(retorno);

       Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
       assertNotNull(produtoConsultado);

       produtoConsultado.setNome("Produto 2");
       produtoDao.alterar(produtoConsultado);

       Produto produtoAlterado = produtoDao.consultar(produtoConsultado.getCodigo());
       assertNotNull(produtoAlterado);
       assertEquals("Produto 2", produtoAlterado.getNome());

       produtoDao.excluir(produto.getCodigo());
       produtoConsultado = produtoDao.consultar(produto.getCodigo());
       assertNull(produtoConsultado);
    }

    @Test
    public void buscarTodos() throws DAOException, TipoChaveNaoEncontradaException {
        criarProduto("A5");
        criarProduto("A6");
        Collection<Produto> list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (Produto prod : list) {
            excluir(prod.getCodigo());
        }

        list = produtoDao.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);
    }
}
