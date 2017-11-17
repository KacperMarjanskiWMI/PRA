import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class checkQueryTest {

    @Test
    public void checkQuery1() throws Exception {
        assertFalse(xIncrase.checkQuery("ELELELELELE"));
    }

    @Test
    public void checkQuer2() throws Exception {
        assertTrue(xIncrase.checkQuery("SELECT FROM COS WHERE COS = INNE ORDER BY INNE2 DESC"));
    }

    @Test
    public void checkQuer3() throws Exception {
        assertTrue(xIncrase.checkQuery("SELECT WHERE SLSLSLSLSL"));
    }



}