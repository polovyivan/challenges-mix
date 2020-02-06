
public class EnumExample {
    public static void main(String[] args) {
        String winter = SimpleEnumExample.WINTER.toString();
        System.out.println("winter = " + winter);
        for (SimpleEnumExample enumExample : SimpleEnumExample.values()) {
            System.out.println("enumExample = " + enumExample);
            System.out.println("enumExample.ordinal() = " + enumExample.ordinal());
        }

        // enum with constructor example
        // can be only private and called once on load
        EnumWithConstructors.AUTUMN.printExpectedVisitors();
        String expectedVisitors = EnumWithConstructors.AUTUMN.getExpectedVisitors();
        System.out.println("expectedVisitors String = " + expectedVisitors);


        // enum with concrete method
        // default implementation
        EnumWithMethod.AUTUMN.printHours();
        //overridden
        EnumWithMethod.WINTER.printHours();

        // enum with abstract method
        EnumWithAbstractMethod.WINTER.printHours();
        EnumWithAbstractMethod.SPRING.printHours();


    }
}


enum SimpleEnumExample {
    WINTER, SPRING, SUMMER, AUTUMN
}


enum EnumWithConstructors {
    WINTER("Low"), SPRING("Medium"),
    SUMMER("High"), AUTUMN("Medium");

    private String expectedVisitors;

    EnumWithConstructors(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println("expectedVisitors = " + expectedVisitors);
    }

    public String getExpectedVisitors() {
        return expectedVisitors;
    }

}

enum EnumWithMethod {
    WINTER {
        public void printHours() {
            System.out.println("Winter hours ");
        }
    }, SPRING, SUMMER, AUTUMN;


    public void printHours() {
        System.out.println("Default hours ");
    }
}


enum EnumWithAbstractMethod {
    WINTER {
        public void printHours() {
            System.out.println("Winter hours ");
        }
    }, SPRING {
        public void printHours() {
            System.out.println("Spring hours ");
        }
    }, SUMMER {
        public void printHours() {
            System.out.println("Summer hours ");
        }
    }, AUTUMN {
        public void printHours() {
            System.out.println("Autumn hours ");
        }
    };


    public abstract void printHours();
}