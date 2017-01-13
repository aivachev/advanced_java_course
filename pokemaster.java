import java.util.ArrayList;
import java.util.Iterator;


public class pokemaster {

    private ArrayList<Pokemon> myPokemons;

    public pokemaster() {
        myPokemons = new ArrayList<Pokemon>();
    }

    public Pokemon getPokemon(int i) {
        return myPokemons.get(i);
    }

    public void addPokemon(Pokemon pokemon) {
        myPokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder allPokemons = new StringBuilder();
        int i = 1;
        Iterator<Pokemon> iter = myPokemons.iterator();
        while (iter.hasNext()) {
            allPokemons.append(i++ + ". " + iter.next().getName() + '\n');
        }
        return allPokemons.toString();
    }
}
