package game.player;

import java.util.ArrayList;

import characters.Hero;
import game.map.Marker;

public class LegendsPlayer extends Player
{
    ArrayList<Hero> heroes;

    public LegendsPlayer(String name, Marker marker)
    {
        super(name, "1", marker);
        setHeroes(new ArrayList<Hero>());
    }

    public void setHeroes(ArrayList<Hero> heroes)
    {
        this.heroes = heroes;
    }

    public ArrayList<Hero> getHeroes()
    {
        return heroes;
    }
}
