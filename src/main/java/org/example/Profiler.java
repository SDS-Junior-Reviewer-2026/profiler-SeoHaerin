package org.example;
import java.util.ArrayList;
import java.lang.reflect.Method;

public class Profiler {
    // TODO : Profiler 구현

    private ArrayList<Integer> input;
    private ArrayList<Integer> result;
    private Object lib;
    private String methodName;

    public void setData(ArrayList<Integer> data) {
        this.input = new ArrayList<>(data);
    }

        public void setLib(Object lib) {
            this.lib = lib;

            this.methodName = lib.getClass().getSimpleName();
            this.methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);
            System.out.println("method name: " + methodName);
        }

        public void runLib() {
            try {
                //Method sort = lib.getClass().getMethod("selectionSort", ArrayList.class);
                Method sort = lib.getClass().getMethod(methodName, ArrayList.class);
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
