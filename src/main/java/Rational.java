class Rational {
    long numerator,denominator;

    class Illegal extends Exception {
        String reason;
        Illegal (String reason) {
            this.reason = reason;
        }
    }

    Rational() {
        // to be completed
        this.numerator = 0;
        this.denominator = 1;
    }

    Rational(long numerator, long denominator) throws Illegal {
        // to be completed
        this.numerator = numerator;
        if(denominator == 0) throw new Illegal("Denominator==0");
        this.denominator = denominator;
    }

    // find the reduce form
    private void simplestForm() {
        long computeGCD;
        computeGCD = GCD(Math.abs(numerator), denominator);
        numerator /= computeGCD;
        denominator /= computeGCD;
    }

    // find the greatest common denominator
    private long GCD(long a, long b) {
        if (a%b ==0) return b;
        else return GCD(b,a%b);
    }

    /***
     * Compute an addition of the current rational number to another given rational number
     * @param x the rational number to be added to the current rational number
     */
    public void add(Rational x) {
        if(x.denominator == 0) return;

        numerator = (numerator * x.denominator) + (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a subtraction of the current rational number to another given rational number
     * @param x the rational number to be subtracted from the current rational number
     */
    public void subtract(Rational x) {
        // to be completed
        if (x.denominator==0) return;

        numerator = (numerator * x.denominator) - (x.numerator * denominator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a multiplication of the current rational number to another given rational number
     * @param x the rational number to be multiplied to the current rational number
     */
    public void multiply(Rational x) {
        // to be completed
        if (x.denominator == 0) return;

        numerator = (numerator * x.numerator);
        denominator = (denominator * x.denominator);
        simplestForm();
    }

    /***
     * Compute a division of the current rational number to another given rational number
     * @param x the rational number to be divided by the current rational number
     */
    public void divide(Rational x) {
        // to be completed
        if(x.denominator == 0) return; // Should be illegal even before we flip to multiply(?)

        numerator = (numerator * x.denominator);
        denominator = (denominator * x.numerator);
        simplestForm();
    }

    /***
     * Check if the given rational number equals to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return true if the given rational number equals to the current, false otherwise
     */
    public boolean equals(Object x) {
        Rational n = (Rational) x;
        n.simplestForm();
        long x_nume = n.numerator;
        long x_denu = n.denominator;
        simplestForm();
        return numerator == x_nume && denominator == x_denu;

        // to be completed
// TODO: This needs to be modified.
    }

    /***
     * Compare the current rational number to the current rational number
     * @param x the rational number to be compared to the current rational number
     * @return -1 if the current rational number is less than the given number, 0 if they're equal, 1 if the current
     * rational number is larger than the given number
     */
    public long compareTo(Object x) {
        // to be completed
        Rational n = (Rational) x;
        n.simplestForm();
        simplestForm();
        /*
        We have two fractions a/b and c/d.
        Let Y = (a/b - c/d)
              = (ad - bc)/(bd)
        Now,
        if Y > 0 then a/b > c/d
        if Y = 0 then a/b = c/d
        if Y < o then a/b < c/d

        Since bd is always positive, the sign of Y depends only on the
        numerator (ad-bc). So we need to compute (ad-bc) only.
         */
        long a = numerator;
        long b = denominator;
        long c = n.numerator;
        long d = n.denominator;
        long ad = a*d;
        long bc = b*c;
        long y = ad - bc;
        /*
        if Y > 0 then a/b > c/d
        if Y = 0 then a/b = c/d
        if Y < o then a/b < c/d
         */
        if(y > 0) return 1;
        else if(y == 0) return 0;
        else
            return -1;

    }

    /***
     * Give the formatted string of the rational number
     * @return the string representation of the rational number. For example, "1/2", "3/4".
     */
    public String toString() {
        // to be completed
        simplestForm();
        return numerator + "/" + denominator; // TODO: This needs to be modified.
    }

    public static void main(String[] args) {
        System.out.println("This is Rational class.");
    }
}