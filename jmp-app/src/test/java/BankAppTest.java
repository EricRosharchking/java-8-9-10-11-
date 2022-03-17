import jmp.bank.api.Bank;
import jmp.cloud.bank.impl.BankImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAppTest {

    /*
    @Test
    public void testCheckSum1() {
        String str = "8532";
        assertEquals(checkSum(str), Bank.getCheckSum(getStr(str)));
    }
    @Test
    public void testCheckSum2() {
        String str = "79927398713";
        assertEquals(checkSum(str), Bank.getCheckSum(getStr(str)));
    }


    @Test
    public void testCheckSum3() {
        String str = "3946244629819579";
        assertEquals(checkSum(str), Bank.getCheckSum(getStr(str)));
    }
    */

    static int checkSum(String str) {
        return str.charAt(str.length() - 1) - '0';
    }

    static String getStr(String str) {
        return str.substring(0, str.length() - 1);
    }
}
