class prac {
    public static void main(String[] args) {
        int[] arr = {10};

        try {
            System.out.println(arr[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // System.out.println(e.);
            e.printStackTrace();
        }
        System.out.println("프로그램 종료");
    }
}