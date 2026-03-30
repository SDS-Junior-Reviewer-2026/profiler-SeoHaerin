package org.example;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class Profiler {
    // TODO : Profiler 구현

        private ArrayList<Integer> input;
        private ArrayList<Integer> result;
        private Object lib;

        public void setData(ArrayList<Integer> data) {
            this.input = new ArrayList<>(data); // 원본 보호
        }

        public void setLib(Object lib) {
            this.lib = lib;

        }

        public void runLib() {
            try {
                Method sort = lib.getClass().getMethod("selectionSort", ArrayList.class);
                result = (ArrayList<Integer>) sort.invoke(lib, new ArrayList<>(input));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void showResult() {
            try {
                Method countMethod = lib.getClass().getMethod("getChangeCnt");
                int cnt = (int) countMethod.invoke(lib);

                //System.out.println(lib.getClass().getSimpleName() + " 테스트");
                System.out.println("swap횟수: " + cnt + "회");
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
