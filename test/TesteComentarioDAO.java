/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ComentarioDAO;
import java.util.List;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import usuario.Comentario;

/**
 *
 * @author cassiano
 */
public class TesteComentarioDAO {
    
    JdbcDatabaseTester jdt;
    
    @Before
    public void setUp() throws Exception{
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/forum", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/TestesXML/inicioComentarios.xml"));
        jdt.onSetup();           
    }

    @Test
    public void recuperaComentarios() throws Exception{
        
        List<Comentario> lista1 = ComentarioDAO.class.newInstance().recuperar(1);
        assertEquals(2, lista1.size());
    }
}
