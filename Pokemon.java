public abstract class Pokemon {
    protected String name;
    protected int maxHP;
    protected int HP;
    protected int maxMana;
    protected int Mana;

    protected int damageOne, damageTwo;  //2 вида способностей
    protected int manaOne, manaTwo;  //2 вида выносливости

    public Pokemon(String name, int mHealth, int mStamina, int stamina,
                   int health, int damageOne, int damageTwo, int staminaOne, int staminaTwo) {
        this.name = name;
        this.maxHP = mHealth;
        this.maxMana = mStamina;
        this.Mana = stamina;
        this.HP = health;
        this.damageOne = damageOne;
        this.damageTwo = damageTwo;
        this.manaOne = staminaOne;
        this.manaTwo = staminaTwo;
    }

    public int getDamage(int c) {
        int res = 0;
        switch (c) {
            case 1:
                res = damageOne;
                break;
            case 2:
                res = damageTwo;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    public int getStaminaI(int c) {
        int res = 0;
        switch (c) {
            case 1:
                res = manaOne;
                break;
            case 2:
                res = manaTwo;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return HP;
    }

    public int getStamina() {
        return Mana;
    }

    public void minusHP(int damage) {
        HP -= damage;
    }

    public boolean loser() {
        if (HP < 1 || Mana < 1) {
            return true;
        } else {
            return false;
        }
    }

    public int Action(int a) {
        return 0;
    }

    public void training(int i) {
        switch (i) {
            case 1:
                maxHP += 5;
                Mana -= 10;
                break; //Силовая тренировка - увеличивает максимальное здоровье у покемона.
            case 2:
                maxMana += 5;
                Mana -= 10;
                break; //Тренировка на выносливость - увеличивает максимальную выносливость у покемона.
            case 3:
                damageOne += 3;
                damageTwo += 2;
                Mana -= 10;
                break; //Тренировка на атаку - увеличивает атаку у покемона.
        }
    }

    public void relax() { //При отдыхе здоровье и выносливость восстанавливаются.
        Mana = maxMana;
        HP = maxHP;
    }
}