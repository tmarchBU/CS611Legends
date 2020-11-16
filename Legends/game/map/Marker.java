package game.map;

/*
File: Marker.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Marker of a cell on a board
*/

public class Marker {
    private String image;           // visual representation of the marker

    // CONSTRUCTORS

    /*
    no-arg constructor - DO NOT USE, fail-safe if no-arg constructor is called by user/developer
    Initializes image as "?"
    */
    public Marker()
    {
        setImage("?");
    }
    /*
    Constructs the marker object with the inputed image
    Input - String image
    */
    public Marker(String image)
    {
        setImage(image);
    }

    /*
    toString - returns image, the visual representation of the marker
    */
    public String toString()
    {
        return getImage();
    }

    // GETTER METHODS

    /*
    image Getter - returns the image
    */
    public String getImage()
    {
        return this.image;
    }

    // SETTER METHOD

    /*
    image Setter - sets the image to the inputed image
    */
    public void setImage(String image)
    {
        this.image = image;
    }
}// end class