// baekjoon 기적의 매매법_실버5
// 메모리 14164 kb	성능 104 ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cashJH = Integer.parseInt(br.readLine());
        int cashSM = cashJH;
        int stocks[] = new int[14];
        int cntJH = 0, cntSM = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());

            // 준현
            if (cashJH >= stocks[i]) {
                cntJH += cashJH / stocks[i];
                cashJH = cashJH % stocks[i];
//                System.out.printf("JH %d일 %d주 매수", i, cntJH);
//                System.out.println();
            }
        }

        // 성민
        int state = 0; // 0 : 감소, 1 : 증가
        int days = 0;
        for (int i = 1; i < 14; i++) {
            int today = stocks[i];
            int yesterday = stocks[i - 1];
            if (state == 0) {
                if (today < yesterday) {
                    days++;
                    if (days >= 3) {
//                        System.out.printf("SM %d일 %d주 매수, 이전현금 %d원", i, cashSM / stocks[i], cashSM);
//                        System.out.println();
                        cntSM += cashSM / stocks[i];
                        cashSM = cashSM % stocks[i];
                    }
                }
                else if (today > yesterday) {
                    state = 1;
                    days = 1;
                }
                else days = 0;
            }
            else if (state == 1) {
                if (today > yesterday) {
                    days++;
                    if (days >= 3) {
//                        System.out.printf("SM %d일 %d주 매도, 이전현금 %d원", i, cntSM, cashSM);
//                        System.out.println();
                        cashSM += cntSM * stocks[i];
                        cntSM = 0;
                    }
                }
                else if (today < yesterday) {
                    state = 0;
                    days = 1;
                }
                else days = 0;
            }
        }

        int resJH = cashJH + cntJH * stocks[13];
        int resSM = cashSM + cntSM * stocks[13];
//        System.out.println(resJH);
//        System.out.println(resSM);
        if (resJH > resSM) System.out.println("BNP");
        else if (resJH < resSM) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}
