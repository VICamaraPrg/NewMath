package newmath.rational;

import newmath.numbertheory.Utils;

/**
 * @author VICamaraPRG
 * @version 1.0
 * @since 1.0
 */
public class Fraction {

    private int numerator, denominator;
    private double value;

    /**
     * Constructor class to create a new fraction.
     *
     * @param number any decimal number to transform it to a fraction.
     * @since 1.0
     */
    public Fraction(double number) {
        this.value = number;
        String numberStr = String.valueOf(number);
        int digitDecimal = (numberStr.length() - 1) - numberStr.indexOf(".");
        int denominator = 1;

        for (int i = 0; i < digitDecimal; i++) {
            denominator *= 10;
            number *= 10;
        }

        int numerator = (int) Math.round(number);
        int gcd = Utils.greatestCD(numerator, denominator);
    }

    /**
     * Constructor class to create a new fraction.
     *
     * @param numerator   an {@code int} to express the numerator of the fraction.
     * @param denominator an {@code int} to express the denominator of the fraction.
     * @since 1.0
     */
    public Fraction(int numerator, int denominator) {

        this.denominator = denominator;
        this.numerator = numerator;
    }

    /**
     * Simplifies a fraction as the lowest rational number as possible.
     * {@code 4/20 into 1/5}
     *
     * @since 1.0
     */
    public void simplify() {
        int gcd = Utils.greatestCD(this.getNumerator(), this.getDenominator());

        this.denominator = (this.getDenominator() / gcd);
        this.numerator = (this.getNumerator() / gcd);
    }

    /**
     * Returns the numerator part of a fraction.
     *
     * @return {@code int} value as the numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Returns the denominator part of a fraction.
     *
     * @return {@code int} value as the denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Returns a readable fraction as String, {@code example: 4/3}.
     *
     * @return {@code String} as the fraction returned.
     */
    @Override
    public String toString() {
        return (String.valueOf(numerator) + "/" + String.valueOf(denominator));
    }
}
