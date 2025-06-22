public class TestBuilderPattern{
    public static void main(String[] args){
        // Going to constrct Computer with some confi
        Computer Basiccomp=new Computer.Builder("AMD 5i","32GB")
                .setStorage("512GB SSD")
                .build();
        System.out.println("Basic Computer Config : " );
        System.out.println(Basiccomp);
        System.out.println("..........................................");
        // building a gaming computer with some more configuration 
        Computer Gamingcomp=new Computer.Builder("Inter i9","64GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA 3080")
                .setGraphicsCardPresent(true)
                .build();
        System.out.println("Gaming Computer Congig : ");
        System.out.println(Gamingcomp);
        System.out.println("..........................................");
    }
}