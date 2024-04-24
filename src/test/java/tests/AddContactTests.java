package tests;

import dto.ContactDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddContactTests extends BaseTest{

    @BeforeClass
    public void preconditions() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);
    }

    @AfterClass
    public void methodPostCondition() {
        app.getUserHelper().clickLogoutBtn();
        app.getHomePageHelper().navigateToHomePage();
    }

    @Test
    public void positiveAddContact() {
        app.getContactHelper().clickAddOnNavBar();
        ContactDTO contactDTO = new ContactDTO()
                .setName("kjdhgjkr")
                .setLastName("jhsbfh")
                .setPhone("5554567890")
                .setEmail("sjkfhj@mail.com")
                .setAddress("hjsbfhb")
                .setDescription("bhjfdb");
        app.getContactHelper().addContact(contactDTO);

        app.getContactHelper().pause(3000);

        Assert.assertTrue(app.getContactHelper().isContactDisplaysOnThePage("5554567890"));
    }

}
