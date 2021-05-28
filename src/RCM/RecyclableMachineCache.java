package RCM;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RecyclableMachineCache {
    private static Hashtable<Integer, RecycleMachine> itemsMap = new Hashtable<>();

    public static RecycleMachine getItem(int itemId){
//        @TODO try to use clone
//        RecycleMachine cachedItem = itemsMap.get(itemId);
//        return (RecycleMachine) cachedItem.clone();
        return itemsMap.get(itemId);
    }

    public static List<RecycleMachine> getAllItems(){
        //        @TODO try to use clone
//        RecyclableItem cachedItem = itemsMap.get(itemId);
//        return (RecyclableItem) cachedItem.clone();
        return (new ArrayList<>(itemsMap.values()));
    }

    public static void addNewItem(RecycleMachine rcm){
        itemsMap.put(rcm.getMachineId(),rcm);
    }

    public static void loadMachineCache(){
        RecycleMachine rm1 = new RecycleMachine(1,"University", 60,true,100);
        RecycleMachine rm2 = new RecycleMachine(2,"Hospital",60,false, (float) 65.5);
        itemsMap.put(rm1.getMachineId(),rm1);
        itemsMap.put(rm2.getMachineId(),rm2);

    }
}
