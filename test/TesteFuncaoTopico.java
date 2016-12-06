/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import funcao.Funcao;
import java.util.List;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import usuario.Topico;


public class TesteFuncaoTopico {
    
    JdbcDatabaseTester jdt;
        
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/forum", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/TestesXML/inicioTopicos.xml"));
        jdt.onSetup();  
    }
    
    @Test
    public void retornaListaTopicos(){
        List<Topico> t = new Funcao().listaTopicos();
        assertEquals("Início", t.get(0).getTitulo());
        assertEquals("Tópico 2", t.get(1).getTitulo());
    }
         
}
