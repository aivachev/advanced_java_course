public class Pikachu extends Pokemon{
    private static Pikachu instance;

    private Pikachu() {
        super("Pikachu", 100, 100, 80, 40, 23, 10, 34, 4);
        //имя, макс жизнь, макс. стамина, стамина, жизнь, д1, д2, с1,с2
    }

    public static Pikachu get() {
        if (instance == null) {
            instance = new Pikachu();
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
