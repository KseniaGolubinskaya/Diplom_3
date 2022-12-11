import org.apache.commons.lang3.RandomStringUtils;

public class TestsHelper {
    public static String generateEmail(){
        return RandomStringUtils.randomAlphabetic(10) + '@' + RandomStringUtils.randomAlphabetic(5) + '.' + RandomStringUtils.randomAlphabetic(3);
    }
}
