package ua.nure.cs.chebanenko.usermanagement171.db;

import junit.framework.TestCase;




import ua.nure.cs.chebanenko.usermanagement171.db.DaoFactory;
import ua.nure.cs.chebanenko.usermanagement171.db.Dao;

import static org.junit.Assert.assertNotNull;

public class DaoFactoryTest {

    
    public void setUp() throws Exception {
    }

    
    public void tearDown() throws Exception {

    }

    
    public void getDao() {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            assertNotNull("DaoFactory instance is null.", daoFactory);

           Dao userDao = daoFactory.getUserDao();
            assertNotNull("UserDao is null.", userDao);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
}
