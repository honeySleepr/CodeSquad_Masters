package cs07;

public class MyThread extends Thread{
    MyProcess myProcess;

    public MyThread(MyProcess myProcess){
        this.myProcess = myProcess;
    }
    // 각 스레드마다 1초씩 sleep 하도록 하였지만
    // 스레드가 여러개 실행되는 단계에서도 총 실행 시간은 여전히 약 1초이다.
    // 이러면 병렬 처리가 된 것인가??
    @Override
    public void run() {
        myProcess.updateCurrentRunTime();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
