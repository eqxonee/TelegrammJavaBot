import java.util.Random;

public class GameGuessTheNumber{

    Random random = new Random();

    private int numberOfUser;
    private int numberOfComp;

    public GameGuessTheNumber() {
    }

    public int setNumberOfUser (){
       return numberOfUser;
    }

    public String Begin(){
        return "Game is started!";
    }


    public int setNumberOfComp(){
        numberOfComp = random.nextInt(5);
        return numberOfComp;
    }

    //public void result(){
    //    do {
    //if (numberOfUser == numberOfComp) {
     //           System.out.println("Вы угадали! Компьютер загадал именно число: " + numberOfComp);
     //       } else {
     //           System.out.println("Вы не угадали, попробуйте еще раз!");
     //       }
     //   }while (numberOfUser == numberOfComp);
    //}

}
