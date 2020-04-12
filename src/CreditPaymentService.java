import java.math.*;

public class CreditPaymentService {

    public double CreditPaymentService(long summCredit, int creditTerm) {
        {
            int month = 12;
            int monthTerm = creditTerm * month;                                             // переводим срок кредита в месяцы

            /////// Формула дл расчета кредита: АП = СК * (ПС/12/100) / (1-(1+ПС)^-КП)

            int i1 = 1;                                                                     // Единица необходима для формулы
            BigDecimal rate = new BigDecimal(0.0999);                                   // процентная ставка 9.99%
            BigDecimal rateMonth = rate.divide(BigDecimal.valueOf(month), 6, RoundingMode.HALF_UP);
            //System.out.println("ratemmonth: "+rateMonth);

            // СК * ПС
            BigDecimal summRate = rateMonth.multiply(BigDecimal.valueOf(summCredit));
            //System.out.println("Sumrate: "+summRate);

            // 1 + ПС
            BigDecimal diff = rateMonth.add((BigDecimal.valueOf(i1))).setScale(8, RoundingMode.HALF_UP);
            //System.out.println("diff: " + diff);

            // diff ^-КП
            BigDecimal degree = diff.pow(-monthTerm, MathContext.DECIMAL64);
            //System.out.println("degree: " + degree);

            // 1 - degree
            BigDecimal divider = (new BigDecimal(i1)).subtract(degree);
            //System.out.println("divider: " + divider);

            // Payment
            BigDecimal payment = summRate.divide(divider, 2, RoundingMode.HALF_UP);
            //System.out.println("Сумма ежемесячного платежа, составит: " + payment);
            double pays = payment.doubleValue();

            return pays;

        }

    }
}