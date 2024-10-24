package Level3;

import Level3.Persistance.PersonDAO;
import Level3.Presentation.MainMenu;
import Level3.Presentation.UIController;

public class MainLevel3 {
    public static void main(String[] args){
        PersonDAO personDAO = new PersonDAO();
        MainMenu mainMenu = new MainMenu();
        UIController uiController = new UIController(mainMenu, personDAO);
        uiController.start();
    }
}
