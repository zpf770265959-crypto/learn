import java.util.Scanner;

public class shangpin {

    public static class wupin {
        int redu;
        int xiaoliang;

        public wupin(int redu, int xiaoliang) {
            this.redu = redu;
            this.xiaoliang = xiaoliang;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        wupin[] x = new wupin[m];

        for (int i = 0; i < m; i++) {
            int redu = sc.nextInt();
            int xiaoliang = sc.nextInt();
            x[i] = new wupin(redu, xiaoliang);
        }

        quick(x, 0, x.length - 1);

        for (int i = 0; i < n && i < m; i++) {
            System.out.println(x[i].redu + " " + x[i].xiaoliang);
        }
    }

    public static void quick(wupin[] x, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = part(x, left, right);

        quick(x, left, p - 1);
        quick(x, p + 1, right);
    }

    public static int part(wupin[] x, int left, int right) {
        wupin index = x[left];

        while (left < right) {
            while (left < right &&
                    (x[right].redu < index.redu ||
                            (x[right].redu == index.redu && x[right].xiaoliang <= index.xiaoliang))) {
                right--;
            }

            x[left] = x[right];

            while (left < right &&
                    (x[left].redu > index.redu ||
                            (x[left].redu == index.redu && x[left].xiaoliang >= index.xiaoliang))) {
                left++;
            }

            x[right] = x[left];
        }

        x[left] = index;

        return left;
    }
}