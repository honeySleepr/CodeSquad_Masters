package cs08;

public enum Message {
    MENU("> 1. 아메리카노(3s)   2. 카페라떼(5s)  3. 프라프치노(10s)"),
    INITMESSAGE("> 주문할 음료를 입력하세요. 예) 아메리카노 2개 => 1:2"),
    PROMPT("> "),
    NOMOREORDER("3초 동안 주문 없어서 영업 종료!"),
    START(" 시작!! "),
    COMPLETE(" 완성!! ");

    private final String message;

    Message(String message){
        this.message = message;
    }

    protected String getMessage(){
        return this.message;
    }

    @Override
    public String toString() {
        return message;
    }
}
