package dolpheen.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable orangeHrmHomePage() {
        return Task.where("{0} opens the Pet Store home page",
                Open.browserOn().the(OrangeHrmPage.class));
    }
}
