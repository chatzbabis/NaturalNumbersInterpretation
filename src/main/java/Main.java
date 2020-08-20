import static utils.PhoneNumber.getPhoneInput;
import static utils.PhoneNumber.internationalOrDomestic;

public class Main {

    public static void main(String[] args) {

        String phone= getPhoneInput();

        internationalOrDomestic(phone);

    }
}
