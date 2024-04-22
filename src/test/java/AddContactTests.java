import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactTests extends BaseTest{

    @BeforeClass
    public void preconditions() {
        // TODO login
    }

    @Test
    public void positiveAddContact() {
        // click on //a[@href='/add'] - open add contact page
        // fill name in //input[@placeholder='Name']
        // fill last name //input[@placeholder='Last Name']
        // fill phone //input[@placeholder='Phone']
        // fill email //input[@placeholder='email']
        // fill address //input[@placeholder='Address']
        // fill description //input[@placeholder='description']
        // click save //div[contains(@class,'add_form')]//button
    }
}
