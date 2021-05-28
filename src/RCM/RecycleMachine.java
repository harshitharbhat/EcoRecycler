package RCM;

import java.util.Date;
import java.util.List;

public class RecycleMachine implements Cloneable{
    private int machineId;
    private String location;
    private float weightAdded;
    private float allowedWeight;
    private float returnableAmount;
    private float moneyAvailable;
    private boolean operational;
    private Date timeEmptied;
    List<RecyclableItem> recyclableItemList;

    public RecycleMachine(int machineId, String location, float allowedWeight, boolean operational,float money) {
        this.machineId = machineId;
        this.location = location;
        this.allowedWeight = allowedWeight;
        this.operational = operational;
        this.moneyAvailable = money;
    }

    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getWeightAdded() {
        return weightAdded;
    }

    public void setWeightAdded(float weightAdded) {
        this.weightAdded = weightAdded;
    }

    public float getAllowedWeight() {
        return allowedWeight;
    }

    public void setAllowedWeight(float allowedWeight) {
        this.allowedWeight = allowedWeight;
    }

    public float getReturnableAmount() {
        return returnableAmount;
    }

    public void setReturnableAmount(float returnableAmount) {
        this.returnableAmount = returnableAmount;
    }

    public List<RecyclableItem> getRecyclableItemsList() {
        return recyclableItemList;
    }

    public void setRecyclableItemsList(List<RecyclableItem> recyclableItemList) {
        this.recyclableItemList = recyclableItemList;
    }

    public float getMoneyAvailable() {
        return moneyAvailable;
    }

    public void setMoneyAvailable(float moneyAvailable) {
        this.moneyAvailable = moneyAvailable;
    }

    public boolean isOperational() {
        return operational;
    }

    public void setOperational(boolean operational) {
        this.operational = operational;
    }

    public Date getTimeEmptied() {
        return timeEmptied;
    }

    public void setTimeEmptied(Date timeEmptied) {
        this.timeEmptied = timeEmptied;
    }
}
