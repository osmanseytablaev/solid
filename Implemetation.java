import java.util.List;

/**
 * Interface of printing for abstraction
 */
interface PrintInterface {
    public String print();
}

/**
 * For printer setup
 */
class SetUp {
    public String setUp() { 
        return "The document chosen.";
    }
}

/**
 * For intiating Normal printing
 */
class Print implements PrintInterface {
    @Override
    public String print() {
        return "Document printed.";
    }
}

/**
 * For intiating Cloud printing
 */
class CloudPrint implements PrintInterface {
     @Override
     public String print() {
        return "Document clouded.";
    }
}

/**
 * For processing setup and any ptint type
 */
class DocumentService {
    private final SetUp setup;
    private final List<PrintInterface> printers;

    DocumentService(SetUp setup, List<PrintInterface> printers) {
        this.setup = setup;
        this.printers = printers;
    }
    void process() {
        System.out.println(setup.setUp());
        for (PrintInterface p : printers) {
            System.out.println(p.print());
        }
    }
}

/**
 * For running the process
 */
public class Implemetation {
    public static void main(String[] args) {
        SetUp setup = new SetUp();
        List<PrintInterface> outs = List.of(
                new Print(),
                new CloudPrint()
        );

        new DocumentService(setup, outs).process();
    }
}
