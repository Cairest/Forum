import dao.TopicoDAO;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import usuario.Topico;

public class TestesTopicoDAO {
    
    JdbcDatabaseTester jdt;
    
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/forum", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/TestesXML/inicioTopicos.xml"));
        jdt.onSetup();        
    }
    
    @Test
    public void recuperaTopico() throws Exception{
        Topico t = TopicoDAO.class.newInstance().recuperar(1);
        assertEquals("cassiano", t.getLogin());
        
    }
    
    @Test
    public void insereTopico() throws Exception{
        Topico topico = new Topico(3, "Tópico Ajuda", "Preciso de ajuda", "joao");
        TopicoDAO.class.newInstance().inserir(topico);
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("TOPICO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataset = loader.load("/TestesXML/topicoAdicionado.xml");
        ITable expectedTable = expectedDataset.getTable("TOPICO");
        Assertion.assertEquals(expectedTable, currentTable);        
        
    }

    @Test
    public void listaTopicos() throws Exception{
        List<Topico> lista = TopicoDAO.class.newInstance().listaTopicos();
        assertEquals("cassiano", lista.get(0).getLogin());
    
    }
    
}
