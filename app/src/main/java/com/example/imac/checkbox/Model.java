package com.example.imac.checkbox;

import java.io.Serializable;

/**
 * Created by imac on 25/10/17.
 */

public class Model implements Serializable {

    private String itemName;
    private String isSelected;
    private String isShowed;

    public Model(String itemName, String isSelected, String isShowed) {
        this.itemName = itemName;
        this.isSelected = isSelected;
        this.isShowed = isShowed;
    }

    public String isShowed() {
        return isShowed;
    }

    public void setShowed(String showed) {
        isShowed = showed;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String isSelected() {
        return isSelected;
    }

    public void setSelected(String selected) {
        isSelected = selected;
    }
}