class prac {
    public static void main(String[] args) {
        int[] start = {1,1};
        int[] end = {2,2};

        int a = Math.abs(start[0] - end[0]);
        int b = Math.abs(start[1] - end[1]);

        double r = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        double radian = Math.atan2(b,a);

        System.out.println(radian);
        // double angle = 
        System.out.println(Math.toDegrees(radian));
    }
}