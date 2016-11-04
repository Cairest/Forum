/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import funcao.Funcao;
import funcao.Funcao;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 1539917
 */
public class TestesFuncao {
    
    JdbcDatabaseTester jdt;
    
    
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/forum", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/TestesXML/inicioUsuarios.xml"));
        jdt.onSetup();
    }

    @Test
    public void testeFuncaoLogar() throws Exception{
        assertEquals("cassiano", Funcao.class.newInstance().logar("cassiano", "senhaCassiano"));
        assertEquals("gisele", Funcao.class.newInstance().logar("gisele", "senhaGisele"));
    }
    
    @Test
    public void testeCadastrar() throws Exception{
        Funcao.class.newInstance().cadastrar("maria", "maria@hotmail.com", "Maria Santos", "senhaMaria");
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataset = loader.load("/TestesXML/usuarioAdicionado.xml");
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
    @Test
    public void testeCadastrarUsuarioExistente(){
        try {
            Funcao.class.newInstance().cadastrar("cassiano", "maria@hotmail.com", "Maria Santos", "senhaMaria");
        } catch (Exception e) {
        }
        
    
    }
    
}
