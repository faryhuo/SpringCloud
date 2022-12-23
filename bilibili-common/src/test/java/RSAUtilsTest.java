import com.bilibili.common.utils.RSAUtils;
import org.junit.Assert;
import org.junit.Test;

public class RSAUtilsTest {

    @Test
    public void testEncodingPassword() throws Exception {
        String password=RSAUtils.encrypt("pw");
        System.out.println(password);
        //EynmGoeI812wO4GxVqcLmscR9rZI4uqRHWwuRMCF402+8+sLClIJbYJaG+GUmkptmKOhR7dGWGTH3FLYJxMJdf4NSu3yqFnXuR3RNAOoZVqdv1J+BUtPMEpQPB2GJaIhTeVRyV6YMnQ72STkSm711xoyl/ZreOh1c4aX3G/Uhe4=
        Assert.assertNotNull(password);
    }
}
