import RCM.RecyclableItemCache;
import RCM.RecyclableMachineCache;
import RCM.RecyclableMachineCreator;
import RMOS.RecycleAdministrator;

public class EcoRecycler {
    public static void main(String[] args) {
        System.out.println("Welcome to Eco Recycler v 1.02");
        RecyclableMachineCreator rcm = new RecyclableMachineCreator();
        RecycleAdministrator rmos = new RecycleAdministrator();
        loadAllComponents();
        rcm.createMachineUI();
        //rmos.createRMOS();

    }
    private static void loadAllComponents(){
        RecyclableItemCache.loadCache();
        RecyclableMachineCache.loadMachineCache();
    }
}
