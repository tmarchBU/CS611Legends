package items;

/*
File: Item.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Abstract superclass Item
*/

public abstract class Item 
{
    private String name;
    private int moneyValue;
    
    /*
    CONSTRUCTORS
    */
    public Item(String name, int moneyValue)
    {
        setName(name);
        setMoneyValue(moneyValue);
    }

    /*
    SETTERS
    */
    public void setName(String name)
    {
        this.name = name;
    }

    public void setMoneyValue(int moneyValue)
    {
        this.moneyValue = moneyValue;
    }

    /*
    ACCESSORS
    */
    public String getName()
    {
        return name;
    }

    public int getMoneyValue()
    {
        return moneyValue;
    }
}
