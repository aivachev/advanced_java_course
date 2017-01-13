public class Beedrill extends Pokemon{
    private static Beedrill instance;

    private Beedrill() {
        super("Beedrill", 100, 100, 89, 98, 34, 14, 20, 15);
        //имя, макс жизнь, макс. стамина, стамина, жизнь, д1, д2, с1,с2
    }

    public static Beedrill get() { //Singleton
        if (instance == null) {
            instance = new Beedrill();
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
