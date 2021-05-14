/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdataaccess;

import java.sql.Connection;
import java.sql.SQLException;

import dataacces.Conection;

import org.junit.Test;
import org.junit.Assert;
/**
 *
 * @author Javier Blas
 */
public class DataAccessTest {
    @Test
    public void DataBaseConnectionTest() throws SQLException{
        Connection currentConnection=new Conection().getConnection();
        Assert.assertNotNull(currentConnection);
    } 
}
