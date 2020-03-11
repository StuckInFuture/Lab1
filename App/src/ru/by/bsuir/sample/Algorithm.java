package ru.by.bsuir.sample;

final public class Algorithm {
    int a;

    public Algorithm(){};
    public static String findRoot(int firstterm, int summ, int beg, int end) {
        String resultAns = "";
        int res = 0;
        int x;
        boolean flag = false;
        int i1, i2;
        if (beg < end) {
            i1 = beg;
            i2 = end;
        } else {
            i2 = beg;
            i1 = end;
        }
        for (int i = i1; i <= i2; i++) {
            x = i;
            if (x + firstterm == summ) {
                res = x;
                flag = true;
            }
        }
        if (flag) resultAns = String.valueOf(res);
        else {
            resultAns = "Нет корней!";
        }

        return resultAns;
    }

}
//collection utilies

//Throwable