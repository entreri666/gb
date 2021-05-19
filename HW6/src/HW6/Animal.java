package HW6;

public abstract class Animal {

    static final int swimFail = 0;
    static final int swimOk = 1;
    static final int swimNone = 2;

    private String type;
    private String name;
    private int maxRun;
    private int maxSwim;

    public static int countAnimals = 0;

    Animal (String type, String name, int maxRun, int maxSwim){
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        ++countAnimals;
    }

    String getType(){

        return this.type;
    }

    String getName(){

        return this.name;
    }

    int getMaxRun(){

        return this.maxRun;
    }

    int getmaxSwim(){

        return this.maxSwim;
    }

    protected boolean run(int distance) {

        return (distance <= maxRun);
    }

    protected int swim(int distance) {

        return (distance <= maxSwim) ? swimOk : swimFail;
    }
}
