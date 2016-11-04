/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ConexaoDB;
import dao.UsuarioDAO;
import java.io.File;
import java.io.FileOutputStream;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import usuario.Usuario;

/**
 *
 * @author 1539917
 */
public class TestesUsuarioDAO {
    
    
    JdbcDatabaseTester jdt;
    
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/forum", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/TestesXML/inicioUsuarios.xml"));
        
        IDatabaseConnection conn = new DatabaseConnection(ConexaoDB.class.newInstance().getConnection());
        ITableFilter filter = new DatabaseSequenceFilter(conn);
        IDataSet dataset = new FilteredDataSet(filter, conn.createDataSet());
        FlatXmlDataSet.write(dataset, new FileOutputStream("/TestesXML/inicioUsuarios.xml"));
        
        jdt.onSetup();  
        
    }
    
    @Test
    public void recuperaUsuario() throws Exception{
        Usuario u1 = UsuarioDAO.class.newInstance().recuperar("cassiano");
        assertEquals("Cassiano Teixeira", u1.getNome());
        assertEquals("cassiano", u1.getLogin());
        assertEquals("cassiano@gmail.com", u1.getEmail());
        Usuario u2 = UsuarioDAO.class.newInstance().recuperar("gisele");
        assertEquals("Gisele Ferreira", u2.getNome());
        assertEquals("gisele@yahoo.com", u2.getEmail());
    }
    
    @Test
    public void recuperaUsuarioInexistente() throws Exception{
        assertTrue(UsuarioDAO.class.newInstance().recuperar("marxzcia")==null);
    }
    

    
}
