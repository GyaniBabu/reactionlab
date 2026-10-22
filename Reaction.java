
public class Reaction {

    private int constant_a;
    private int constant_b;
    private int constant_c;
    private int constant_d;
    private double initial_a;
    private double initial_b;
    private boolean reacted = false;
    private String reactant_A;
    private String reactant_B;
    private String product_C;
    private String product_D;

    private double final_a;
    private double final_b;
    private double final_c;
    private double final_d;

    public Reaction(int constant_a, String reactant_A,
            int constant_b, String reactant_B,
            int constant_c, String product_C,
            int constant_d, String product_D,
            double initial_a, double initial_b) { // aA + bB = cC + dD

        this.constant_a = constant_a;
        this.constant_b = constant_b;
        this.constant_c = constant_c;
        this.constant_d = constant_d;
        this.initial_a = initial_a;
        this.initial_b = initial_b;
        this.reactant_A = reactant_A;
        this.reactant_B = reactant_B;
        this.product_C = product_C;
        this.product_D = product_D;

    }

    public Reaction(int constant_a, String reactant_A,
            int constant_b, String reactant_B,
            int constant_c, String product_C,
            int constant_d, String product_D) { // aA + bB = cC + dD

        this.constant_a = constant_a;
        this.constant_b = constant_b;
        this.constant_c = constant_c;
        this.constant_d = constant_d;
        this.reactant_A = reactant_A;
        this.reactant_B = reactant_B;
        this.product_C = product_C;
        this.product_D = product_D;

    }

    public void addReactants(double initial_a, double initial_b) {
        this.initial_a = initial_a;
        this.initial_b = initial_b;
    }

    public double extent() {
        double reaction_extent = Math.min(initial_a / constant_a, initial_b / constant_b);
        return reaction_extent;
    }

    public void react() {
        this.final_a = initial_a - constant_a * this.extent();
        this.final_b = initial_b - constant_b * this.extent();
        this.final_c = constant_c * this.extent();
        this.final_d = constant_d * this.extent();
        this.reacted = true;
    }

    public double finalAmount(String species) {
        if (this.reacted == false) {
            this.react();
        }
        if (species.equalsIgnoreCase(reactant_A)) {
            return final_a;
        } else if (species.equalsIgnoreCase(reactant_B)) {
            return final_b;
        } else if (species.equalsIgnoreCase(product_C)) {
            return final_c;
        } else if (species.equalsIgnoreCase(product_D)) {
            return final_d;
        } else {
            throw new IllegalArgumentException("Species not found");
        }
    }

    public void report() {
        this.react();
        System.out.println("-------------------------");

        System.out.print("Reaction:\n" + this.constant_a + this.reactant_A + " + " + this.constant_b + this.reactant_B
                + " --> " + this.constant_c + this.product_C + " + " + this.constant_d + this.product_D + "\n");
        System.out.println("-------------------------");
        System.out.println(this.reactant_A + " entered: " + this.initial_a + " mol");
        System.out.println(this.reactant_B + " entered: " + this.initial_b + " mol");
        System.out.println("-------------------------");
        System.out.println(this.reactant_A + " left: " + this.final_a);
        System.out.println(this.reactant_B + " left: " + this.final_b);
        System.out.println(this.product_C + " produced: " + this.final_c);
        System.out.println(this.product_D + " produced: " + this.final_d);
        System.out.println("-------------------------");

    }

    public static void main(String[] args) {

        // 1. Operation Iron Rain
        Reaction Thermite = new Reaction(
                1, "Fe2O3",
                2, "Al",
                2, "Fe",
                1, "Al2O3",
                3, 4
        );
        Thermite.report();

        // 2. Project Methane
        Reaction Sabatier = new Reaction(
                1, "CO2",
                4, "H2",
                1, "CH4",
                2, "H2O",
                2, 5
        );
        Sabatier.report();

        // 3. Operation Purple Fade
        Reaction Iodine = new Reaction(
                2, "Na2S2O3",
                1, "I2",
                1, "Na2S4O6",
                2, "NaI",
                5, 3
        );
        Iodine.report();

        // 4. Operation Fool's Gold
        Reaction Pyrite = new Reaction(
                4, "FeS2",
                11, "O2",
                2, "Fe2O3",
                8, "SO2",
                3, 10
        );
        Pyrite.report();

        // 5. Operation Copper Resurrection
        Reaction Copper = new Reaction(
                1, "CuO",
                1, "H2",
                1, "Cu",
                1, "H2O",
                7, 5
        );
        Copper.report();
    }

}
