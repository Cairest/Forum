import dao.ConexaoDB;
import dao.TopicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Connection conn;
    
    private void resetaSequence() throws SQLException{
        try {
            this.conn = ConexaoDB.class.newInstance().getConnection();
            String sql = "ALTER SEQUENCE topico_id_topico_seq RESTART WITH 1;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            conn.close();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TestesTopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @Before
    public void setUp() throws Exception {
        resetaSequence();
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/forum", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/TestesXML/inicio.xml"));
        jdt.onSetup();    
        
        
    }
    
    @Test
    public void recuperaTopico() throws Exception{
        Topico t = TopicoDAO.class.newInstance().recuperar(1);
        assertEquals("cassiano", t.getLogin());
        
    }
    
    @Test
    public void insereTopico() throws Exception{
        //resetaSequence();
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
        assertEquals("gisele", lista.get(1).getLogin());
            
    }
    
}
