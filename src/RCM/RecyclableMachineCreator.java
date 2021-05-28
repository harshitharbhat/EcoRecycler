package RCM;

import GUI.RcmGui;

public class RecyclableMachineCreator {

    public void createMachineUI(){

        RcmGui rcmUI = new RcmGui();
        rcmUI.createFrame(RecyclableMachineCache.getItem(1));
        rcmUI.createFrame(RecyclableMachineCache.getItem(2));

    }




}
