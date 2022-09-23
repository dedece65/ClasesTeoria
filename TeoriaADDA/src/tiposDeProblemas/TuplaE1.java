package tiposDeProblemas;

public record TuplaE1(Integer ac, Integer a, Integer b) {
    public static TuplaE1 of(Integer ac, Integer a, Integer b) {
        return new TuplaE1(ac, a, b);
    }
    public static TuplaE1 seed(Integer a, Integer b) {
        return new TuplaE1(0, a, b);
    }

    public TuplaE1 next() {
        return of(this.ac + b / 2, this.a - 2, b);
    }
}