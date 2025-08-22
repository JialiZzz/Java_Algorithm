public class Constructor {

    private int atrribute;
    private int atrribute2;

    public Constructor(int atrribute, int atrribute2) {
        this.atrribute = atrribute;
        this.atrribute2 = atrribute2;
    }
//允许多个constructer 存在 是允许各种参数
    public Constructor(float atrribute) {
        this.atrribute = (int)atrribute;
    }

    public Constructor(int atrribute) {
        this.atrribute = atrribute;
    }

    public Constructor() {
    }

    public static void main(String[] args) {
        Constructor constructor = new Constructor();
        Constructor constructor2 = new Constructor(2,3);
        Constructor constructor3 = new Constructor(4);
        Constructor constructor4 = new Constructor(4.55f);


    }


}
