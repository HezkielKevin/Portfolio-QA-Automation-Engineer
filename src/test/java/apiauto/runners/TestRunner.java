package apiauto.runners;

import org.testng.TestNG;
import org.testng.TestListenerAdapter;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        // Inisialisasi TestNG
        TestNG testng = new TestNG();

        // listener untuk laporan default
        TestListenerAdapter tla = new TestListenerAdapter();
        testng.addListener(tla);

        // Tentukan file testng.xml
        testng.setTestSuites(List.of("src/test/resources/testng.xml"));

        // Jalankan pengujian
        testng.run();

        // Cetak lokasi laporan
        System.out.println("Laporan pengujian tersedia di: test-output/index.html");
    }
}