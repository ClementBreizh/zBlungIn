//package com.apsidepoei.projetpoeitest.database.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.apsidepoei.projetpoei.database.DbManager;
//import com.apsidepoei.projetpoei.entities.Company;
//
//
///**
// *
// * @author benjamin-m
// *
// */
//public class CompanyDaoSelectTest {
//
//	static List<Company> companys = new ArrayList<Company>();
//
//	/**
//	 * Before the tests, create new data
//	 */
//    @BeforeClass
//    public static void config() {
//        Company company1 = new Company("company1", "antenne1", "53267126000018", "0000A");
//        Company company2 = new Company("company2", "antenne1", "53267126000018", "0000A");
//        Company company3 = new Company("company3", "antenne1", "53267126000018", "0000A");
//        company1.setId(1);
//        company2.setId(2);
//        company3.setId(3);
//        companys.add(company1);
//        companys.add(company2);
//        companys.add(company3);
//    }
//
//    /**
//	 *
//	 * @throws Exception
//	 * Before each test, drop, create and insert new data
//	 */
//    @Before
//    public void drop() throws Exception{
//        DbManager.getInstance().getCompanyDao().drop();
//        DbManager.getInstance().getCompanyDao().create();
//        DbManager.getInstance().getCompanyDao().insert(companys.get(0));
//        DbManager.getInstance().getCompanyDao().insert(companys.get(1));
//        DbManager.getInstance().getCompanyDao().insert(companys.get(2));
//    }
//
//    /**
//	 *
//	 * @throws Exception
//	 * Test to select all
//	 */
//    @Test
//    public void selectAll() throws Exception {
//        assertNotNull(DbManager.getInstance().getCompanyDao().select());
//    }
//
//    /**
//	 *
//	 * @throws Exception
//	 * Test select all with a count
//	 */
//    @Test
//    public void selectAllCount() throws Exception {
//        List<Company> listObjects = DbManager.getInstance().getCompanyDao().select();
//        DbManager.getInstance().getCompanyDao().select();
//        assertEquals(3, listObjects.size());
//    }
//
//    /**
//	 *
//	 * @throws Exception
//	 * Test the data compare
//	 */
//    @Test
//    public void dataCompare() throws Exception {
//        List<Company> listObjects = DbManager.getInstance().getCompanyDao().select();
//
//        assertTrue((companys.get(0).getId() == ((Company)listObjects.get(0)).getId()) && (companys.get(0).getNom().equals(((Company)listObjects.get(0)).getNom())));
//    }
//
//}
