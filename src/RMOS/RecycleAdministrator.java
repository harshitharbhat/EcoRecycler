package RMOS;

import GUI.RmosLogin;
import GUI.RmosUI;

public class RecycleAdministrator {
    public void createRMOS(){
        System.out.println("Creating RMOS");
        RmosLogin loginUser = new RmosLogin();
        //loginUser.rmosLogin();
        RmosUI rmosUI = new RmosUI();

        rmosUI.createRMOS();

    }
}
