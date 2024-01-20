class prac {
    int iv;
    static int cv;

    static {
        System.out.println("static initializer");
        cv = 100;
    } 
    {
        System.out.println("instance initializer");
        iv = 100;
    }

    public prac() {
        System.out.println("생성자" + iv + cv);
        this.iv = 300;
    }

    public static void main(String[] args) {
        prac it = new prac();
        System.out.println(cv+it.iv);
        prac it2 = new prac();
        System.out.println(cv + it2.iv);
    }
}