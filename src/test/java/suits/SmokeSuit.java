package suits;

import addresses.AddNewAddress;
import groups.AddNewGroup;
import groups.EditGroup;
import logOut.LogOut;
import login.LogIn;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LogIn.class,
                AddNewGroup.class,
                EditGroup.class,
                AddNewAddress.class,
                LogOut.class
        }
)

public class SmokeSuit {

}
