package game.map;

/*
File: Board.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A game board, which can be used to represent a map
*/

public class Board 
{
    protected Cell[][] board;         // 2D array of cells that represents the board

    // CONSTRUCTORS

    public Board()
    {

    }

    /*
    Constructs the board with inputed height and width
    Input - int height, int width
    */
    public Board(int width, int height)
    {
        setBoard(new Cell[height][width]);
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j] = new Cell();
            }
        }
        setCellAdjacents();
    }

    /*
    Constructs a square board with inputed dimensions
    Input - int dimensions
    */
    public Board(int dimensions)
    {
        this(dimensions, dimensions);
    }

    /*
    SETTER
    */
    public void setBoard(Cell[][] cells)
    {
        this.board = cells;
    }

    /*
    toString - returns a string representation of the board
    */
    public String toString()
    {
        String string = rowString();
        int index = 1;

        for (int i = 0; i < board.length; i++)
        {
            string += "|";
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j].getCharacters().size() != 0)
                {
                    for (int x = 0; x < board[i][j].getCharacters().size(); x++)
                    {
                        string += board[i][j].getCharacters().get(x).getMarker();
                    }
                }
                else if (board[i][j].getMarker() == null)
                {                    
                    string += index;
                    if (index < 10)
                    {
                        string += " ";
                    }
                }
                else
                {
                    string += board[i][j].getMarker();
                }
                string += "|";
                index++;
            }
            string += "\n" + rowString();
        }
        return string;
    }

    /*
    helper method to print the correct length of the board
    */
    private String rowString()
    {
        String str = "+";
        for (int i = 0; i < board[0].length; i++)
        {
            str += "--+";
        }
        str += "\n";
        return str;
    }

    // GETTER METHODS

    /*
    Width Getter - returns the width of the board
    */
    public int getWidth()
    {
        return board.length;
    }

    /*
    Height Getter - returns the height of the board
    */
    public int getHeight()
    {
        return board[0].length;
    }

    /*
    Dimensions Getter - returns a string representation of the board dimensions
    */
    public String getDimensions()
    {
        return getWidth() + "x" + getHeight();
    }

    /*
    Board Getter - returns a reference to Cells of the board
    */
    public Cell[][] getBoard()
    {
        return board;
    }

    /*
    Marker Getter - returns the marker from specific cell in the board
    */
    public Marker getMarker(int row, int col)
    {
        return board[row][col].getMarker();
    }

    public Cell getCell(int row, int col)
    {
        return getBoard()[row][col];
    }

    // SETTER METHODS

    /*
    sets the marker of a given cell index to a given marker, and returns true if it was successful
    */
    public boolean setMarker(int index, Marker marker)
    {
        boolean valid = false;
        int row = (index - 1) / board.length;
        int col = (index - 1) % board[0].length;

        if (index <= ((board.length)*(board[0].length)) && index > 0 && board[row][col].getMarker() == null)
        {
            board[row][col].setMarker(marker);
            valid = true;
        }
        return valid;
    }

    /*
    isFull - returns true if the board is full
    */
    public boolean isFull()
    {
        boolean isFull = true;

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j].getMarker() == null)
                {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    /*
    setCellAdjacents - sets the adjacents for every cell on the board, allowing for relative movement across the board
    */
    protected void setCellAdjacents()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (i != 0)
                {
                    board[i][j].setAbove(board[i-1][j]);
                }
                if (j != 0)
                {
                    board[i][j].setLeft(board[i][j-1]);
                }
                if (i != board.length - 1)
                {
                    board[i][j].setBelow(board[i+1][j]);
                }
                if (j != board[0].length - 1)
                {
                    board[i][j].setRight(board[i][j+1]);
                }
            }
        }
    }
}