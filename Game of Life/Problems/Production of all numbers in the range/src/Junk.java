import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class Junk {
    public static void main(String[] args) {
        //int num = 0;
        //System.out.println(num);
        System.out.println(junk());
    }

    // b -
    private static int junk() {
        PathMatcher matcher = path -> false;

        return 0;
    }
}
