package DesignPatterns;

public class Factory {


    public static <T extends IBase> T getChild(FactoryType factoryType) {

        IBase kid = null;

        switch (factoryType) {
            case BOY:
                kid = new Child();
                break;
            case GIRL:
                kid = new Child();
                break;
            default:
                System.out.println("Invalid Factory Type: " + factoryType);
                break;
        }

        return (T) kid;
    }

    public enum FactoryType {
        BOY, GIRL
    }

}
