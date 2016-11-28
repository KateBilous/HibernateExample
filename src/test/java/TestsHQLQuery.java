import com.journaldev.hibernate.main.HibernateAnnotationMain;
import org.testng.annotations.Test;


public class TestsHQLQuery {
    @Test(priority = 0)
    public void Date(){

        HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();

        hibernateAnnotationMain.HQLQuerySelectCortageByDate("2016-11-27");

    }

    @Test(priority = 1)
    public void allEmployee(){

        HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();

        hibernateAnnotationMain.HQLQueryEmployee();

    }
    @Test
    public void betweenDate(){
        HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();
        hibernateAnnotationMain.HQLQueryBetweenDates("2014-11-26", "2016-11-27");

    }
    @Test
    public void byName(){
        HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();
        hibernateAnnotationMain.HQLQwerySelectCortageByName("alex");

    }
    @Test
    public void afterDate(){
        HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();
        hibernateAnnotationMain.HQLQueryEmployeeEddedAfterDueDate("2016-11-25");

    }
    @Test
    public void geiID(){
        HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();
        hibernateAnnotationMain.HQLQuerySelectByID(5);


    }

}
