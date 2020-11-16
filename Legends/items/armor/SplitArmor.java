package items.armor;

/*
File: SplitArmor.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: An armortype with split armor pieces
*/

/*
Imported Libararies
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;

public class SplitArmor implements ArmorType
{
    private final int numPieces = 4;
    private int totalValue;
    private Helmet helmet;
    private SplitBody body;
    private Gloves gloves;
    private Boots boots;

    /*
    CONSTRUCTORS
    */
    public SplitArmor()
    {
        setTotalValue(0);
        setHelmet(null);
        setBody(null);
        setGloves(null);
        setBoots(null);
    }

    public void setHelmet(Helmet helmet)
    {
        if (getHelmet() != null)
        {
            decrementTotalValue(getHelmet().getArmorValue());
            incrementTotalValue(helmet.getArmorValue());
        }
        this.helmet = helmet;
        
    }

    public void setBody(SplitBody body)
    {
        if (getBody() != null)
        {
            decrementTotalValue(getBody().getArmorValue());
            incrementTotalValue(body.getArmorValue());
        }
        
        this.body = body;
    }

    public void setBoots(Boots boots)
    {
        if (getBoots() != null)
        {
            decrementTotalValue(getBoots().getArmorValue());
            incrementTotalValue(boots.getArmorValue());
        }

        this.boots = boots;
    }

    public void setGloves(Gloves gloves)
    {
        if (getGloves() != null)
        {
            decrementTotalValue(getGloves().getArmorValue());
            incrementTotalValue(gloves.getArmorValue());
        }

        this.gloves = gloves;
    }

    private void setTotalValue(int total)
    {
        totalValue = total;
    }


    /*
    ACCESSORS
    */
    public int getNumPieces()
    {
        return numPieces;
    }

    public int getTotalValue()
    {
        return totalValue;
    }

    public Helmet getHelmet()
    {
        return helmet;
    }

    public SplitBody getBody()
    {
        return body;
    }

    public Boots getBoots()
    {
        return boots;
    }

    public Gloves getGloves()
    {
        return gloves;
    }


    /*
    MUTATORS
    */
    private void incrementTotalValue(int value)
    {
        totalValue += value;
    }

    private void decrementTotalValue(int value)
    {
        totalValue -= value;
    }

    /*
    remove - removes a piece of armor
    */
    public Gloves removeGloves()
    {
        Gloves temp = getGloves();
        if (temp != null)
        {
            decrementTotalValue(temp.getArmorValue());
            setGloves(null);
        }
        return temp;
    }

    public Helmet removeHelmet()
    {
        Helmet temp = getHelmet();
        if (temp != null)
        {
            decrementTotalValue(temp.getArmorValue());
            setHelmet(null);
        }
        return temp;
    }

    public Boots removeBoots()
    {
        Boots temp = getBoots();
        if (temp != null)
        {
            decrementTotalValue(temp.getArmorValue());
            setBoots(null);
        }
        return temp;
    }

    public SplitBody removeBody()
    {
        SplitBody temp = getBody();
        if (temp != null)
        {
            decrementTotalValue(temp.getArmorValue());
            setBody(null);
        }
        return temp;
    }

    public String toString()
    {
        return "Split Armor Pieces";
    }

    public void printPieces()
    {
        ArrayList<Armor> temp = new ArrayList<Armor>();

        System.out.println("Helmet:");
        if (getHelmet() == null)
        {
            System.out.println("None");
        }
        else
        {
            temp.add(getHelmet());
            TableHelper.printArmor(temp);
            temp.remove(0);
        }
        
        System.out.println("Body:");
        if (getBody() == null)
        {
            System.out.println("None");
        }
        else
        {
            temp.add(getBody());
            TableHelper.printArmor(temp);
            temp.remove(0);
        }

        System.out.println("Gloves:");
        if (getGloves() == null)
        {
            System.out.println("None");
        }
        else
        {
            temp.add(getGloves());
            TableHelper.printArmor(temp);
            temp.remove(0);
        }

        System.out.println("Boots:");
        if (getBoots() == null)
        {
            System.out.println("None");
        }
        else
        {
            temp.add(getBoots());
            TableHelper.printArmor(temp);
            temp.remove(0);
        }
    }

    public void addPiece(Armor piece)
    {
        if (piece instanceof Helmet)
        {
            setHelmet((Helmet) piece);
        }
        if (piece instanceof Gloves)
        {
            setGloves((Gloves) piece);
        }
        if (piece instanceof SplitBody)
        {
            setBody((SplitBody) piece);
        }
        if (piece instanceof Boots)
        {
            setBoots((Boots) piece);
        }
    }
}
