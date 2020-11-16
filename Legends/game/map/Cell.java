package game.map;

/*
File: SpellFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A cell of a board
*/

public class Cell implements Moveable
{
    private Marker marker;          // holds reference to the marker located on that cell
    private Cell above;             // holds reference to the cell above it
    private Cell below;             // holds reference to the cell below it
    private Cell left;              // holds reference to the cell left of it
    private Cell right;             // holds reference to the cell right of it

    /*
    CONSTRUCTORS
    */
    public Cell()
    {
        setMarker(null);
        setAbove(null);
        setBelow(null);
        setRight(null);
        setLeft(null);
    }

    public Cell(Marker marker)
    {
        this();
        setMarker(marker);
    }

    // GETTER METHODS

    /*
    Marker Getter - returns the marker in that cell
    */
    public Marker getMarker()
    {
        return this.marker;
    }

    public Cell getAbove()
    {
        return above;
    }

    public Cell getBelow()
    {
        return below;
    }

    public Cell getLeft()
    {
        return left;
    }

    public Cell getRight()
    {
        return right;
    }

    // SETTER METHODS

    /*
    Marker Setter - sets the marker to the inputed marker
    Input - Marker marker
    */
    public void setMarker(Marker marker)
    {
        this.marker = marker;
    }

    public void setAbove(Cell cell)
    {
        this.above = cell;
    }

    public void setBelow(Cell cell)
    {
        this.below = cell;
    }

    public void setRight(Cell cell)
    {
        this.right = cell;
    }

    public void setLeft(Cell cell)
    {
        this.left = cell;
    }

    /*
    Moveable Methods
    */
    public boolean enter(Marker marker)
    {
        setMarker(marker);

        return true;
    }

    public boolean enterable()
    {
        return true;
    }

    public boolean exit()
    {
        setMarker(new Marker("  "));

        return true;
    }
}// end class
