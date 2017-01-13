public class Psyduck extends Pokemon{
    private static Psyduck instance;

    private Psyduck() {
        super("Psyduck", 100, 100, 60, 50, 30, 20, 10, 5);
        //имя, макс жизнь, макс. стамина, стамина, жизнь, д1, д2, с1,с2
    }

    public static Psyduck get() {
        if (instance == null) {
            instance = new Psyduck();
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
