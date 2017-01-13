import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        pokemaster trainer1 = new pokemaster();
        pokemaster trainer2 = new pokemaster();

        Pokemon pikachu = Pikachu.get();
        Pokemon bulbasaur = Bulbasaur.get();
        Pokemon psyduck = Psyduck.get();
        Pokemon beedrill = Beedrill.get();

        trainer1.addPokemon(bulbasaur);
        trainer1.addPokemon(pikachu);

        trainer2.addPokemon(psyduck);
        trainer2.addPokemon(beedrill);


        System.out.println("Первый игрок выбирает покемона\r\n" + trainer1.toString());
        int first = in.nextInt() - 1;
        System.out.println("Второй игрок выбирает покемона\r\n" + trainer2.toString());
        int second = in.nextInt() - 1;
        Battle fight = new Battle(first, second, trainer1, trainer2);
        while (fight.isNotEnd()) {
            System.out.println("\r\nПервый тренер выбирает атаку, покемон " + fight.FirstPokemon().getName());
            System.out.println("1.Основная атака, Урон = " + fight.FirstPokemon().getDamage(1) +
                    ", Расход маны = " + fight.FirstPokemon().getStaminaI(1));
            System.out.println("2.Специальная атака, Урон = " + fight.FirstPokemon().getDamage(2) +
                    ", Расход маны = " + fight.FirstPokemon().getStaminaI(2));

            fight.action(1,in.nextInt()); //ход первого игрока

            System.out.println("\r\n Результаты атаки \r\n"+ fight.FirstPokemon().getName() +
                    " - Здоровье: " + fight.FirstPokemon().getHealth() +
                    " Мана: " + fight.FirstPokemon().getStamina());
            System.out.println(fight.SecondPokemon().getName() +
                    " - Здоровье: " + fight.SecondPokemon().getHealth() +
                    " Мана: " + fight.SecondPokemon().getStamina());

            System.out.println("\r\nВторой тренер выбирает атаку, покемон " + fight.SecondPokemon().getName());
            System.out.println("1.Основная атака, Урон = " + fight.SecondPokemon().getDamage(1) +
                    ", Расход маны = " + fight.SecondPokemon().getStaminaI(1));
            System.out.println("2.Специальная атака, Урон = " + fight.SecondPokemon().getDamage(2) +
                    ", Расход маны = " + fight.SecondPokemon().getStaminaI(2));

            fight.action(2, in.nextInt()); //ход второго игрока

            System.out.println("\r\n Результаты атаки \r\n" + fight.FirstPokemon().getName() +
                    " - Здоровье: " + fight.FirstPokemon().getHealth() +
                    " Мана: " + fight.FirstPokemon().getStamina());
            System.out.println(fight.SecondPokemon().getName() +
                    " - Здоровье: " + fight.SecondPokemon().getHealth() +
                    " Мана: " + fight.SecondPokemon().getStamina());
        }

        System.out.println("ПОБЕДИЛ " + fight.winner().getName());

        //Тренировка
        trainer1.getPokemon(1).training(1);
        trainer2.getPokemon(0).training(2);
        trainer2.getPokemon(1).training(3);
        trainer2.getPokemon(0).training(1);

        //Отдых
        trainer1.getPokemon(0).relax();
    }
}
