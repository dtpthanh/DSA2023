package main.week2.exercise;

import edu.princeton.cs.algs4.*;

public class Sum {
    public static void main(String[] args) {
        In in = new In("D:\\GiangDay\\2324I\\CTDLGT\\algs4-data\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        // xử lý dữ liệu trong mảng a
        StdArrayIO.print(a); // in mảng ra màn hình

        int N = a.length;
        UF uf = new UF(N);

        for (int i = 0; i < N; i++) {
            int num = a[i];
            int opposite = -1 * num;

            if (opposite >= 0 && opposite < N && uf.connected(i, opposite)) {

                StdOut.println(num + " " + opposite);
            } else {

                uf.union(i, num);
            }

        }
    }
}
