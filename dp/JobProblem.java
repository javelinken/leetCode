package com.algor.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: MaiJinQiang
 * @Date: 2020/8/19 14:44
 */
public class JobProblem {

    public static void main(String[] args) {
        ArrayList<Rw> rws = new ArrayList<>();
        Test1 test1 = new Test1();
        rws.add(test1.new Rw(0, 0, 0));
        rws.add(test1.new Rw(1, 4, 5));
        rws.add(test1.new Rw(3, 5, 1));
        rws.add(test1.new Rw(0, 6, 8));
        rws.add(test1.new Rw(4, 7, 4));
        rws.add(test1.new Rw(3, 8, 6));
        rws.add(test1.new Rw(5, 9, 3));
        rws.add(test1.new Rw(6, 10, 2));
        rws.add(test1.new Rw(8, 11, 4));

        int[] prevs = new int[9];
        for (int i = 8; i > 0; i--) {
            int j = i - 1;
            for (; j > 0; j--) {
                if (rws.get(j).end <= rws.get(i).start) {
                    break;
                }
            }
            prevs[i] = j;
        }

        System.out.println(Arrays.toString(prevs));

        int[] opts = new int[9];
        opts[1] = rws.get(1).getValue();

        for (int i = 2; i < 9; i++) {
            opts[i] = Math.max(opts[i - 1], rws.get(i).getValue() + opts[prevs[i]]);
        }

        System.out.println(Arrays.toString(opts));

    }

    class Rw {
        private int start;
        private int end;
        private int value;

        Rw(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
