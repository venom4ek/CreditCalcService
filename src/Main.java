import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Введите сумму кредита(от 100000 руб. до 5000000000(5млн) руб.): ");
        Scanner summScan = new Scanner(System.in);

        long summCredit = summScan.nextLong();                                                          // сумма кредита

        while (summCredit > 5_000_000 || summCredit < 100_000) {                                        // проверка введенной суммы
            try {
                System.out.print("Вы ввели не верную сумму кредита. (Необходимо ввести сумму от 100000 руб. до 5000000(5млн) руб.): ");
                summCredit = summScan.nextLong();
            } catch (InputMismatchException ex) {
                //  System.out.println("ERROR");
                summScan.next();
            }
        }

        System.out.print("Введите срок кредитование в годах от 1 до 3 лет: ");
        Scanner termScan = new Scanner(System.in);                                                     // период кредита. от 1 до 3 лет

        int creditTerm = termScan.nextInt();

        while (creditTerm > 3 || creditTerm < 1) {                                                     // проверка введенного срока кредита
            try {
                System.out.print("Вы ввели не верный срок кредита. (Необходимо ввести кол-во лет: 1,2 или 3): ");
                creditTerm = termScan.nextInt();
            } catch (InputMismatchException ex) {
                //  System.out.println("ERROR");
                termScan.next();
            }
        }

        CreditPaymentService calculate = new CreditPaymentService();
        double calc = calculate.CreditPaymentService(summCredit, creditTerm);
        System.out.println("Сумма ежемесячного платежа составит: " + calc);

    }
}
