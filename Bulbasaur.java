public class Bulbasaur extends Pokemon {
    private static Bulbasaur instance;

    private Bulbasaur() {
        super("Bulbasaur", 100, 100, 40, 52, 15, 20, 5, 15);
        //имя, макс жизнь, макс. стамина, стамина, жизнь, д1, д2, с1,с2
    }

    public static Bulbasaur get() {
        if (instance == null) {
            instance = new Bulbasaur();
        }
        return instance;
    }

    @Override
    public int Action(int a) {
        switch (a) {
            case 1:
                if (Mana > manaOne) {
                    Mana -= manaOne;
                    return damageOne;
                } else {
                    return 0;
                }
            case 2:
                if (Mana > manaTwo) {
                    Mana -= manaTwo;
                    return damageTwo;
                } else {
                    return 0;
                }
        }
        return 0;
    }
}
