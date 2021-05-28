package RCM;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RecyclableItemCache {
    private static Hashtable<Integer, RecyclableItem> itemsMap = new Hashtable<>();

    public static RecyclableItem getItem(Integer itemId){
        //        @TODO try to use clone
//        RecyclableItem cachedItem = itemsMap.get(itemId);
//        return (RecyclableItem) cachedItem.clone();
        return itemsMap.get(itemId);
    }

    public static List<RecyclableItem> getAllItems(){
        //        @TODO try to use clone
//        RecyclableItem cachedItem = itemsMap.get(itemId);
//        return (RecyclableItem) cachedItem.clone();
        return (new ArrayList<>(itemsMap.values()));
    }

    public static void addNewItem(RecyclableItem ri){
        itemsMap.put(ri.getItemId(), ri);
    }

    public static void loadCache(){
        RecyclableItem ri1 = new RecyclableItem("Glass",1, (float) 2.5);
        RecyclableItem ri2 = new RecyclableItem("Aluminum",2, (float) 2);
        itemsMap.put(ri1.getItemId(),ri1);
        itemsMap.put(ri2.getItemId(),ri2);

    }
}
