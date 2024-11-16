package Chuong3_Class_Object;



public class GuessGame {
    Player p1, p2,p3; // tao ra 3 bien tham chieu kieu Player
    int numberToGuess = (int)(Math.random()*10);
    public void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;
        boolean isGameOver = false;
        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;
        while (!isGameOver) {
            System.out.println("Number to guess is: " + numberToGuess);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Player one guessed " + guessp1);
            guessp2 = p2.number;
            System.out.println("Player two guessed " + guessp2);
            guessp3 = p3.number;
            System.out.println("Player three guessed " + guessp3);
            if (guessp1 == numberToGuess) {
                p1isRight = true;
                System.out.println("Player one wins!");
                isGameOver = true;
            }
            if (guessp2 == numberToGuess) {
                p2isRight = true;
                System.out.println("Player two wins!");
                isGameOver = true;
            }
            if (guessp3 == numberToGuess) {
                p3isRight = true;
                System.out.println("Player three wins!");
                isGameOver = true;
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}
