// Week 3 To Build Builder class for Computer 
// Builder class is used for constructing objects step by step.


public class Computer{
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;
    private boolean isGraphicsCardPresent;
    // It should have preivate constructor 
    private Computer(Builder builder){
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.storage=builder.storage;
        this.GPU=builder.GPU;
        this.isGraphicsCardPresent=builder.isGraphicsCardPresent;
    }
    // static nested inner class Builder
    public static class Builder{
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;
        private boolean isGraphicsCardPresent=false;
        public Builder(String CPU,String Ram){
            this.CPU=CPU;
            this.RAM=Ram;
        }
        public Builder setGPU(String GPU){
            this.GPU=GPU;
            return this;
        }
        public Builder setStorage(String storage){
            this.storage=storage;
            return this;
        
        }
        public Builder setGraphicsCardPresent(boolean isGraphicsCardPresent){
            this.isGraphicsCardPresent=isGraphicsCardPresent;
            return this;
        }
        // Build method to return the instance of Computer
        public Computer build(){
            return new Computer(this);

        }

    }
    @Override
    public String toString(){
        return "Computer :" +
                "\nCPU= " +CPU+
                "\nRAM= " +RAM+
                "\nStroage+ " +storage+
                "\nGPU= " +GPU+
                "\nDoes Graphics Card Present? " +(isGraphicsCardPresent? "Yes" : "Nope");
                
    }
}