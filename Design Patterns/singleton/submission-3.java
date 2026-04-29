static class Singleton {
    private static Singleton uniqueInstance = null;

    private String state = null;

    private Singleton() {
        this.state = "Some String";
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }

    public String getValue() {
        return this.state;
    }

    public void setValue(String value) {
        this.state = value;
    }
    
}
