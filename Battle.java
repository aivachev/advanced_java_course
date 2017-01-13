public class Battle {
    private Pokemon firstP, secondP;

    public boolean isNotEnd() {
        if (firstP.loser() || secondP.loser()) {
            return false;
        }
        return true;
    }

    public Battle(int firstPokemon, int secondPokemon, pokemaster firstPokemaster, pokemaster secondPokemaster) {
        this.firstP = firstPokemaster.getPokemon(firstPokemon);
        this.secondP = secondPokemaster.getPokemon(secondPokemon);
    }

    public void action(int poke, int action) {
        switch (poke) {
            case 1: secondP.minusHP(firstP.Action(action));
                break;
            case 2: firstP.minusHP(secondP.Action(action));
                break;
        }

    }

    public Pokemon FirstPokemon() {
        return firstP;
    }
    public Pokemon SecondPokemon() {
        return secondP;
    }

    public Pokemon winner() {
        if (firstP.loser()) {
            return secondP;
        } else {
            return firstP;
        }
    }
}
